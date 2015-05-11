<%-- 
    Document   : task14
    Created on : 27.04.2015, 3:05:49
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
        <title>Task14</title>
    </head>
    <body>
        <h4>14. Реализовать класс Graph, представляющий собой неориентированный граф. 
            В конструкторе класса передается количество вершин в графе. Методы должны поддерживать быстрое добавление и удаление ребер</h4>
        <form action="Task14" method="get" >
            <div class="header">
                <p>Задание №14</p> 
            </div>
            <div class="description">
                <p>Введите количество вершин, координаты вершины для добавления и
                    координаты вершины для удаления соответственно:</p>
            </div>
            <div class="input">
                <input type="text" class="button" id="vertexNum" name="vertexNum" placeholder="5" required>
                <input type="text" class="button" id="vertexToAdd" name="vertexToAdd" placeholder="4 3" required>
                <input type="text" class="button" id="vertexToDel" name="vertexToDel" placeholder="2 1" >
                <input type="submit" class="button" id="submit" value="OK">
            </div>
        </form>
        
        <input type="button" class="button" id="submit"
			value="Тестовые данные"
			style="position: absolute; left: 500px; top: 500px;"
			onclick="document.getElementById('vertexNum').value = '5';
                	 document.getElementById('vertexToAdd').value = '4 3';
                	 document.getElementById('vertexToDel').value = '2 1';" />
                	 
        <footer>
		<a href="index.jsp">К выбору заданий</a>
		<p>&copy; 2015 Serzh Petukhov</p>
	</footer>
    </body>
</html>
