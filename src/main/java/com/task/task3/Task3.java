package com.task.task3;

import java.io.IOException;
import com.root.MainServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Task3
 */
@WebServlet("/Task3")
public class Task3 extends MainServlet {

	private static final long serialVersionUID = -4791305763590060630L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		
		Solver solver = new Solver((String) session.getAttribute("fileName"));
		solver.solve();
		session.setAttribute("Task3Answer", solver.getPiece().getStringsOfLyric());

		response.sendRedirect("task3.jsp");
	}
	
}