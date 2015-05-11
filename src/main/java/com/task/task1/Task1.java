package com.task.task1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.root.MainServlet;

/**
 * Servlet implementation class Task1
 */
@WebServlet("/Task1")
public class Task1 extends MainServlet {
	
	private static final long serialVersionUID = -3377725363513539773L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		Reverse reverse = new Reverse((String) session.getAttribute("fileName"));
		reverse.solve();

		response.sendRedirect("task1.jsp?done=d");
	}
}
