<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yoshinon
  Date: 5/07/2017
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>lista Administradores</h1>
<jsp:useBean id="service" class="dbUrIdea.services.HRService"/>
<c:forEach var="employee" items="${service.findAdmin(1,company.id)}">
    <p><c:out value="${employee.name}"/>
        <c:out value="${employee.company.id}"/>
        <c:out value="${employee.employeeType}"/>
        <c:out value="${employee.dni}"/>
        <c:out value="${employee.emailAddress.emailData}"/>

        <a href="v?action=editTypeEmployee&idEmployee=<c:out value="${employee.id}"/>">
            Cambiar a Empleado
        </a>
    </p>
</c:forEach>
<a href="v?action=regresar&idCompany=<c:out value="${company.id}"/>">

    Regresar</a>
</body>
</html>
