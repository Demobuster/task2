package com.task.task22;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;

/**
 * Servlet implementation class Task22
 */
@WebServlet("/Task22")
public class Task22 extends MainServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3187380192873767169L;
	
	private static int getPosById(ArrayList<Car> cars, int id, int len) {
        int i;
        for (i = 0; i < len; i++) {
            if (cars.get(i).getId() == id) {
                break;
            }
        }

        return i;
    }

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("N") != null && request.getParameter("positions") != null && request.getParameter("speeds") != null) {
            ArrayList<Car> cars = new ArrayList<Car>();
            ArrayList<Integer> positions = new ArrayList<Integer>();
            ArrayList<Integer> speeds = new ArrayList<Integer>();
            int n = Integer.parseInt(request.getParameter("N"));

            for (StringTokenizer stringTokenizer = new StringTokenizer(request.getParameter("positions")); stringTokenizer.hasMoreTokens();) {
                String token = stringTokenizer.nextToken();

                positions.add(n  - 1 - Integer.parseInt(token));
            }
            
            for (StringTokenizer stringTokenizer = new StringTokenizer(request.getParameter("speeds")); stringTokenizer.hasMoreTokens();) {
                String token = stringTokenizer.nextToken();

                speeds.add(Integer.parseInt(token));
            }

            for (int i = 0; i < n; i++) {
                cars.add(new Car(i, speeds.get(i)));
            }

            Collections.sort(cars, new CarsSorting());

            int sumOfOvertakings = 0;
            for (int i = 0; i < n; i++) {
                int number = positions.get(i) - getPosById(cars, i, n);
                if (number > 0) {
                    sumOfOvertakings += number;
                }
            }

            if (!"".equals(request.getParameter("scale")) && n <= 5) {
                HttpSession session = request.getSession(true);
                int scale = Integer.parseInt(request.getParameter("scale"));
                
                session.setAttribute("scale", scale);
                session.setAttribute("speeds", speeds);
                session.setAttribute("positions", positions);
                
                response.sendRedirect("loading.jsp");

            } else {
                PrintWriter out = response.getWriter();
                try {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<link rel=\"stylesheet\" href=\"css/congratulations.css\">");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("Начальные позиции: <br>");
                    out.println(positions.toString());
                    out.println("<br>");
                    out.println("Скорости: <br>");
                    out.println(speeds.toString());
                    out.println("Результат:" + sumOfOvertakings);
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }
            }
        }
	}
	
}