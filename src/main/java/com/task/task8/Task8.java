package com.task.task8;

import com.root.MainServlet;
import com.service.ValidationUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Task8
 */
@WebServlet("/Task8")
public class Task8 extends MainServlet {

	private static final long serialVersionUID = -4645136883273150933L;

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);

        if (request.getParameter("equation1") != null && request.getParameter("equation2") != null) {
            if (ValidationUtil.isEquation(request.getParameter("equation1")) && 
            	ValidationUtil.isEquation(request.getParameter("equation2"))) {
                new Multiply(request.getParameter("equation1"), request.getParameter("equation2"));
       
                session.setAttribute("result", Multiply.solveEquation());
            } else {
                session.setAttribute("error", "true");
            }
        }

        response.sendRedirect("task8.jsp");
     }
}