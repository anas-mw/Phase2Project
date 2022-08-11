package com.simplilearn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.EProduct;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("add-product.html").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String price = request.getParameter("price");
		EProduct eProduct = new EProduct();
		eProduct.setName(name);
		eProduct.setPrice(String.valueOf(price));

		// Step 1: Get sessionFactory object
		SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

		// Step 2 : Open Session
		Session session = sessionFactory.openSession();

		// Step3: Begin Transaction
		Transaction tx = session.beginTransaction();

		// Step 4: Save product object in DB
		session.save(eProduct);

		tx.commit();
		
		session.close();
		response.sendRedirect("read-product");
	}

}
