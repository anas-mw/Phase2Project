package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.simplilearn.entity.Student;
import com.simplilearn.entity.Teacher;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadStudentServlet
 */
@WebServlet("/read-teacher")
public class ReadTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadTeacherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		out.println("<h1> Teachers Information </h1>");

		out.println("<style> table,td,th {border:2px solid green; padding:10px; }</style>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th> Id </th>");
		out.println("<th> Forename </th>");
		out.println("<th> Surname </th>");
		out.println("<th> Contact Numbers </th>");
		out.println("<th> Courses </th>");
		out.println("</tr>");

		List<Teacher> teachers = null;

		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		teachers = session.createQuery("from Teacher").list();

		if (teachers != null) {
			for (Teacher s : teachers) {
				out.println("<tr>");
				out.println("<td>" + s.getTeacherId() + "</td>");
				out.println("<td>" + s.getFname() + "</td>");
				out.println("<td>" + s.getLname() + "</td>");
				out.println("<td>" + s.getPhones() + "</td>");
				out.println("<td>" + s.getCourses() + "</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
