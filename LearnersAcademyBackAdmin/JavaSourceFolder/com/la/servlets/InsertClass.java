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
import com.la.model.Subject;
import com.la.model.Teacher;
import com.la.model.User;
import com.la.utility.HibernateSession;

public class InsertClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String className = request.getParameter("clsname");
			String subname = request.getParameter("subname");
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String startTime = request.getParameter("stime");
			String endTime = request.getParameter("etime");

			SessionFactory factory = HibernateSession.getSessionFactory();
			Session session = factory.openSession();

			System.out.println(subname);

			Query Query2 = session.createQuery("select p from Subject p where p.Sub_Name=:subName")
					.setParameter("subName", subname);
			List<Subject> resultset = (List<Subject>) Query2.getResultList();
			long subid = resultset.get(0).getId();

			Query Query3 = session
					.createQuery("select p1 from Teacher p1 where p1.First_Name=:fname and p1.Last_Name=:lname");
			Query3.setParameter("fname", firstName);
			Query3.setParameter("lname", lastName);

			List<Teacher> resultset1 = (List<Teacher>) Query3.getResultList();
			long tchid = resultset1.get(0).getId();

			Transaction tx = session.beginTransaction();

			Classes cls = new Classes();
			// Subject sub1 = new Subject();
			// Teacher tch1 = new Teacher();

			cls.setClass_Name(className);
			cls.setStart_Time(startTime);
			cls.setEnd_Time(endTime);

			cls.setSub_Id(subid);
			;
			cls.setTeacher_Id(tchid);

			session.save(cls);

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
