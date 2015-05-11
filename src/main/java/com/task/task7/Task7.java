package com.task.task7;

import com.root.MainServlet;
import com.service.ValidationUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Task7
 */
@WebServlet("/Task7")
public class Task7 extends MainServlet {

	private static final long serialVersionUID = 6265926190620962077L;

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);

        if (request.getParameter("equation1") != null && request.getParameter("equation2") != null) {
            if (ValidationUtil.isEquation(request.getParameter("equation1")) && ValidationUtil.isEquation(request.getParameter("equation2"))) {
                
                new Addition(request.getParameter("equation1"), request.getParameter("equation2"));

                session.setAttribute("result", Addition.solveEquation());
            } else {
                session.setAttribute("error", "true");
            }
        }

        response.sendRedirect("task7.jsp");
	}
	
}