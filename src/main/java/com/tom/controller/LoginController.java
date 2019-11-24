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

public class LoginController extends HttpServlet {
	Registration registration = null;
	
	@Override
	// Initialize the system. Get the initial registration set.
	public void init() {
		registration = Registration.getInstance();
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException {
		res.setContentType("text/html");
		
		String action = req.getParameter("action");
		String nextView = "";
		
		if (action.equals("Login")) {
			PrintWriter pw = res.getWriter();
			
			String uname = req.getParameter("un");
			String pwd = req.getParameter("pwd");
			UserBean bean = new UserBean();
			bean.setUsername(uname);
			bean.setPassword(pwd);
			req.setAttribute("bean", bean);
			
			boolean validUser = registration.hasUser(bean);
			
			if (validUser) {
				nextView = "login-success.jsp";
				RequestDispatcher rd = req.getRequestDispatcher(nextView);
				rd.forward(req, res);
			} else {
				nextView = "index.jsp";
				pw.println("<font color = 'red'>Invalid Username/Password<font>");
				RequestDispatcher rd = req.getRequestDispatcher(nextView);
				rd.include(req, res);
			}
		} else if (action.equals("Register")) {
			res.sendRedirect("RegisterController");
			nextView = "registration.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(nextView);
			rd.forward(req, res);		
		}
		
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException {
		doPost(req, res);
	}
}
