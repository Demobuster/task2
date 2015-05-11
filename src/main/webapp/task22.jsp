<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/form.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
        <title>Task22</title>
    </head>
    <body>

        <h4>22. На прямой гоночной трассе стоит N автомобилей, для каждого из которых известны начальное положение и скорость. 
            Определить, сколько произойдет обгонов</h4>
        <form action="Task22" method="get" >
            <div class="header">
                <p>Задание №22</p>
            </div>
            <div class="description">
                <p>Введите количество автомобилей, их начальные положения ПО ПОРЯДКУ через пробел начиная с нуля,
                    их скорости в условных единицах соответственно (опционально, если требуется отображение также введите масштаб отображения в у.е. ).
                    (Если требуется аналитический ответ - оставьте последнее поле пустым.)
                
                </p>
            </div>
            <div class="input">
                <input type="text" class="button" id="N" name="N" placeholder="5" required>
                <input type="text" class="button" id="positions" name="positions" placeholder="4 3 1 2 0" required>
                <input type="text" class="button" id="speeds" name="speeds" placeholder="15 10 25 5 12" required>
                <input type="text" class="button" id="scale" name="scale" placeholder="если нужна визуализация, не больше 5 машин">
                <input type="submit" class="button" id="submit" value="OK">
            </div>
            
            <input type="button" class="button" id="submit" value="Тестовые данные" 
                   style="position: absolute; left:500px; top:500px;"
                   onclick="document.getElementById('N').value = '5';
                	   		document.getElementById('positions').value = '4 3 1 2 0';
                	   		document.getElementById('speeds').value = '15 10 25 5 12';
                	   		document.getElementById('scale').value = '100'; " >
        </form>
	
	<footer>
		<a href="index.jsp">К выбору заданий</a>
		<p>&copy; 2015 Serzh Petukhov</p>
	</footer>
    </body>
</html>
