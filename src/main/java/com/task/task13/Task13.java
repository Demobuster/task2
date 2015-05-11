package com.task.task13;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;
import com.service.ValidationUtil;

/**
 * Servlet implementation class Task13
 */
@WebServlet("/Task13")
public class Task13 extends MainServlet {

	private static final long serialVersionUID = -4941272181203588316L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		if (request.getParameter("sequence") != null && request.getParameter("X") != null) {
			if (ValidationUtil.isNumericSequence(request.getParameter("sequence")) && 
				ValidationUtil.isNumeric(request.getParameter("X"))) {
				new SorterRelativelyOfX(request.getParameter("sequence"), Integer.parseInt(request.getParameter("X")));
				SorterRelativelyOfX.solve();

				session.setAttribute("result", SorterRelativelyOfX.getList().toString());
			}
		} else {
			session.setAttribute("error", "true");
		}

		response.sendRedirect("task13.jsp");
	}
	
}