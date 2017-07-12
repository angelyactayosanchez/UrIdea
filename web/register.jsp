<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 11/07/2017
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Formulario Login</title>

    <!-- CSS de Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"> <!--Iconos-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500" >
    <link rel="stylesheet" href="css/custom.css">

</head>

<body>
<div class="my-content" >
    <div class="container" >
        <div class="row">
            <div class="col-sm-12" >
                <h1><strong>Plusis</strong> Formulario de Registro</h1>
                <div class="mydescription">
                    <p>Formulario de Registro diseñado con Bootstrap. </p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3 myform-cont" >
                <div class="myform-top">
                    <div class="myform-top-left">
                        <h3>Regístrate en nuestro sitio.</h3>
                        <p>Por favor ingresa tus datos personales:</p>
                    </div>
                    <div class="myform-top-right">
                        <i class="fa fa-user"></i>
                    </div>
                </div>
                <div class="myform-bottom">
                    <form role="form" action="" method="post" class="">
                        <div class="form-group">
                            <input type="text" name="form-firtsname" placeholder="Nombres..." class="form-control" id="form-firtsname">
                        </div>
                        <div class="form-group">
                            <input type="text" name="form-lastname" placeholder="Apellidos..." class="form-control" id="form-lastname">
                        </div>
                        <div class="form-group">
                            <input type="text" name="form-email" placeholder="Email..." class="form-control" id="form-email">
                        </div>
                        <button type="submit" class="mybtn">Registrarme</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12 mysocial-login">
                <h3>...ingresa también por:</h3>
                <div class="mysocial-login-buttons" >
                    <a class="mybtn-social" href="#">
                        <i class="fa fa-facebook"></i> Facebook
                    </a>
                    <a class="mybtn-social" href="#">
                        <i class="fa fa-twitter"></i> Twitter
                    </a>
                    <a class="mybtn-social" href="#">
                        <i class="fa fa-google-plus"></i> Google Plus
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Enlazamos el js de Bootstrap, y otros plugins que usemos siempre al final antes de cerrar el body -->
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>