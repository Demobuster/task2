package com.task.task11;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.root.MainServlet;

/**
 * Servlet implementation class Task11
 */
@WebServlet("/Task11")
public class Task11 extends MainServlet {

	private static final long serialVersionUID = -704652401546164461L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		new UniqueRegWordsSplitter();
		UniqueRegWordsSplitter.solve((String) session.getAttribute("fileName"));
		session.setAttribute("Task11Answer", UniqueRegWordsSplitter.getUniqueWords());

		response.sendRedirect("task11.jsp");
	}
	
}