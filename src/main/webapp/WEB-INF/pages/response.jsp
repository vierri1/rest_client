<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 29/10/2018
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>response</title>
</head>
<body>
<p>Status: ${response.status}</p>
<c:forEach items="${response.stopList}" var="stop">
    Id:${stop.id}<br/>
    Date:${stop.data}<br/>
    Period:${stop.period}<br/>
</c:forEach>
</body>
</html>
