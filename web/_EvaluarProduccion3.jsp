
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--

--%>
<jsp:useBean id="service" class="dbUrIdea.services.HRService"/>
<h1>Evaluacion de Crecimiento Profesional  Produccion</h1>

<form action="TypeEmployeeValidation" method="post">

    <table border="1">

        <tr>
            <td>eficiente</td>
            <td> <input type="radio" name="efficiency" value="1">bajo
                <input type="radio" name="efficiency" value="2">medio
                <input type="radio" name="efficiency" value="4.77">alta
            </td>
        </tr>

        <tr>
            <td>desempeño</td>
            <td> <input type="radio" name="performance" value="1">bajo
                <input type="radio" name="performance" value="2">medio
                <input type="radio" name="performance" value="4.77">alto
            </td>
        </tr>


        <tr>
            <td>Fue productivo</td>
            <td> <input type="radio" name="productivity" value="1">bajo
                <input type="radio" name="productivity" value="2">medio
                <input type="radio" name="productivity" value="4.77">alto
            </td>
        </tr>

        <tr>
            <td>optimisa recursis</td>
            <td> <input type="radio" name="resource_optimization" value="1">bajo
                <input type="radio" name="resource_optimization" value="2">medio
                <input type="radio" name="resource_optimization" value="4.77">alto
            </td>
        </tr>



        <tr>
            <td>Innovo ?</td>
            <td> <input type="radio" name="innovative" value="1">bajo
                <input type="radio" name="innovative" value="2">medio
                <input type="radio" name="innovative" value="4.78">alto
            </td>
        </tr>





    </table>

    <p>Comentario
        <textarea name="comment"
                  cols="30" rows="10"></textarea>
    </p>
    <input type="hidden" value="createEvaluationProduccion3" name="action"/>
    <input type="submit"/>
</form>