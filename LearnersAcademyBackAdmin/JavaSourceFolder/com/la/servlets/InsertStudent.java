package com.la.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.la.model.Classes;
import com.la.model.Student;
import com.la.model.Teacher;
import com.la.model.User;
import com.la.utility.HibernateSession;

/**
 * Servlet implementation class InsertStudent
 */
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String className = request.getParameter("clsname");

			SessionFactory factory = HibernateSession.getSessionFactory();
			Session session = factory.openSession();

			Query Query1 = session.createQuery("select p from Classes p where p.Class_Name=:clsName")
					.setParameter("clsName", className);

			List<Classes> resultList = (List<Classes>) Query1.getResultList();

			long clsId = resultList.get(0).getClass_Id();

			System.out.println(firstName + " " + lastName);

			Transaction tx = session.beginTransaction();

			Student std = new Student();

			std.setFirst_Name(firstName);
			std.setLast_Name(lastName);
			std.setClass_Id(clsId);;

			session.save(std);

			tx.commit();

			System.out.println((tx.getStatus()));

			response.sendRedirect("StudentsList.jsp");

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
