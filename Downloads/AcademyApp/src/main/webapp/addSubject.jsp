<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Subject</h2>
<form action="SubjectController" method="post">
   
   <!-- 
       <label>SubjectID</label>
    <input type="number" name="SubjectID"><br/>
   
    -->
    <label>SubjectName</label>
    <input type="text" name="SubjectName"><br/>
    
     <label>TeacherID</label>
    <input type="number" name="TeacherID"><br/>
     <label>GradeID</label>
    <input type="number" name="GradeID"><br/>
    
    <input type="submit" value="Add Subject">
    <input type="reset" value="reset">
</form>
</body>
</html>