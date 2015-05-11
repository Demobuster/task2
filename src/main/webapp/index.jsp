<%-- 
    Document   : index
    Created on : 13.04.2015, 13:32:44
    Author     : Sergey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/congratulations.css">
<title>Task 2 Welcome Page</title>

<style>
body {
	background: #F8A434;
	font-family: 'Lato', sans-serif;
	color: #FDFCFB;
	text-align: center;
}

.answer {
	position: absolute;
	left: 600px;
	top: 350px;
}
</style>
</head>
<body>
	<h1>Task 2 Welcome Page</h1>

	<form action="Manager" method="GET">
		<select name="taskNumber" onchange="this.form.submit()">
			<option value="">Choose a task...</option>
			<option value="1">TASK 1</option>
			<option value="2">TASK 2</option>
			<option value="3">TASK 3</option>
			<option value="4">TASK 4</option>
			<option value="5">TASK 5</option>
			<option value="6">TASK 6</option>
			<option value="7">TASK 7</option>
			<option value="8">TASK 8</option>
			<option value="9">TASK 9</option>
			<option value="10">TASK 10</option>
			<option value="11">TASK 11</option>
			<option value="12">TASK 12</option>
			<option value="13">TASK 13</option>
			<option value="14">TASK 14</option>
			<option value="15">TASK 15</option>
			<option value="16">TASK 16</option>
			<option value="17">TASK 17</option>
			<option value="18">TASK 18</option>
			<option value="19">TASK 19</option>
			<option value="20">TASK 20</option>
			<option value="21">TASK 21</option>
			<option value="22">TASK 22</option>
			<option value="23">TASK 23</option>
		</select>
	</form>
</body>
</html>
