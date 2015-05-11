<%-- 
    Document   : task17
    Created on : 27.04.2015, 11:50:15
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
<title>Task17</title>
</head>
<body>

	<c:if test="${ sessionScope.lineDescription == null }">
		<h4>17. На плоскости задано N точек. Вывести в файл описания всех
			прямых, которые проходят более чем через 2 точки из заданных. Для
			каждой прямой указать, через сколько точек она проходит. Использовать
			класс HashMap</h4>

		<p>
			Укажите файл с точками. Формат записи координат: P(4|6), где 4 - x, 6 - y. Каждая точка
			записывается С НОВОЙ СТРОКИ.
		</p>
		<form action="upload" enctype="multipart/form-data" method="POST">
			<input type="file" name="file1"><br> <input
				type="Submit" value="Upload File"><br>
		</form>

		<c:set var="taskNumber" value="17" scope="session" />
	</c:if>

	<c:if test="${ sessionScope.lineDescription != null }">
		<div style="text-align: center;">
			<c:forEach items="${ sessionScope.lineDescription }" var="element">
				<br>
				<c:out value="${element}" />

			</c:forEach>
		</div>
	</c:if>	
	
	<c:if test="${ param.done != null }" >
		<a href="http://task2-serzh.rhcloud.com/upload?fName=FirstTaskOutput.doc">Result</a>
	</c:if>
	
	<footer>
		<a href="index.jsp">К выбору заданий</a>
		<p>&copy; 2015 Serzh Petukhov</p>
	</footer>

</body>
</html>
