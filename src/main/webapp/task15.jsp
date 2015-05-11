<%-- 
    Document   : task15
    Created on : 27.04.2015, 3:06:20
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
        <title>Task15</title>
    </head>
    <body>

        <c:if test="${ sessionScope.storedData == null && sessionScope.number == null && sessionScope.index == null }" >
            <h4>15. На базе коллекций реализовать структуру хранения чисел с поддержкой следующих операций:
                - добавление/удалениечисла;<br>
                - поиск числа, наиболее близкого к заданному (т.е. модуль разницы минимален).
            </h4>
            <form action="Task15" method="get" >
                <div class="header">
                    <p>Задание №15</p>
                </div>
                <div class="description">
                    <p>Введите через пробел значения и искомое число соответственно в поля ниже
                    </p>
                </div>
                <div class="input">
                    <input type="text" class="button" id="numbers" name="numbers" required>
                    <input type="text" class="button" id="X" name="X" required>
                    <input type="submit" class="button" id="submit" value="OK">
                </div>
            </form>
            
            <input type="button" class="button" id="submit"
			value="Тестовые данные"
			style="position: absolute; left: 500px; top: 500px;"
			onclick="document.getElementById('numbers').value = '4 9 6 5 8 2 11 3';
                                 document.getElementById('X').value = '7';">
        </c:if>

        <c:if test="${ sessionScope.storedData != null && sessionScope.number != null && sessionScope.index != null }" >
            <div style="text-align: center;">
                storedData
                <c:forEach items="${ sessionScope.storedData }" var="element"> 
                    <c:out value="${element}"/>
                </c:forEach> 

                <br>
                number
                <c:out value="${sessionScope.number}"/>
                <br>

                index
                <c:out value="${sessionScope.index}"/>
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
