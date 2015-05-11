<%-- 
    Document   : task4
    Created on : 27.04.2015, 0:56:06
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
        <title>Task4</title>
    </head>
    <body>

        <c:if test="${ sessionScope.intersect == null && sessionScope.union == null }" >
            <h4>4. Определить множество на основе множества целых чисел. Создать методы для определения пересечения и объединения множеств </h4>
            <form action="Task4" method="get" >
                <div class="header">
                    <p>Задание №4</p>
                </div>
                <div class="description">
                    <p>Введите через пробел значения 2-х множеств соответственно в поля ниже
                    </p>
                </div>
                <div class="input">
                    <input type="text" class="button" id="numbers1" name="numbers1" required>
                    <input type="text" class="button" id="numbers2" name="numbers2" required>
                    <input type="submit" class="button" id="submit" value="OK">
                </div>
            </form>
            
            <input type="button" class="button" id="submit" value="Тестовые данные" 
                   style="position: absolute; left:500px; top:550px;"
                   onclick="document.getElementById('numbers1').value = '5 3 7 2 1 7'; 
                            document.getElementById('numbers2').value = '1 3 7 7 12 15';" >
        </c:if>

        <c:if test="${ sessionScope.intersect != null && sessionScope.union != null }" >
            <div style="text-align:center;" >
                intersect
                <c:out value="${sessionScope.intersect}"/>
                <br>

                union
                <c:out value="${sessionScope.union}"/>
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
