package com.tom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import com.tom.model.*;

public class LoginController extends HttpServlet {
	Registration registration = null;
	
	@Override
	// Initialize the system. Get the initial registration set.
	public void init() {
		registration = new Registration();
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException {
		res.setContentType("text/html");
		
		String nextView = "";		
		PrintWriter pw = res.getWriter();
		
		String uname = req.getParameter("un");
		String pwd = req.getParameter("pwd");
		UserBean bean = new UserBean();
		bean.setUsername(uname);
		bean.setPassword(pwd);
		req.setAttribute("bean", bean);
		
		boolean validUser = registration.hasUser(bean);
		
		if (validUser) {
			// Connect to the database
			try {
				Connection con = DatabaseConnection.initializeDatabase();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from emp");
				List<Employee> employees = new ArrayList<>();
				while (rs.next()) {
					employees.add(new Employee(rs.getInt(1), rs.getString("ename"),rs.getInt(3)));
					System.out.println("---------------------------");
					System.out.println("Emp Number " + rs.getInt(1));
					System.out.println("Emp Name " + rs.getString("ename"));
					System.out.println("Emp Salary " + rs.getInt(3));
				}
				req.setAttribute("employees", employees);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##mingyang", "Cogent123");
				Statement st = conn.createStatement()) {					
				ResultSet rs = st.executeQuery("select * from emp_batch48");
				while (rs.next()) {
					System.out.println("---------------------------");
					System.out.println("Emp Number " + rs.getInt(1));
					System.out.println("Emp Name " + rs.getString("ename"));
					System.out.println("Emp Salary " + rs.getInt(3));
				}
				req.setAttribute("queryResult", rs);			
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			// Forward the result to the next view
			nextView = "login-success.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(nextView);
			rd.forward(req, res);
		} else {
			nextView = "index.jsp";
			pw.println("<font color = 'red'>Invalid Username/Password<font>");
			RequestDispatcher rd = req.getRequestDispatcher(nextView);
			rd.include(req, res);
		}	
		//test
		System.out.println("registration: " + registration.hashCode());
		for (String username : registration.registered.keySet()) {
			System.out.println(registration.registered.get(username).toString());
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException {
		doPost(req, res);
	}
}
