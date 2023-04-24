<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new student</title>
</head>
<body>
<h1> create new student</h1>
<form method="post" action="studentManagement/add">
    <input type="text" name="studentName" placeholder="studentName">
    <input type="text" name="studentLastName" placeholder="studentLastName">
    <input type="text" name="studentMajor" placeholder="studentMajor">
    <input type="text" name="studentAddress" placeholder="studentAddress">
    <input type="text" name="studentCity" placeholder="studentCity">
    <input type="submit" value="Submit">
</form>
<br/>
<a href="<%=request.getContextPath()%>">Go Home</a>

</body>
</html>
