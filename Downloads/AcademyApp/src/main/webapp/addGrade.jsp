<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Grade</h2>
<form action="GradeController" method="post">
    <label>Section</label>
    <input type="number" name="Section"><br/>
    <input type="submit" value="Add Grade">
    <input type="reset" value="reset">
</form>
</body>
</html>