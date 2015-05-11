<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/form.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700'
	rel='stylesheet' type='text/css'>
<title>Task3</title>
</head>
<body>
	<c:if test="${ sessionScope.Task3Answer == null }">
		<p>3. Занести стихотворения одного автора в список. Провести сортировку по возрастанию длин строк.</p>

		<form action="upload" enctype="multipart/form-data" method="POST">
			<input type="file" name="file1"><br> <input
				type="Submit" value="Upload File"><br>
		</form>

		<c:set var="taskNumber" value="3" scope="session" />
	</c:if>

	<c:if test="${ sessionScope.Task3Answer != null }">
		<div style="text-align:center;" >
			<c:forEach items="${ sessionScope.Task3Answer }" var="element">
				<c:out value="${element}" />
			</c:forEach>
		</div>
	</c:if>

	<footer>
		<a href="index.jsp">К выбору заданий</a>
		<p>&copy; 2015 Serzh Petukhov</p>
	</footer>
</body>
</html>