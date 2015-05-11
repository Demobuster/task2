<%-- 
    Document   : task1
    Created on : 26.04.2015, 1:45:54
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
<title>Task2</title>
</head>
<body>

	<c:if test="${ sessionScope.Task2Answer == null }">
		<h4>2. Создать список из элементов каталога и его подкаталогов</h4>
		<form action="Task2" method="get">
			<div class="header">
				<p>Задание №2</p>
			</div>
			<div class="description">
				<p>Программа выполнит задание относительно удалённого репозитория этого проекта</p>
			</div>
			<div class="input">
				<input type="submit" class="button" id="submit" value="OK">
			</div>
		</form>

	</c:if>

	<c:if test="${ sessionScope.Task2Answer != null }">
		<div style="text-align: left;">
			<c:forEach items="${ sessionScope.Task2Answer }" var="element">
				<br>
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
