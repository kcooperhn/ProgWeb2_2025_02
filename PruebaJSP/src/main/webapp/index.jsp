<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: KJ_Al
  Date: 11/6/2025
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html data-bs-theme="dark">
<head>
    <title>Inicio de Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
</head>
<body>
<%! List<String> paises = new ArrayList<>(); %>
<%
    if(!paises.isEmpty()) paises.clear();
    paises.add("Honduras");
    paises.add("Mexico");
    paises.add("Nicaragua");
    paises.add("Guatemala");
    paises.add("El Salvador");
%>
    <div class="container-md">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header text-center">
                        <h3>Inicio de Sesión</h3>
                    </div>
                    <div class="card-body">
                        <form method="post" action="validate">
                            <div class="mb-3">
                                <label for="username" class="form-label">Usuario</label>
                                <input type="text" class="form-control" id="username" name="username" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Clave</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>

                            <div class="input-group mb-3">
                                <label class="input-group-text" for="inputGroupSelect01">País</label>
                                <select class="form-select" id="inputGroupSelect01">
                                    <option selected>Seleccione un País...</option>
                                    <% int contador = 0;
                                        for(String pais: paises){
                                            contador++;
                                    %>
                                        <option value="<%= contador %>>"><%=pais%></option>
                                    <%  } %>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-outline-primary w-100">Ingresar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</body>
</html>
