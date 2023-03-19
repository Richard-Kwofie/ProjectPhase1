<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Student</h2>
<form action="StudentController" method="post">
    <label>StudentID</label>
    <input type="number" name="StudentID"><br/>
    <label>StudentName</label>
    <input type="text" name="StudentName"><br/>
    
    <label>GradeID</label>                       
    <input type="number" name="GradeID"><br/>
   
    
    <input type="submit" value="Add Student">
    <input type="reset" value="reset">
</form>
</body>
</html>