package servlets;
import java.io.IOException;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import dbconnections.employedb;

import services.employeservices;

	@WebServlet("/delete")
	public class deleteservlets extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id= Integer.parseInt(req.getParameter("id"));
		employeservices ser = new employeservices(employedb.getConnection());
			boolean i= ser.delbyid(id);
			if(i) {
				resp.sendRedirect("welcome.jsp");
			}
			else {
				resp.sendRedirect("welcome.jsp");
			}
		}

	}


