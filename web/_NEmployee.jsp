


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--

--%>
<jsp:useBean id="service" class="dbUrIdea.services.HRService"/>

<form action="v" method="post">



    <p>id_company<input type="hidden" name="idCompany" value="${company.id}"/></p>
    <p>id_email_address int<input type="hidden" name="id_email_address}"/></p>

    <p>CodArea <input type="text" name="idArea"/><p>
    <p>password<input type="text" name="password" value="${emp.password}"/></p>
    <p>employee_name <input type="text" name="employee_name" value="${emp.name}"/></p>
    <p>employee_first_last_name <input type="text" name="employee_first_last_name" value="${emp.firstLastName}"/></p>
    <p>employee_second_last_name <input type="text" name="employee_second_last_name" value="${emp.secondLastName}"/></p>
    <p>dni<input type="text" name="dni" value="${emp.dni}"/></p>
    <p>phone_number <input type="text" name="phone_number" value="${emp.phoneNumber}"/></p>
    <p>cell_phone_number<input type="text" name="cell_phone_number" value="${emp.cellPhoneNumber}"/></p>
    <p>address<input type="text" name="address" value="${emp.address}"/></p>
    <p>department <input type="text" name="department" value="${emp.department}"/></p>
    <p>birthdate <input type="text" name="birthdate" value="${emp.birthdate}"/></p>


    <input type="hidden" value="createEmplAdmin" name="action"/>
    <input type="submit"/>
</form>