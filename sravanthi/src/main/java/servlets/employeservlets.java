package servlets;
   import java.io.IOException;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import dbconnections.employedb;

import models.employe;

import services.employeservices;


	@WebServlet("/toconnect")// used for connection
	public class employeservlets extends HttpServlet{
	      
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			String Name = req.getParameter("name"); // the passing parameter should be same as the name in frontend
			
			
			
			String Email = req.getParameter("email");
			
			String Password = req.getParameter("password");
			
		     employe em  = new employe(0,Name,Email,Password);
			 
			employeservices ems = new employeservices(employedb.getConnection());
			
			boolean i = ems.addemploye(em); // we use boolean for addstudent method in service so, we use boolean here
			
			if(i) {
				resp.sendRedirect("welcome.jsp");
			}
			else {
				resp.sendRedirect("register.jsp");
			}
			
			
			
			
		}
	}

