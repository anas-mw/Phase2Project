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

import com.simplilearn.entity.EProduct;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class ReadProductServlet
 */
@WebServlet("/read-product")
public class ReadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadProductServlet() {
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

		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
		Session session = sessionFactory.openSession();

		List<EProduct> products = session.createQuery("from EProduct").list();

		out.println("<h1> - List of Courses - </h1>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th> Course ID </th>");
		out.println("<th> Course Name </th>");
		out.println("<th> Department </th>");
		out.println("</tr>");

		for (EProduct product : products) {
			out.println("<tr>");
			out.println("<td>" + product.getId() + "</td>");
			out.println("<td>" + product.getName() + "</td>");
			out.println("<td>" + product.getPrice() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");

		out.println("</body></html>");
		session.close();

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
