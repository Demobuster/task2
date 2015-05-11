package com.task.task5;

import com.root.MainServlet;
import com.service.ValidationUtil;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Task5
 */
@WebServlet("/Task5")
public class Task5 extends MainServlet {

	private static final long serialVersionUID = 2886480879808137554L;

	@Override
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);

        if (request.getParameter("numbersI") != null && request.getParameter("numbersU") != null && request.getParameter("N") != null) {
            if (ValidationUtil.isNumericSequence(request.getParameter("numbersI"))
                    && ValidationUtil.isNumericSequence(request.getParameter("numbersU"))) {

                OrdinaryLeastSquares ols = new OrdinaryLeastSquares(request.getParameter("numbersI"), request.getParameter("numbersU"),
                        Integer.parseInt(request.getParameter("N")));
                session.setAttribute("res", "Приближенное число R методом наименьших квадратов: "
                        + new DecimalFormat("#0.000").format(ols.getResistanceApproximateValue()) + " (Ом)");
            } else {
                session.setAttribute("error", "true");
            }
        }

        response.sendRedirect("task5.jsp");
	}
}