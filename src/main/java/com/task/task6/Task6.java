package com.task.task6;

import com.root.MainServlet;
import com.service.ValidationUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Task6
 */
@WebServlet("/Task6")
public class Task6 extends MainServlet {

	private static final long serialVersionUID = 8302029100957900809L;

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);

        if (request.getParameter("numbers") != null) {
            if (ValidationUtil.isNumericSequence(request.getParameter("numbers"))) {
                new Task(request.getParameter("numbers"));

                session.setAttribute("result", Task.getSum());
            } else {
                session.setAttribute("error", "true");
            }
        }

        response.sendRedirect("task6.jsp");
	}
	
}
