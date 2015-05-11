package com.task.task4;

import com.root.MainServlet;
import com.service.*;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Task4
 */
@WebServlet("/Task4")
public class Task4 extends MainServlet {

	private static final long serialVersionUID = 3896378495762525478L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);

        TreeSet<Integer> s1 = new TreeSet<Integer>();
        TreeSet<Integer> s2 = new TreeSet<Integer>();
        new MySetManager();

        if (request.getParameter("numbers1") != null && request.getParameter("numbers2") != null) {
            if (com.service.ValidationUtil.isNumericSequence(request.getParameter("numbers1"))
                    && ValidationUtil.isNumericSequence(request.getParameter("numbers2"))) {
                for (StringTokenizer stringTokenizer = new StringTokenizer(request.getParameter("numbers1")); stringTokenizer.hasMoreTokens();) {
                    String token = stringTokenizer.nextToken();

                    s1.add(Integer.parseInt(token));
                }
                for (StringTokenizer stringTokenizer = new StringTokenizer(request.getParameter("numbers2")); stringTokenizer.hasMoreTokens();) {
                    String token = stringTokenizer.nextToken();

                    s2.add(Integer.parseInt(token));
                }

                session.setAttribute("intersect", MySetManager.intersect(s1, s2).toString());
                session.setAttribute("union", MySetManager.union(s1, s2).toString());
            } else {
                session.setAttribute("error", "true");
            }
        }

        response.sendRedirect("task4.jsp");
	}

}
