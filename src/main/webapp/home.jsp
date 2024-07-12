<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Listado de Usuarios</h1>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>
        <table class="table table-bordered">
            <thead>
                <tr>
                <c:if test="${userRole == '1'}">
                    <th>ID</th>
                    <th>Correo</th>
                    <th>Nick</th>
                    <th>Nombre</th>
                    <th>Peso</th>
                    <th>Dirección</th>
                </c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="usuario" items="${usuarios}">
                    <tr>
                        <td><c:out value="${usuario.id}"/></td>
                        <td><c:out value="${usuario.correo}"/></td>
                        <td><c:out value="${usuario.nick}"/></td>
                        <td><c:out value="${usuario.nombre}"/></td>
                        <td><c:out value="${usuario.peso}"/></td>
                        <td>
                            <c:forEach var="direccion" items="${usuario.direcciones}">
                                <p><c:out value="${direccion.nombre}"/> <c:out value="${direccion.numeracion}"/></p>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>