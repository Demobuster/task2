<%-- 
    Document   : task7
    Created on : 27.04.2015, 1:53:57
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
        <title>Task7</title>
    </head>
    <body>

        <c:if test="${ sessionScope.result == null && sessionScope.error == null }" >
            <h4>7. Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся в объекте HashMap</h4>
            <form action="Task7" method="get" >
                <div class="header">
                    <p>Задание №7</p>
                </div>
                <div class="description">
                    <p>Введите два многочлена в формы соответственно</p>
                </div>
                <div class="input">
                    <input type="text" class="button" id="equation1" name="equation1" placeholder="12*x^4 + 1*x^3 - 27*x^2 - 9 * x^1 + 23" required>
                    <input type="text" class="button" id="equation2" name="equation2" placeholder="18*x^4 + 9*x^3 - 23*x^2 - 1 * x^1 + 23" required>
                    <input type="submit" class="button" id="submit" value="OK">
                </div>
            </form>
            
            <input type="button" class="button" id="submit" value="Тестовые данные" 
                   style="position: absolute; left:500px; top:550px;"
                   onclick="document.getElementById('equation1').value = '12*x^4 + 1*x^3 - 27*x^2 - 9 * x^1 + 23';
                	   		document.getElementById('equation2').value = '18*x^4 + 9*x^3 - 23*x^2 - 1 * x^1 + 23';" >
        </c:if>

        <c:if test="${ sessionScope.result != null }" >
            <div style="text-align:center;" >
                Результат:
                <c:out value="${sessionScope.result}"/>
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


