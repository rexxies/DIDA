package servlets;


import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

			//afhandeling Login.jsp DoPost van form
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//retrieve username and password from form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int userRights = 0;
		
			//setup a connection to the DB
		try {
			//define the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//make the connection
			Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/remotekeyDB?"+ "user=root&password=reggae12");
			
			/*Do database stuff
			 * creating a db statement and a result query			
			 */
			PreparedStatement pst = dbConn.prepareStatement("Select User_ID,Password,User_Rights FROM Users WHERE User_ID=? and Password=?");
	        pst.setString(1, username);
	        pst.setString(2, password);
	        ResultSet rs = pst.executeQuery(); 
	        
				//if credentials match
			if(rs.next()){
				System.out.println("Login Correct");
				System.out.println("User ID: " + rs.getString("User_ID") +" Acces Level: "+rs.getString("User_Rights"));	
				userRights = rs.getInt("User_Rights");
				
				request.setAttribute("username", username);
				request.setAttribute("userRights", userRights); 	//user_rights zijn 0, 1, 2 (gebruiker, beheerder, admin)
				
				// last thing = closing the db connection 
				dbConn.close();
				
				session.setAttribute("username", username);
				session.setAttribute("userRights", userRights);
				
				//forward the request and response in a requestDispatcher to Overview.jsp make difference between Admin and Beheer 
				request.getRequestDispatcher("/Overview.jsp").forward(request, response);
				
			} else {
				// closing the DB connection 
				dbConn.close();
				System.out.println("Login Failed For: " +username +" "+ password+" "+ userRights);
				//forward the request and response in a requestDispatcher to Login.jsp
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}	
		} catch (ClassNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("fout");
			e.printStackTrace();
		}
	
	}

}
