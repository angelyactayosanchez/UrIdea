
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
--%>
<jsp:useBean id="service" class="dbUrIdea.services.HRService"/>

<form action="email" method="post">

    <input type="text" name="emailData" />
    <input type="hidden" value="create" name="action"/>
    <input type="submit"/>
</form>