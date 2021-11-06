package com.la.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.la.model.User;
import com.la.utility.HibernateSession;

public class Connectivity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Connectivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String userName = request.getParameter("username");
			String password = request.getParameter("userpass");

			System.out.println("UserName is " + userName);

			if (userName == null | "".equals(userName)) {
				System.out.println("Moving from here");
				response.sendRedirect("Invalid.jsp?error=1");

			}

			else if (password == null | "".equals(password)) {
				response.sendRedirect("Invalid.jsp?error=2");
			}

			else {

				// Checking if user is an Admin or not
				SessionFactory factory = HibernateSession.getSessionFactory();
				Session session = factory.openSession();

				Query Query1 = session.createQuery("select p from User p where p.UserId=:userId").setParameter("userId",
						userName);

				

				List<User> resultList = (List<User>) Query1.getResultList();
				if (resultList == null || resultList.isEmpty()) {
					response.sendRedirect("Invalid.jsp?error=2");
				}
				User result = resultList.get(0);

				if (result == null) {
					response.sendRedirect("Invalid.jsp?error=2");
				}

				System.out.println("User type Id retrieved is " + result.getUser_Type_Id());

				if (!(password.equals(result.getPassword()))) {

					response.sendRedirect("Invalid.jsp?error=2");
				}

				if (result.getUser_Type_Id() == 1) {

					String adminName = result.getFirstName() + " " + result.getLastName();

					System.out.println("Name of the user is " + adminName);
					session.close();

					request.setAttribute("name", adminName);
					request.getRequestDispatcher("Dashboard.jsp").forward(request, response);

				} else {
					session.close();

					response.sendRedirect("Invalid.jsp?error=3");
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
