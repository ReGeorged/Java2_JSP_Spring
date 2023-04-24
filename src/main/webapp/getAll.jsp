<%@ page import="com.exam.assignment.StudentServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All students</title>
</head>
<body>
<% StudentServlet.getAllUsers(request,response);
 %>

<a href="<%=request.getContextPath()%>">Go Home</a>

</body>
</html>
