package com.task.task21;

import com.root.MainServlet;
import com.service.ValidationUtil;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Task21
 */
@WebServlet("/Task21")
public class Task21 extends MainServlet {

	private static final long serialVersionUID = 8328584003908489180L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

        if (request.getParameter("numbers") != null && request.getParameter("X") != null) {
            if (ValidationUtil.isNumericSequence(request.getParameter("numbers")) && ValidationUtil.isNumeric(request.getParameter("X"))) {
                BlackBox bBox = new BlackBox();

                for (StringTokenizer stringTokenizer = new StringTokenizer(request.getParameter("numbers")); stringTokenizer.hasMoreTokens();) {
                    String token = stringTokenizer.nextToken();
                    bBox.add(Double.parseDouble(token));
                }
                
                session.setAttribute("storedData", bBox.toString());
                session.setAttribute("number", bBox.getKthMinimum(Integer.parseInt(request.getParameter("X"))));
            } else {
                session.setAttribute("error", "true");
            }
        }

        response.sendRedirect("task21.jsp");
	}
	
}