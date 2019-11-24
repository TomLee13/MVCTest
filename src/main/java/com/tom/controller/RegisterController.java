package com.tom.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tom.model.Registration;
import com.tom.model.UserBean;

public class RegisterController extends HttpServlet {
	Registration registration = null;
	
	@Override
	// Initialize the system. Get the initial registration set.
	public void init() {
		registration = Registration.getInstance();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException {
		res.setContentType("text/html");
		
		//String action = req.getParameter("action");
		String nextView = "";
		
		PrintWriter pw = res.getWriter();
		
		String uname = req.getParameter("un");
		String pwd = req.getParameter("pwd");
		String confirmedPwd = req.getParameter("cpwd");
		String fname = req.getParameter("fn");
		String lname = req.getParameter("ln");
		
		//UserBean bean = new UserBean(uname, pwd, fname, lname);
		//req.setAttribute("bean", bean);
		
		boolean duplicate = registration.hasUser(uname);
		
		if (duplicate) {
			nextView = "registration.jsp";
			pw.println("<font color = 'red'>Username existed. Please choose another one.<font>");
			RequestDispatcher rd = req.getRequestDispatcher(nextView);
			rd.include(req, res);
//			nextView = "login-success.jsp";
//			RequestDispatcher rd = req.getRequestDispatcher(nextView);
//			rd.forward(req, res);
		} else {
			if (pwd.equals(confirmedPwd)) {
				UserBean bean = new UserBean(uname, pwd, fname, lname);
				registration.addUser(bean);
				nextView = "index.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(nextView);
				rd.forward(req, res);
			} else {
				res.sendRedirect("LoginController");
				nextView = "registration.jsp";
				pw.println("<font color = 'red'>Password needs to be confirmed.<font>");
				RequestDispatcher rd = req.getRequestDispatcher(nextView);
				rd.include(req, res);
			}
			
		}
		
		
	}
}
