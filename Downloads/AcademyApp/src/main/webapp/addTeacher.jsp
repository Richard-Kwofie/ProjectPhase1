<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Teacher</h2>
<form action="TeacherController" method="post">
   
   <!-- 
   
     <label>TeacherID</label>
    <input type="number" name="TeacherID"><br/>
   
    -->
    <label>TeacherName</label>
    <input type="text" name="TeacherName"><br/>
    <input type="submit" value="Add Teacher">
    <input type="reset" value="reset">
</form>
</body>
</html>