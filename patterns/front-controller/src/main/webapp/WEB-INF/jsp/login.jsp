<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/5/2021
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bookshelf: Login</title>
</head>
<body>
    <p>Please input an username: </p>
    <h2>Login</h2>
    <form action="<%=request.getContextPath()%>/?command=Login" method="POST">
        <input type="text" name="username" placeholder="Username" />
        <input type="hidden" name="redirect" value="<%= (String) request.getAttribute("redirect")%>" />
        <input type="submit" value="Proceed">
    </form>
</body>
</html>
