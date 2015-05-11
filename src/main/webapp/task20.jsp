<%-- 
    Document   : task20
    Created on : 27.04.2015, 4:16:24
    Author     : Sergey
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/form.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
        <title>Task20</title>
    </head>
    <body>

        <h4>20. Дана матрица из целых чисел. Найти в ней прямоугольную подматрицу, состоящую из максимального количества одинаковых элементов. 
            Использовать класс Stack
        </h4>
        <form action="upload" enctype="multipart/form-data" method="POST">
			<input type="file" name="file1"><br> <input
				type="Submit" value="Upload File"><br>
		</form>

		<c:set var="taskNumber" value="20" scope="session" />

	<footer>
		<a href="index.jsp">К выбору заданий</a>
		<p>&copy; 2015 Serzh Petukhov</p>
	</footer>
    </body>
</html>
