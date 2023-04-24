<%@ page import="com.exam.java_giorgi_bazierashvili.studentServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All students</title>
</head>
<body>
<% studentServlet.getAllUsers(request,response);
 %>

<a href="<%=request.getContextPath()%>">Go Home</a>

</body>
</html>
