package com.task.task23;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

import com.root.MainServlet;
import com.service.ValidationUtil;

/**
 * Servlet implementation class Task23
 */
@WebServlet("/Task23")
public class Task23 extends MainServlet {

	private static final long serialVersionUID = -1802296407639933074L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		if (request.getParameter("N") != null && request.getParameter("positions") != null
				&& request.getParameter("k") != null && request.getParameter("speeds") != null) {
			if (ValidationUtil.isNumericSequence(request.getParameter("positions")) &&
				ValidationUtil.isNumericSequence(request.getParameter("speeds")) &&
				ValidationUtil.isNumeric(request.getParameter("N")) &&
				ValidationUtil.isNumeric(request.getParameter("k"))) {
				
				new Overtake();
				ArrayList<Car> cars = new ArrayList<Car>();
				ArrayList<Integer> postitons = new ArrayList<Integer>();
				ArrayList<Integer> speeds = new ArrayList<Integer>();
				TreeMap<Double, String> overtakings = new TreeMap<Double, String>();
				int N = Integer.parseInt(request.getParameter("N"));
				int k = Integer.parseInt(request.getParameter("k"));

				for (StringTokenizer stringTokenizer = 
						new StringTokenizer(request.getParameter("positions")); stringTokenizer.hasMoreTokens();) {
					String token = stringTokenizer.nextToken();

					postitons.add(Integer.parseInt(token));
				}
				for (StringTokenizer stringTokenizer = 
						new StringTokenizer(request.getParameter("speeds")); stringTokenizer.hasMoreTokens();) {
					String token = stringTokenizer.nextToken();

					speeds.add(Integer.parseInt(token));
				}

				for (int i = 0; i < N; i++) {
					cars.add(new Car(speeds.get(i), postitons.get(i), i));
				}

				for (int i = 0; i < N - 1; i++) {
					for (int j = i + 1; j < N; j++) {
						overtakings.put(Overtake.timeOfOvertakePerformed(cars.get(i), cars.get(j)), Overtake.getHeadline());
					}
				}

				PrintWriter out = response.getWriter();
				try {
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("<link rel=\"stylesheet\" href=\"css/form.css\">");
					out.println("</head>");
					out.println("<body>");
					out.println("Результат");
					for (Map.Entry e : overtakings.entrySet()) {
						if (k > 0) {
							out.println(new DecimalFormat("#0.000").format(e.getKey()) + " " + e.getValue());
							out.print("<br>");
							--k;
						} else {
							break;
						}
					}
					
					out.println("</body>");
					out.println("</html>");
				} finally {
					out.close();
				}
			}
		} else {
			session.setAttribute("error", "true");
		}
	}
	
}