package com.task.task20;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import com.root.MainServlet;

/**
 * Servlet implementation class Task20
 */
@WebServlet("/Task20")
public class Task20 extends MainServlet {
	private static int[][] numbers;
	private static int ROWS;
	private static int COLS;

	private static final long serialVersionUID = 8224141414638578585L;
	
	private static int[][] toBinaryFormat(int[][] matrix) {
		int[][] temp = new int[ROWS][COLS];

		for (int i = 0; i < COLS; i++) {
			for (int j = ROWS - 2; j != -1; j--) {
				if (matrix[j][i] != matrix[j + 1][i]) {
					temp[j][i] = 0;
				} else {
					temp[j + 1][i] = 1;
					temp[j][i] = 1;
				}
			}
		}

		return temp;
	}
	private static int[][] fromFileToArray(String URL) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		Scanner input;
		try {
			input = new Scanner(new File(URL));

			while (input.hasNextLine()) {
				Scanner colReader = new Scanner(input.nextLine());
				ArrayList<Integer> col = new ArrayList<Integer>();
				while (colReader.hasNextInt()) {
					col.add(colReader.nextInt());
				}
				a.add(col);
				
				colReader.close();
			}
			input.close();
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		ROWS = a.size();
		COLS = a.get(0).size();
		int[][] arr = new int[ROWS][COLS];

		for (int i = 0; i < a.size(); i++) {
			ArrayList<Integer> temp = a.get(i);
			System.out.println();
			for (int j = 0; j < temp.size(); j++) {
				arr[i][j] = temp.get(j);
			}
		}

		return arr;
	}

	@Override
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		numbers = fromFileToArray(System.getProperty("user.home") + "/app-root/data/" + (String) session.getAttribute("fileName"));
		int[][] binNumbers = toBinaryFormat(numbers);

		LargestRectange rectangle = new LargestRectange();
		rectangle.getRectangle(binNumbers);

		int startI = rectangle.getStartI();
		int startJ = rectangle.getStartJ();
		int height = rectangle.getHight();
		int width = rectangle.getWidth();

		PrintWriter out = response.getWriter();
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" href=\"css/form.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("Результат");
			for (int i = startI; i < startI + height; i++) {
				out.println("<br>");
				for (int j = startJ; j < startJ + width; j++) {
					out.print(numbers[i][j] + "  ");
				}
			}
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}