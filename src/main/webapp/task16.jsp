<%-- 
    Document   : task16
    Created on : 27.04.2015, 3:21:35
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
        <title>Task16</title>
    </head>
    <body>

        <c:if test="${ sessionScope.result == null }" >
            <h4>16. Во входном файле расположены два набора положительных чисел; между наборами стоит отрицательное число. 
                Построить два списка C1 и С2, элементы которых содержат соответственно числа 1-го и 2-го набора таким образом, 
                чтобы внутри одного списка числа были упорядочены по возрастанию. Затем объединить списки C1 и С2 в один упорядоченный список </h4>
            <form action="upload" enctype="multipart/form-data" method="POST">
			<input type="file" name="file1"><br> 
			<input type="Submit" value="Upload File"><br>
		</form>

		<c:set var="taskNumber" value="16" scope="session" />
        </c:if>

        <c:if test="${ sessionScope.result != null }" >
            <div style="text-align: center;">
                <c:forEach items="${ sessionScope.result }" var="element"> 
                    <c:out value="${element}"/>
                </c:forEach> 
            </div>
        </c:if>
        
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
