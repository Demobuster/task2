package com.task.task19;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;

/**
 * Servlet implementation class Task19
 */
@WebServlet("/Task19")
public class Task19 extends MainServlet {

	private static final long serialVersionUID = 7866528114636696867L;
	
	protected static Point intersection(Point p1, Point p2, Point p3, Point p4) {
		double d = (p1.getX() - p2.getX()) * (p3.getY() - p4.getY()) - (p1.getY() - p2.getY()) * (p3.getX() - p4.getX());
		if (d == 0) {
			return null;
		}

		double xi = ((p3.getX() - p4.getX()) *
				(p1.getX() * p2.getY() - p1.getY() * p2.getX()) - (p1.getX() - p2 .getX()) * (p3.getX() * p4.getY() - p3.getY() * p4.getX()))
				/ d;
		double yi = ((p3.getY() - p4.getY()) * (p1.getX() * p2.getY() - p1.getY() * p2.getX()) - (p1.getY() - p2.getY()) * (p3.getX() * p4.getY() - p3.getY() * p4.getX()))
				/ d;

		return new Point(xi, yi);
	}

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		TreeMap<Double, Double> intersectionPoints = new TreeMap<Double, Double>();
		ArrayList<Segment> segments = new ArrayList<Segment>();

		Scanner s;
		try {
			s = new Scanner(new File(System.getProperty("user.home")
					+ "/app-root/data/"
					+ (String) session.getAttribute("fileName"))).useDelimiter("\\w\\(|\\||\\) \\w\\(|\\||\\)\n?");
			while (s.hasNext()) {
				segments.add(new Segment(new Point(s.nextDouble(), s.nextDouble()), new Point(s.nextDouble(), s.nextDouble())));
				s.nextLine();
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		for (int i = 0; i < segments.size() - 1; i++) {
			for (int j = i + 1; j < segments.size(); j++) {
				Point p = intersection(segments.get(i).getStart(), 
									   segments.get(i).getEnd(), 
									   segments.get(j).getStart(), 
									   segments.get(j).getEnd());
				if (p != null) {
					intersectionPoints.put(p.getX(), p.getY());
				}
			}
		}

		session.setAttribute("intersectionPoints", "("
				+ intersectionPoints.pollFirstEntry().getKey() + ","
				+ intersectionPoints.pollFirstEntry().getValue() + ")");

		response.sendRedirect("task19.jsp");
	}
	
}