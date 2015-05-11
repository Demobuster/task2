package com.task.task16;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;

/**
 * Servlet implementation class Task16
 */
@WebServlet("/Task16")
public class Task16 extends MainServlet {

	private static final long serialVersionUID = -2909289767724922795L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		SortedListsUnion union = new SortedListsUnion((String) session.getAttribute("fileName"));
		session.setAttribute("result", union.merge().toString());
		response.sendRedirect("task16.jsp");
	}
	
}