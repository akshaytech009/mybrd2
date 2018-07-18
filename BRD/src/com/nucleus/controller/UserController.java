package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.model.User;
import com.nucleus.service.UserService;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void UserControl(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User user = new User();
		UserService us = new UserService();
		user.setUser((String) request.getAttribute("user"));
		user.setPass((String) request.getAttribute("pass"));
		//System.out.println(user.getUser() + "((((((((((((((((");
		String role = us.Finddb(user.getUser(), user.getPass());
		user.setRole(role);
		//System.out.println(role);

		/*
		 * if(request.getParameter("button").equalsIgnoreCase("LoginPage")) {
		 * response.sendRedirect("UserLogin.jsp"); }
		 */

		if (request.getParameter("hello").equalsIgnoreCase("submit")) {

			if (user.getRole() == null) {
				out.print("UserName/Password Not found");
			} else {
				if (user.getRole().equalsIgnoreCase("maker")) {
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user.getUser());
					session.setAttribute("role", user.getRole());
					RequestDispatcher rd = request
							.getRequestDispatcher("options1.jsp");
					rd.forward(request, response);

				} else if (user.getRole().equalsIgnoreCase("checker")) {
					response.sendRedirect("welcomeChecker.jsp");
				} else {
					response.sendRedirect("UserLogin.jsp");
				}
			}
		} else {
			System.out.println("Still in user controller");
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserControl(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserControl(request, response);
	}

}
