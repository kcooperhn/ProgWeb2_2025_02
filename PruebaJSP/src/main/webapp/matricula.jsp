<%@ page import="uth.hn.pruebajsp.Alumno" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: KJ_Al
  Date: 12/6/2025
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html data-bs-theme="dark">
<head>
    <title>Matricula</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">

</head>
<body>
<div class="container mt-5">
  <h3>Gestión de Alumnos</h3>
    <%
        List<Alumno> alumnos = (List<Alumno>) session.getAttribute("alumnos");
        if(alumnos == null){
            alumnos = new ArrayList<>();
            session.setAttribute("alumnos", alumnos);
        }
    %>

    <form action="alumnos_matricula" method="post" class="mb-3">
        <div class="row">
            <div class="col-md-4">
                <input type="text" name="identidad" class="form-control" placeholder="Identidad" required>
            </div>
            <div class="col-md-4">
                <input type="text" name="nombre" class="form-control" placeholder="Nombre" required>
            </div>
            <div class="col-md-4">
                <input type="text" name="apellido" class="form-control" placeholder="Apellido" required>
            </div>
            <div class="col-md-4">
                <input type="email" name="correo" class="form-control" placeholder="nombre@correo" required>
            </div>
            <div class="col-md-4">
                <button type="submit" name="action" value="create" class="btn btn-success w-100">Matricular</button>
            </div>
        </div>
    </form>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>Identidad</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Correo</th>
            </tr>
        </thead>
        <tbody>
            <%  for (Alumno al: alumnos) {%>
                <tr>
                    <td> <%= al.getIdentidad() %> </td>
                    <td> <%= al.getNombre() %> </td>
                    <td> <%= al.getApellido() %> </td>
                    <td> <%= al.getEmail() %> </td>

                    <td>
                        <form action="alumnos_matricula" method="post" class="d-inline">
                            <input type="hidden" name="identidad" value="<%= al.getIdentidad() %>">
                            <button type="submit" name="action" value="delete">Eliminar</button>
                        </form>
                    </td>
                </tr>
            <%  }%>
        </tbody>
    </table>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>

</body>
</html>
