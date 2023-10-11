
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Cliente, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?param1=cliente" method="post">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${atribCliente.getDni()}" name="txtDni" class="form-control" maxlength="10">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${atribCliente.getNombre()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${atribCliente.getDireccion()}" name="txtDireccion" class="form-control" maxlength="9">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${atribCliente.getEstado()}" name="txtEstado" class="form-control" maxlength="1">
                        </div>
                        
                        <input class="btn btn-info" type="submit" name="param2" value="Agregar">
                        <input class="btn btn-success" type="submit" name="param2" value="Actualizar">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Dni</th>
                            <th>Nombres</th>
                            <th>Direccion</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Cliente> clientes = null;
                            clientes = (ArrayList<Cliente>) request.getAttribute("clientes");
                            if (clientes != null) {
                                for (Cliente cliente : clientes) {
                        %>
                        <tr>
                            <td><%=cliente.getId()%></td>
                            <td><%=cliente.getDni()%></td>
                            <td><%=cliente.getNombre()%></td>
                            <td><%=cliente.getDireccion()%></td>
                            <td><%=cliente.getEstado()%></td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?param1=cliente&param2=modificar&id=<%=cliente.getId()%>">Editar</a>
                                <a class="btn btn-danger" href="Controlador?param1=cliente&param2=eliminar&id=<%=cliente.getId()%>">Eliminar</a>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
