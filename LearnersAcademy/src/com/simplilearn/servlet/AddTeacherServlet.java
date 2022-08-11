package com.simplilearn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Courses;
import com.simplilearn.entity.PhoneNumber;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Teacher;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/add-teacher")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("add-teacher.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
			Teacher teacher = getTeacher(request);
			System.out.println(teacher);
			SessionFactory sf = HibernateUtil.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.save(teacher);
			tx.commit();
			response.sendRedirect("read-teacher");
	}
	
	
	
	private Teacher getTeacher(HttpServletRequest request) {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");

		String phone_1 = request.getParameter("phone_1");
		String type_1 = request.getParameter("type_1");

		String phone_2 = request.getParameter("phone_2");
		String type_2 = request.getParameter("type_2");

		String phone_3 = request.getParameter("phone_3");
		String type_3 = request.getParameter("type_3");

		Teacher teacher = new Teacher();
		teacher.setFname(fname);
		teacher.setLname(lname);

		PhoneNumber p1 = new PhoneNumber();
		p1.setPhoneNumber(phone_1);
		p1.setPhoneType(type_1);
		p1.setTeacher(teacher);

		PhoneNumber p2 = new PhoneNumber();
		p2.setPhoneNumber(phone_2);
		p2.setPhoneType(type_2);
		p2.setTeacher(teacher);

		PhoneNumber p3 = new PhoneNumber();
		p3.setPhoneNumber(phone_3);
		p3.setPhoneType(type_3);
		p3.setTeacher(teacher);

		List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
		phones.add(p1);
		phones.add(p2);
		phones.add(p3);

		teacher.setPhones(phones);
		
		// Add Details for courses
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(teacher);
		
		String course1 = request.getParameter("course_1");
		String courseType1 = request.getParameter("courseType_1");
		
		Courses c1 = new Courses();
		c1.setCourseName(course1);
		c1.setCourseType(courseType1);
		c1.setTeacher(teacher);
		
		String course2 = request.getParameter("course_2");
		String courseType2 = request.getParameter("courseType_2");
		
		Courses c2 = new Courses();
		c2.setCourseName(course2);
		c2.setCourseType(courseType2);
		c2.setTeacher(teacher);
		
		String course3 = request.getParameter("course_3");
		String courseType3 = request.getParameter("courseType_3");
		
		Courses c3 = new Courses();
		c3.setCourseName(course3);
		c3.setCourseType(courseType3);
		c3.setTeacher(teacher);
		
		List<Courses> courses = new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		
		teacher.setCourses(courses);
		
		return teacher;
	}

}
