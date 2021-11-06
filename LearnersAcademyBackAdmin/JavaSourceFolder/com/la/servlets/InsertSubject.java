package com.la.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.la.model.Subject;
import com.la.utility.HibernateSession;

public class InsertSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String subname = request.getParameter("subname");

			SessionFactory factory = HibernateSession.getSessionFactory();
			Session session = factory.openSession();

			System.out.println(subname);

			Transaction tx = session.beginTransaction();

			Subject sub = new Subject();

			sub.setSub_Name(subname);

			session.save(sub);

			tx.commit();

			System.out.println((tx.getStatus()));

			response.sendRedirect("SubjectList.jsp");

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
