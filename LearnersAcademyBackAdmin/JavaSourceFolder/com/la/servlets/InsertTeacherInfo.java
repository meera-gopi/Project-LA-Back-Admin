package com.la.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.la.model.Teacher;
import com.la.utility.HibernateSession;

public class InsertTeacherInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertTeacherInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");

			SessionFactory factory = HibernateSession.getSessionFactory();
			Session session = factory.openSession();

			System.out.println(firstName + " " + lastName);

			Transaction tx = session.beginTransaction();

			Teacher tch = new Teacher();

			tch.setFirst_Name(firstName);
			tch.setLast_Name(lastName);

			session.save(tch);

			tx.commit();

			System.out.println((tx.getStatus()));

			response.sendRedirect("TeachersList.jsp");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

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
