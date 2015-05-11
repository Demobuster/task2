<%-- 
    Document   : task13
    Created on : 27.04.2015, 3:00:13
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
<title>Task13</title>
</head>
<body>

	<c:if test="${ sessionScope.result == null }">
		<h4>13. Задан список целых чисел и число X. Не используя
			вспомогательных объектов и не изменяя размера списка, переставить
			элементы списка так, чтобы сначала шли числа, не превосходящие X, а
			затем числа, большие X</h4>
		<form action="Task13" method="get">
			<div class="header">
				<p>Задание №13</p>
			</div>
			<div class="description">
				<p>Введите последовательность чисел через пробел и число X
					соответственно:</p>
			</div>
			<div class="input">
				<input type="text" class="button" id="sequence" name="sequence" placeholder="4 9 -12 5 8 2 1 3" required>
				 <input type="text" class="button" id="X" name="X" placeholder="5" required>
				 <input type="submit" class="button" id="submit" value="OK">
			</div>
		</form>

		<input type="button" class="button" id="submit"
			value="Тестовые данные"
			style="position: absolute; left: 500px; top: 500px;"
			onclick="document.getElementById('sequence').value = '4 9 -12 5 8 2 1 3';
                	 document.getElementById('X').value = '5';">
	</c:if>

	<c:if test="${ sessionScope.result != null }">
		<div style="text-align: center;">
			Результат:
			<c:out value="${sessionScope.result}" />
		</div>
	</c:if>

	<c:if test="${ sessionScope.error == 'true' }">
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
