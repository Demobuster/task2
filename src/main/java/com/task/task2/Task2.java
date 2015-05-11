package com.task.task2;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import com.root.MainServlet;

/**
 * Servlet implementation class Task2
 */
@WebServlet("/Task2")
public class Task2 extends MainServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		Solver solver = new Solver();
		solver.printTree(0, new File(System.getenv("OPENSHIFT_REPO_DIR")));
		session.setAttribute("Task2Answer", solver.getContent());

		response.sendRedirect("task2.jsp");
	}
}