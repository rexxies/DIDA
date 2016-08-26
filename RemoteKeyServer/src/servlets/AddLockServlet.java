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

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

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
 * Servlet implementation class AddLockServlet
 */
@WebServlet("/AddLockServlet")
public class AddLockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddLockServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lockName = request.getParameter("lockName");
		String IP = request.getParameter("ipAddress");
		String key = request.getParameter("key");
		int accesLevel = Integer.parseInt(request.getParameter("accesLevel"));
		Boolean enabled = Boolean.parseBoolean(request.getParameter("enabled"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/remotekeyDB?"+ "user=root&password=reggae12");
			PreparedStatement pst = dbConn.prepareStatement("INSERT INTO Locks VALUES(?,?,?,?,?)");
			pst.setString(1, lockName);
			pst.setString(2, IP);
			pst.setString(3, key);
			pst.setInt(4, accesLevel);
			pst.setBoolean(5, enabled);
	        pst.executeUpdate();
	        
	        dbConn.close();
	        System.out.println("Added lock: "+lockName+ " on IP: "+IP);
	        request.getRequestDispatcher("/Overview.jsp").forward(request, response);
		}
		catch (ClassNotFoundException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		catch (MySQLIntegrityConstraintViolationException e){
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("fout");
			e.printStackTrace();
		}
	}
}
