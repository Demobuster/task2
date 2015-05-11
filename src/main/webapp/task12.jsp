<%-- 
    Document   : task12
    Created on : 27.04.2015, 2:40:57
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
        <title>Task12</title>
    </head>
    <body>

        <c:if test="${ sessionScope.Task11Answer == null }" >
            <h4>12. В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый второй человек, 
                пока не останется один. Составить две программы, моделирующие процесс. Одна из программ должна использовать класс ArrayList, 
                а вторая – LinkedList. Какая из двух программ работает быстрее? Почему? </h4>
            <form action="Task12" method="get" >
                <div class="header">
                    <p>Задание №12</p>
                </div>
                <div class="description">
                    <p>Введите количество людей:
                    </p>
                </div>
                <div class="input">
                    <input type="text" class="button" id="numOfPeople" onsubmit="return validateForm()" 
                           name="numOfPeople" placeholder="7" required>
                    <input type="submit" class="button" id="submit" value="OK">
                </div>
            </form>
            
            <input type="button" class="button" id="submit" value="Тестовые данные" 
                   style="position: absolute; left:500px; top:500px;"
                   onclick="document.getElementById('numOfPeople').value = '9';" >
        </c:if>

        <c:if test="${ sessionScope.Task12Answer != null }" >
            <div style="text-align:center;" >
                <c:forEach items="${ sessionScope.Task12Answer }" var="element"> 
                    <br>
                    <c:out value="${element}"/>

                </c:forEach> 
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
