<%-- 
    Document   : task6
    Created on : 27.04.2015, 1:46:28
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
        <title>Task6</title>
    </head>
    <body>

        <c:if test="${ sessionScope.result == null }" >
            <h4>6. С использованием множества выполнить попарное суммирование произвольного конечного ряда чисел по следующим правилам: 
                на первом этапе суммируются попарно рядом стоящие числа, на втором этапе суммируются результаты первого этапа и т.д. до тех пор, 
                пока не останется одно число</h4>
            <form action="Task6" method="get" >
                <div class="header">
                    <p>Задание №6</p>
                </div>
                <div class="description">
                    <p>Введите через пробел значения последовательности</p>
                </div>
                <div class="input">
                    <input type="text" class="button" id="email" name="numbers" required>
                    <input type="submit" class="button" id="submit" value="OK">
                </div>
            </form>
            
            <input type="button" class="button" id="submit" value="Тестовые данные" 
                   style="position: absolute; left:500px; top:550px;"
                   onclick="document.getElementById('email').value = '12 3 -6 14 2';" >
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

