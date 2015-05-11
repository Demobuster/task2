<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<link rel="stylesheet" href="css/form.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
<title>Task1</title>
</head>
<body>
	<h4>1. Ввести строки из файла, записать в список. Вывести строки в
		файл в обратном порядке</h4>
	<form action="upload" enctype="multipart/form-data" method="POST">
		<div class="header">
			<p>Задание №1</p>
		</div>
		<div class="description">
			<p>Укажите файл для обработки</p>
			<input type="file" name="file1"> <br> <input
				type="Submit" value="Upload File"><br>
		</div>
	</form>

	<c:set var="taskNumber" value="1" scope="session" />

	<c:if test="${ param.done != null }" >
		<a href="http://task2-serzh.rhcloud.com/upload?fName=FirstTaskOutput.doc">Result</a>
	</c:if>

	<footer>
		<a href="index.jsp">К выбору заданий</a>
		<p>&copy; 2015 Serzh Petukhov</p>
	</footer>

</body>
</html>
