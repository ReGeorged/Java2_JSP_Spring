
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<h1> create new student</h1>
<form method="post" action="hello-servlet">
    <input type="text" name="studentName" placeholder="studentName">
    <input type="text" name="studentLastName" placeholder="studentLastName">
    <input type="text" name="studentMajor" placeholder="studentMajor">
    <input type="text" name="studentAddress" placeholder="studentAddress">
    <input type="text" name="studentCity" placeholder="studentCity">
    <input type="submit" value="Submit">
</form>
<br/>

<h2>get all students</h2>

<form method="get" action="hello-servlet">
    <input type="submit" name= getAllUsers value="Submit">
</form>



<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>