
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Empleado" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

        <title>XD</title>
    </head>
    <body>
        <%
            Empleado em = (Empleado) request.getAttribute("usuario");
        %>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                         <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#" >Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?param1=producto&param2=listar" target="myFrame">Producto</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?param1=empleado&param2=listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?param1=cliente&param2=listar" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?param1=nuevaVenta" target="myFrame">Nueva venta</a>
                    </li>
                </ul>

            </div>
            <div class="dropdown">
                <button style="margin-left: 10px; border: none" class="btn btn-outline-light dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
                    <%= em.getNombre()%>
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">
                        <img src="img/user.jpg" alt="" width="60px"/>
                    </a>
                    <a class="dropdown-item" href="#" ><%= em.getUser() %></a>
                    <a class="dropdown-item" href="#">Hola@sexo.com</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="post">
                        <button name="accion" value="salir" class="dropdown-item" href="#">Salir de exit</button>
                    </form>
                </div>
            </div>
        </nav>
                    <div class="m-4" style="height: 550px;">
                        <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
                    </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

    </body>
</html> 