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
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadStudentServlet
 */
@WebServlet("/read-student")
public class ReadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadStudentServlet() {
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

		out.println("<h1> Students Information </h1>");

		out.println("<style> table,td,th {border:2px solid green; padding:10px; }</style>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Student Id </th>");
		out.println("<th>Student FName </th>");
		out.println("<th>Student LName </th>");
		out.println("<th>Student PhoneNumber </th>");
		out.println("<th>Student Course Names </th>");
		out.println("</tr>");

		List<Student> students = null;

		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		students = session.createQuery("from Student").list();

		if (students != null) {
			for (Student s : students) {
				out.println("<tr>");
				out.println("<td>" + s.getStudentId() + "</td>");
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
