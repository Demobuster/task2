package com.task.task9;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;

/**
 * Servlet implementation class Task9
 */
@WebServlet("/Task9")
public class Task9 extends MainServlet {

	private static final long serialVersionUID = -328970729022864005L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
  
        if (request.getParameter("sequence") != null) {
            new Checker();
            
            if (Checker.solve(request.getParameter("sequence"), "[{(", ")}]")) {
            	session.setAttribute("result", "Valid");
            } else {
            	session.setAttribute("error", "true");
            }
        }

        response.sendRedirect("task9.jsp");
	}
}