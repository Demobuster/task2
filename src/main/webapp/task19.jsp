<%-- 
    Document   : task19
    Created on : 27.04.2015, 12:30:45
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
<title>Task19</title>
</head>
<body>

	<c:if test="${ sessionScope.intersectionPoints == null }">
		<h4>19. На плоскости задано N отрезков. Найти точку пересечения двух отрезков, имеющую минимальную абсциссу. 
		Использовать класс TreeMap</h4>
		 <p>Укажите файл с отрезками. Формат записи координат, A(4|6) B(5|2), где 4 - x, 6 - y; 5 - x, 2 - y; у точек A и B соответственно.
          Каждая прямая описывается С НОВОЙ СТРОКИ.</p>
		<form action="upload" enctype="multipart/form-data" method="POST">
			<input type="file" name="file1"><br> <input
				type="Submit" value="Upload File"><br>
		</form>

		<c:set var="taskNumber" value="19" scope="session" />
	</c:if>

	<c:if test="${ sessionScope.intersectionPoints != null }">
            Координаты точки пересечения двух отрезков, имеющей минимальную абсциссу: <br>
		<c:out value="${intersectionPoints}" />
	</c:if>

	<c:if test="${ param.message == 'error' }">
		<script type="text/javascript">
			alert("Wrong input. Re-try with another input data.");
		</script>
	</c:if>
	
	<footer>
		<a href="index.jsp">К выбору заданий</a>
		<p>&copy; 2015 Serzh Petukhov</p>
	</footer>

</body>
</html>

