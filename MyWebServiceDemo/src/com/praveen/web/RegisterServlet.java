package com.praveen.web;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String DRIVER;
	String URL;
	String USER;
	String PASS;
	String name,email;
	
	java.sql.Connection connection;
	String sql="insert into local_host.register(?,?)";
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("application/json");
		name=request.getParameter("name");
		email=request.getParameter("email");
		System.out.println("From servlet :::: Name: "+name+ ", Email :"+email);
		Properties properties=new Properties();
		try {
			properties.load(getServletContext().getResourceAsStream("/WEB-INF/properties/database.properties"));
			DRIVER= properties.getProperty("DRIVER");	
			URL=properties.getProperty("URL");
			USER=properties.getProperty("USER");
			PASS=properties.getProperty("PASS");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			int a=preparedStatement.executeUpdate();
			if(a==1) {
				
				System.out.println("Data inserted Successfully.");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
