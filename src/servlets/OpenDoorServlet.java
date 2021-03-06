package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpenDoorServlet
 */
@WebServlet("/OpenDoorServlet")
public class OpenDoorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenDoorServlet() {
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
		try {
			//define the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//make the connection
			Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/remotekeyDB?"+ "user=root&password=reggae12");
			
			/*Do database stuff
			 * creating a db statement and a result query			
			 */
			PreparedStatement pst = dbConn.prepareStatement("Select IP FROM Lock WHERE Name=?");
	        
			
			ResultSet rs = pst.executeQuery(); 
			
			if(rs.next()){
				//send command to door to open
			}
			request.getRequestDispatcher("/Overview.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("fout");
			e.printStackTrace();
		}
	}

}
