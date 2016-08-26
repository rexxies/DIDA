package servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 * 
 * check voor object to database implementatie link hieronder 
 * http://www.java2s.com/Code/Java/Database-SQL-JDBC/HowtoserializedeserializeaJavaobjecttotheMySQLdatabase.htm
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String className = "";
		String formName = request.getParameter("userName");
		int formUserID = Integer.parseInt(request.getParameter("userID"));
		int formUserRights = Integer.parseInt(request.getParameter("userRights"));
		
		/*User u = new User();
		className = u.getClass().getName();
		u.setName(formName);
		u.setUserID(formUserID);
		u.setUserRights(formUserRights);*/
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/remotekeyDB?"+ "user=root&password=reggae12");
			
			PreparedStatement pst = dbConn.prepareStatement("INSERT INTO Users VALUES(?,?,?,?)");
	        pst.setInt(1, formUserID);
			pst.setString(2, "welkom");
	        pst.setInt(3, formUserRights);
	        pst.setString(4, formName);
	        
	        pst.executeUpdate();
	        
	        dbConn.close();
	        System.out.print("Added user: "+formName+" with id: "+formUserID+ " to database");
	        request.getRequestDispatcher("/Overview.jsp").forward(request, response);
	        /*
	        if(rs.next()){
				System.out.println("User Added to Database");
				System.out.println("User ID: " + rs.getString("User_ID") +" Acces Level: "+rs.getString("User_Rights"));
	        }*/
		} 
		catch (ClassNotFoundException e) {
			System.err.println("Class not found, check Driver");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.err.println("SQLExeption, check SQL statement, or connection");
			e.printStackTrace();
		}
	}

}
