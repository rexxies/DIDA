package servlets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.InputStream;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckUserServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * Will process the data received from the Midlet on the lock.
	 * the Midlet will send user data collected from a RFID reader.
	 * The method used to get to this servlet is the include. so this servlet must return to the midlet
	 * that invoked the method.
	 * 
	 * This method will get the data from request and check in database if user has access to the door.
	 * Data that must be send : IPaddress of lock, name of lock, userID, userKey, user accesslevel.
	 * 
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lockName, ip, location, userName, key="123";
		int userID=0, userAccessLevel = 0;
		boolean expired = true, accessGranted = false;
		PrintWriter out = response.getWriter();

		//collect data from request
		Reader in = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

		StringBuilder sb = new StringBuilder();
		for (int c; (c = in.read()) >= 0;)
			sb.append((char)c);

		String req = sb.toString().trim();
		System.out.println("\nData from request" + req);

		String splitString = req.toString();
		String delim = "[\\s,\\[\\]]+";
		String[] data = splitString.split(delim);
		
		location = data[1];
		ip = data[2];
		lockName = data[3];
		userName = data[4];

		userID = Integer.parseInt(userName);
		try {
			//connect to the database to see if user is valid
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/remotekeyDB?"+ "user=root&password=reggae12");
			PreparedStatement pst = dbConn.prepareStatement("SELECT User_Rights FROM Users WHERE User_ID=?");
			pst.setInt(1, userID);
			ResultSet rs = pst.executeQuery(); 

			if(rs.next()){	
				System.out.println("User "+ userID + " is valid");
				userAccessLevel = rs.getInt("User_Rights");

				System.out.println("user accesslevel = "+ userAccessLevel+ ", IP= "+ ip);

				//user access level must me equal or greater than DB. else deny access.
				//http://stackoverflow.com/questions/8444570/using-an-if-statement-in-a-mysql-select-query
				pst = dbConn.prepareStatement("SELECT AccessLevel FROM Locks WHERE IP=?");
				pst.setString(1, ip);
				rs = pst.executeQuery();

				if(rs.next()){
					if(userAccessLevel >= rs.getInt("AccessLevel")){
						System.out.println("User + accesslevel for lock is valid. ACCESS GRANTED");
						dbConn.close();
						accessGranted = true;
						out.println(accessGranted + "yesopen");
					}
					else { 				
						pst = dbConn.prepareStatement("SELECT Lock_Key FROM Locks WHERE IP=? and Lock_Name=? and Lock_Key=? ");
						pst.setString(1, ip);
						pst.setString(2, lockName);
						pst.setString(3, key);
						rs = pst.executeQuery();

						if(rs.next()){
							System.out.println("User + key is valid. ACCESS GRANTED");
							accessGranted = true;
							dbConn.close();
							out.println(accessGranted + "yesopen");
						}
						else {
							System.out.println("User does not have acces to this lock. ACCESS DENIED");
							dbConn.close();
							out.println("User does not have acces to this lock. ACCESS DENIED");
						}
					}
				}
				else {
					System.out.println("IP unknown not valid. ACCESS DENIED");
					dbConn.close();
					out.println(accessGranted+"IP unknown not valid. ACCESS DENIED");
				}
			}
			else {
				System.out.println("User invalid. ACCESS DENIED");
				dbConn.close();
				out.println("User invalid. ACCESS DENIED");
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("error ClassNotFountException");
			e.printStackTrace();
		}
		catch (MySQLIntegrityConstraintViolationException e){
			System.out.println("shit went wrong: MySQLIntegrityConstraintViolationException");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("fout, SQL Exception");
			e.printStackTrace();
		}
	}
}
