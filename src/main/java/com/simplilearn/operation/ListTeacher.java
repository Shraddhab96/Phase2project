package com.simplilearn.operation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.details.TeacherDetails;
import com.simplilearn.util.Util;


@WebServlet("/list-teacher")
public class ListTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			SessionFactory factory = Util.buildConnection();
			
			Session session = factory.openSession();
			
			@SuppressWarnings("unchecked")
			List<TeacherDetails> list = session.createQuery("from TeacherDetails").list();
			
			out.println("<h2>Teacher List");
			
			out.println("<style> table,td,th{"
					+ "border:2px solid red; "
					+ "padding:2px;); "
					+ "</style>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Teacher Id</th>");
			out.println("<th>Teacher Name</th>");
			out.println("<th>Teacher Subject</th>");
			out.println("<th>Teacher Class</th>");
			out.println("<tr>");
			
			for(TeacherDetails tedet : list) {
				out.println("<tr>");
				out.println("<td>"+ tedet.getId() +"</td>");
				out.println("<td>"+ tedet.getName() +"</td>");
				out.println("<td>"+ tedet.getSubject() +"</td>");
				out.println("<td>"+ tedet.getTeacherClass() +"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href='adminpage.html'>Back To MainMenu</a>");
			session.close();
		} catch (Exception e) {
			out.println("<h2 style='color:red'>Operation Failed<h2>");
			out.println("<a href='adminpage.html'>Back To MainMenu</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}