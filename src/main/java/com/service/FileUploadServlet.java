package com.service;

import java.io.*;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(location = "/var/lib/openshift/554cda5afcf933cd1000008d/app-root/data")
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = System.getProperty("user.home") + "/app-root/data/" + request.getParameter("fName");

		File file = new File(path);

		if (!file.exists()) {
			throw new ServletException("File doesn't exists on server.");
		}

		ServletContext ctx = getServletContext();
		InputStream fis = new FileInputStream(file);
		String mimeType = ctx.getMimeType(file.getAbsolutePath());

		response.setContentType(mimeType != null ? mimeType
				: "application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ request.getParameter("fName") + "\"");

		ServletOutputStream os = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read = 0;

		while ((read = fis.read(bufferData)) != -1) {
			os.write(bufferData, 0, read);
		}

		os.flush();
		os.close();
		fis.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Collection<Part> parts = request.getParts();

		for (Part part : parts) {
			part.write(getFileName(part));
			session.setAttribute("fileName", getFileName(part));
		}

		getServletContext().getRequestDispatcher(
				"/Task" + session.getAttribute("taskNumber")).forward(request,
				response);
	}

	private String getFileName(Part part) {
		String partHeader = part.getHeader("content-disposition");
		for (String cd : partHeader.split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}