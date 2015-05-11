<%-- 
    Document   : task18
    Created on : 27.04.2015, 3:42:06
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
        <title>Task18</title>
    </head>
    <body>

        <h4>18. На клетчатой бумаге нарисован круг. Вывести в файл описания всех клеток, целиком лежащих внутри круга, 
            в порядке возрастания расстояния от клетки до центра круга. Использовать класс PriorityQueue.
        </h4>
        <form action="Task18" method="get" >
            <div class="header">
                <p>Задание №18</p>
            </div>
            <div class="description">
                <p>Введите координаты центра и радиус соответственно: 
                </p>
            </div>
            <div class="input">
                <input type="text" class="button" id="center" name="center" placeholder="3 2" required>
                <input type="text" class="button" id="radius" name="radius" placeholder="5" required>
                <input type="submit" class="button" id="submit" value="OK">
            </div>
        </form>
        
        <input type="button" class="button" id="submit"
			value="Тестовые данные"
			style="position: absolute; left: 500px; top: 500px;"
			onclick="document.getElementById('center').value = '3 2';
                	 document.getElementById('radius').value = '5'; ">
                	 
		<a href="http://task2-serzh.rhcloud.com/upload?fName=EighteenthTaskOutput.doc">Result</a>
        
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

