
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://bootstrapjsp.org/" prefix="b" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="service" class="dbUrIdea.services.HRService"/>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Editar Evaluación</title>

    <!-- Bootstrap Core CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-sb-admin/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-sb-admin/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="https://blackrockdigital.github.io/startbootstrap-sb-admin/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="https://blackrockdigital.github.io/startbootstrap-sb-admin/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <style>
        th{
            height: 24px;
            line-height: 24px;
            color: #d5d5d5;
            background-color:#000000;
            text-align: center;
            vertical-align: middle;
        }
    </style>


</head>

<body style="background-image:url(https://previews.123rf.com/images/vska/vska1302/vska130200153/18156383-abstract-circuit-cyber-high-technology-business-background-Stock-Vector.jpg)" class="fa-home">

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><img src="image/logo.jpg" width="40" height="30"></a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Administrador <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="TypeEmployeeValidation?action=PerfilAdmin"><i class="fa fa-fw fa-user"></i> Perfil</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-envelope"></i> Mensaje</a>
                    </li>

                    <li class="divider"></li>
                    <li>
                        <a href="index.jsp"><i class="fa fa-fw fa-power-off"></i>Cerrar Sesión</a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li class="active">
                    <a href="TypeEmployeeValidation?action=regresar"><i class="fa fa-fw fa-dashboard"></i> Menú</a>
                </li>
                <li>
                    <a href="TypeEmployeeValidation?action=editEmployee"><i class="fa fa-fw fa-bar-chart-o"></i> Editar Cuenta</a>
                </li>
                <li>
                    <a href="newEmpEmail2.jsp"><i class="fa fa-fw fa-table"></i> Agregar Empleado</a>
                </li>
                <li>
                    <a href="TypeEmployeeValidation?action=lista"><i class="fa fa-fw fa-edit"></i> Listar Empleados</a>
                </li>

                <li>
                    <a href="TypeEmployeeValidation?action=editCorre"><i class="fa fa-fw fa-wrench"></i> Editar Email</a>
                </li>


            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>



    <h1></h1>

    <c:forEach var="employee" items="${service.findAllEmployeeById(employee.id)}">

        <p align="center">Nombre  <c:out value="${employee.name} "/></p>

    </c:forEach>


    <section class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" align="center">Editar Evaluación de Valores del Practicante</h3>
                    </div>
                    <div class="panel-body">



                        <form action="TypeEmployeeValidation" method="post">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <tr>
                                        <th>Característica</th>
                                        <th>Bajo</th>
                                        <th>Medio</th>
                                        <th>Alto</th>
                                    </tr>


                                    <tr>
                                        <td></td>
                                        <td align="center"> <input type="radio" name="punctuality" value="1" checked></td>
                                        <td align="center">   <input type="radio" name="punctuality" value="3"></td>
                                        <td align="center">   <input type="radio" name="punctuality" value="6.66">
                                        </td>
                                    </tr>



                                    <tr>
                                        <td></td>
                                        <td align="center"> <input type="radio" name="honesty" value="1" checked></td>
                                        <td align="center">    <input type="radio" name="honesty" value="3"></td>
                                        <td align="center">   <input type="radio" name="honesty" value="6.66">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Comparte el logro con su equipo de trabajo</td>
                                        <td align="center"> <input type="radio" name="organized" value="1" checked></td>
                                        <td align="center">   <input type="radio" name="organized" value="3"></td>
                                        <td align="center">   <input type="radio" name="organized" value="6.66">
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>Usa de manera responsable los recursos de empresa</td>
                                        <td align="center"> <input type="radio" name="responsibility" value="1" checked></td>
                                        <td align="center">   <input type="radio" name="responsibility" value="3"></td>
                                        <td align="center">    <input type="radio" name="responsibility" value="6.66">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Muestra Transparencia y Confianza al encargarle alguna compra</td>
                                        <td align="center"> <input type="radio" name="respect" value="1" checked></td>
                                        <td align="center">   <input type="radio" name="respect" value="3"></td>
                                        <td align="center">   <input type="radio" name="respect" value="6.66">
                                        </td>
                                    </tr>







                                </table>

                            </div>
                            <br>
                            <input type="hidden" value="createEvaluation2Editar" name="action"/>
                            <p align="center"><button input type="submit" class="btn btn-primary">Siguiente</button></p>
                        </form>


                    </div>
                </div>
            </div>
        </div>
    </section>



</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="https://blackrockdigital.github.io/startbootstrap-sb-admin/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="https://blackrockdigital.github.io/startbootstrap-sb-admin/js/bootstrap.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="https://blackrockdigital.github.io/startbootstrap-sb-admin/js/plugins/morris/raphael.min.js"></script>
<script src="https://blackrockdigital.github.io/startbootstrap-sb-admin/js/plugins/morris/morris.min.js"></script>
<script src="https://blackrockdigital.github.io/startbootstrap-sb-admin/js/plugins/morris/morris-data.js"></script>

</body>

</html>