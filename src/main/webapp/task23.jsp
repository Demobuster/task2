<%-- 
    Document   : task23
    Created on : 27.04.2015, 4:41:37
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
        <title>Task23</title>
    </head>
    <body>

        <h4>23. На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость. 
            Вывести первые K обгонов</h4>
        <form action="Task23" method="get" >
            <div class="header">
                <p>Задание №23</p>
            </div>
            <div class="description">
                <p>Введите количество автомобилей, их начальные положения относительно старта через пробел начиная с нуля,
                    их скорости и кол-во обгонов для просмотра соответственно:</p>
            </div>
            <div class="input">
                <input type="text" class="button" id="N" name="N" placeholder="5" required>
                <input type="text" class="button" id="positions" name="positions" placeholder="4 3 1 2 0" required>
                <input type="text" class="button" id="speeds" name="speeds" placeholder="15 10 25 5 12" required>
                <input type="text" class="button" id="k" name="k" placeholder="3" >
                <input type="submit" class="button" id="submit" value="OK">
            </div>
            
            <input type="button" class="button" id="submit" value="Тестовые данные" 
                   style="position: absolute; left:500px; top:500px;"
                   onclick="document.getElementById('N').value = '5';
                	   		document.getElementById('positions').value = '4 3 1 2 0';
                	   		document.getElementById('speeds').value = '15 10 25 5 12';
                	   		document.getElementById('k').value = '3'; " >
        	</form>

		<c:if test="${ param.message == 'true' }">
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