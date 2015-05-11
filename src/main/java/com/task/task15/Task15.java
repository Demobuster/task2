package com.task.task15;

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
 *
 * @author Sergey
 */
@WebServlet("/Task15")
public class Task15 extends MainServlet {

	private static final long serialVersionUID = 4349882024130202789L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        
        if (request.getParameter("numbers") != null && request.getParameter("X") != null) {
            if (ValidationUtil.isNumericSequence(request.getParameter("numbers")) && ValidationUtil.isNumeric(request.getParameter("X"))) {
                MyDataStore store = new MyDataStore();
                
                for (StringTokenizer stringTokenizer = new StringTokenizer(request.getParameter("numbers")); stringTokenizer.hasMoreTokens();) {
                    String token = stringTokenizer.nextToken();
                    
                    store.add(Double.parseDouble(token));
                }
                
                session.setAttribute("storedData", store.toString());
                session.setAttribute("number", store.searchForClosestNumberValue(Double.parseDouble(request.getParameter("X"))));
                session.setAttribute("index", store.searchForClosestNumberIndex(Double.parseDouble(request.getParameter("X"))));
            }
        } else {
            session.setAttribute("error", "true");
        }
        
        response.sendRedirect("task15.jsp");
	}
	
}