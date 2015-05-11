<%-- 
    Document   : task9
    Created on : 27.04.2015, 2:14:48
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
        <title>Task9</title>
    </head>
    <body>

        <c:if test="${ sessionScope.result == null }" >
            <h4>9. Задана строка, содержащая символы '(', ')', '[', ']', '{', '}'. Проверить правильность расстановки скобок. 
                Использовать стек</h4>
            <form action="Task9" method="get" >
                <div class="header">
                    <p>Задание №9</p>
                </div>
                <div class="description">
                    <p>Введите строку для проверки:</p>
                </div>
                <div class="input">
                    <input type="text" class="button" id="sequence" name="sequence" required>
                    <input type="submit" class="button" id="submit" value="OK">
                </div>
            </form>
            
            <input type="button" class="button" id="submit" value="Тестовые данные" 
                   style="position: absolute; left:500px; top:550px;"
                   onclick="document.getElementById('sequence').value = '(()[])}';" >
        </c:if>
        
        <c:if test="${ sessionScope.result != null }" >
            <div text-align="left" >
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

