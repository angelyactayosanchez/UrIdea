<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Magnus
  Date: 7/7/2017
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="service" class="dbUrIdea.services.HRService"/>
<h1>Desordenado</h1>
<c:forEach var="emailAddress" items="${service.emailAddresses}">

    <p><c:out value="${emailAddress.id}  ----> "/><c:out value=" ${emailAddress.emailData}"/> </p>

</c:forEach>
</body>
</html>
