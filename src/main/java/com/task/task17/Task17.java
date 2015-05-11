package com.task.task17;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;

/**
 * Servlet implementation class Task17
 */
@WebServlet("/Task17")
public class Task17 extends MainServlet {

	private static final long serialVersionUID = -8535119981081160969L;
	
	protected static String getLineDescription(Segment segment, int pointsCounter) {
		return "Прямая с вершинами (" + segment.getStart().getX() + ";"
				+ segment.getStart().getY() + ") и (" + segment.getEnd().getX()
				+ ";" + segment.getEnd().getY() + ") пересекает "
				+ pointsCounter + " точек.";
	}
	
	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		ArrayList<Point> points = new ArrayList<Point>();
		HashMap<Segment, Integer> linesWithPoints = new HashMap<Segment, Integer>();
		int N = 0;

		Scanner s;
		try {
			s = new Scanner(new File(System.getProperty("user.home")
					+ "/app-root/data/"
					+ (String) session.getAttribute("fileName"))).useDelimiter("P\\(|\\||\\)\n?");
			while (s.hasNext()) {
				points.add(new Point(s.nextDouble(), s.nextDouble()));
				s.nextLine();
				++N;
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// in equation: (y - y1)(x2 - x1) = (y2 - y1)(x - x1) second
				// expression in the brackets will be the xDiff,
				// and third will be yDiff
				double xDiff = points.get(j).getX() - points.get(i).getX();
				double yDiff = points.get(j).getY() - points.get(i).getY();
				int pointsCounter = 0;

				for (int k = 0; k < N; k++) {
					if (xDiff * (points.get(k).getY() - points.get(i).getY()) == yDiff * (points.get(k).getX() - points.get(i).getX())) {

						++pointsCounter;
					}
				}

				if (pointsCounter > 2) {
					linesWithPoints.put(new Segment(points.get(i), points.get(j)), pointsCounter);
				}
			}
		}

		ArrayList<String> lineDescription = new ArrayList<String>();
		for (Map.Entry e : linesWithPoints.entrySet()) {
			lineDescription.add(getLineDescription((Segment) e.getKey(), (Integer) e.getValue()));
		}
		session.setAttribute("lineDescription", lineDescription);

		response.sendRedirect("task17.jsp?done=d");
	}
	
}