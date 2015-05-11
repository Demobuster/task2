package com.task.task12;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.root.MainServlet;

/**
 * Servlet implementation class Task12
 */
@WebServlet("/Task12")
public class Task12 extends MainServlet {

	private static final long serialVersionUID = -2953986196116308495L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        LastManStanding lastMan = new LastManStanding();

        if (request.getParameter("numOfPeople") != null) {

            PrintWriter out = response.getWriter();
            try {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"css/form.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("via ArrayList:<br>");
                lastMan.viaArrayList(Integer.parseInt(request.getParameter("numOfPeople")), response);
                out.println("<br>via LinkedList:<br>");
                lastMan.viaLinkedList(Integer.parseInt(request.getParameter("numOfPeople")), response);
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        }
	}
	
}