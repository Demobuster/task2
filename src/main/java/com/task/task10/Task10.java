package com.task.task10;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;

/**
 * Servlet implementation class Task10
 */
@WebServlet("/Task10")
public class Task10 extends MainServlet {

	private static final long serialVersionUID = -3919787176230226009L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		
		new UniqueWordsSplitter();
		UniqueWordsSplitter.solve((String) session.getAttribute("fileName"));
		session.setAttribute("Task10Answer", UniqueWordsSplitter.getUniqueWords());

		response.sendRedirect("task10.jsp");
	}
	
}