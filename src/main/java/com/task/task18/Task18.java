package com.task.task18;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;

/**
 * Servlet implementation class Task18
 */
@WebServlet("/Task18")
public class Task18 extends MainServlet {

	private static final long serialVersionUID = -7283812540670468314L;

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("center") != null && request.getParameter("radius") != null) {
            Point center = new Point(Double.parseDouble(request.getParameter("center").substring(0, 1)),
                    				 Double.parseDouble(request.getParameter("center").substring(1)));

            double radius = Double.parseDouble(request.getParameter("radius"));
            Queue<Square> pq = new PriorityQueue<Square>();

            for (int i = (int) center.getY(); i < (int) center.getY() + radius; i++) {
                for (int j = (int) center.getX(); j < (int) center.getX() + radius; j++) {
                    Square square1 = new Square(new Point(j, i), center);
                    
                    if (square1.isSquareUnderRadius(radius, center)) {
                        Square square2;
                        Square square3;
                        Square square4;
                        double x, y;

                        x = center.getX() - Math.abs(Math.abs(center.getX()) - Math.abs(square1.getA().getX())) - 1;
                        y = square1.getA().getY();
                        square2 = new Square(new Point(x, y), center);

                        x = square2.getA().getX();
                        y = center.getY() - Math.abs(Math.abs(center.getY()) - Math.abs(square2.getA().getY())) - 1;
                        square3 = new Square(new Point(x, y), center);

                        x = square1.getA().getX();
                        y = center.getY() - Math.abs(Math.abs(center.getY()) - Math.abs(square1.getA().getY())) - 1;
                        square4 = new Square(new Point(x, y), center);

                        pq.add(square1);
                        pq.add(square2);
                        pq.add(square3);
                        pq.add(square4);
                    } else {
                        break;
                    }
                }
            }

            PrintWriter out = 
					new PrintWriter(
							new BufferedWriter(
									new FileWriter(
											new File(System.getProperty("user.home") + "/app-root/data/EighteenthTaskOutput.doc")))); 
            while (!pq.isEmpty()) {
                Square square = pq.poll(); 
                out.println(square.toString());
            }
            out.flush();
            
            response.sendRedirect("task18.jsp");
        }
	}
}