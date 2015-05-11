<%-- 
    Document   : task11
    Created on : 27.04.2015, 2:34:12
    Author     : Sergey
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/form.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700'
	rel='stylesheet' type='text/css'>
<title>Task11</title>
</head>
<body>

	<c:if test="${ sessionScope.Task11Answer == null }">
		<h4>11. Задан файл с текстом на английском языке. Выделить все
			различные слова. Для каждого слова подсчитать частоту его
			встречаемости. Слова, отличающиеся регистром букв, считать
			различными. Использовать класс HashMap</h4>
		<form action="upload" enctype="multipart/form-data" method="POST">
			<input type="file" name="file1"><br> <input
				type="Submit" value="Upload File"><br>
		</form>

		<c:set var="taskNumber" value="11" scope="session" />
	</c:if>

	<c:if test="${ sessionScope.Task11Answer != null }">
		<div style="text-align: center;">
			<c:forEach items="${ sessionScope.Task11Answer }" var="element">
				<c:out value="${element}" />
				<br>
			</c:forEach>
		</div>
	</c:if>
	
	<footer>
		<a href="index.jsp">К выбору заданий</a>
		<p>&copy; 2015 Serzh Petukhov</p>
	</footer>
</body>
</html>

