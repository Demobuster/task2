package com.task.task14;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;

/**
 * Servlet implementation class Task14
 */
@WebServlet("/Task14")
public class Task14 extends MainServlet {

	private static final long serialVersionUID = -7041800856585490418L;

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("vertexNum") != null && request.getParameter("vertexToAdd") != null &&
            request.getParameter("vertexToDel") != null) {
            if (request.getParameter("vertexNum").length() == 1 && request.getParameter("vertexToAdd").length() == 3 && 
                request.getParameter("vertexToDel").length() == 3) {
                int toAddx = Integer.parseInt(request.getParameter("vertexToAdd").substring(0, 1));
                int toAddy = Integer.parseInt(request.getParameter("vertexToAdd").substring(2));
                int toDelx = Integer.parseInt(request.getParameter("vertexToDel").substring(0, 1));
                int toDely = Integer.parseInt(request.getParameter("vertexToDel").substring(2));

                MyGraph graph = new MyGraph(Integer.parseInt(request.getParameter("vertexNum")));

                PrintWriter out = response.getWriter();
                try {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<link rel=\"stylesheet\" href=\"css/form.css\">");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("Пересечение строки/столбца - вершина, true/false - есть/нет: <br>");
                    graph.print(out);
                    out.println("<br><br>");
                    graph.addEdge(toAddx, toAddy);
                    graph.removeEdge(toDelx, toDely);
                    graph.print(out);
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }
            }
        }
	}
	
}