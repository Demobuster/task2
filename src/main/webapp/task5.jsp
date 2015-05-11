<%-- 
    Document   : task5
    Created on : 27.04.2015, 5:15:06
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
        <title>Task5</title>
    </head>
    <body>

        <c:if test="${ sessionScope.res == null }" >
            <h4>5. Списки I(1..n) и U(1..n) содержат результаты n-измерений тока и напряжения на неизвестном сопротивлении R. 
                Найти приближенное число R методом наименьших квадратов </h4>
            <form action="Task5" method="get" >
                <div class="header">
                    <p>Задание №5</p>
                </div>
                <div class="description">
                    <p>Введите через пробел значения 2-х списков измерений I и U и количество измерений соответственно:
                    </p>
                </div>
                <div class="input">
                    <input type="text" class="button" id="I" name="numbersI" required>
                    <input type="text" class="button" id="U" name="numbersU" required>
                    <input type="text" class="button" id="N" name="N" required>
                    <input type="submit" class="button" id="submit" value="OK">
                </div>
            </form>
            
            <input type="button" class="button" id="submit" value="Тестовые данные" 
                   style="position: absolute; left:500px; top:550px;"
                   onclick="document.getElementById('I').value = '10 8 6 4 2'; 
                            document.getElementById('U').value = '5 4 3 2 1';
                            document.getElementById('N').value = '5';" >
        </c:if>

        <c:if test="${ sessionScope.res != null}" >
            <div style="text-align:center;" >
                Результат
                <br>
                <c:out value="${sessionScope.res}"/>
                <br>

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

