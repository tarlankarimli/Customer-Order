<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .logout {
            padding: 10px;
        }
    </style>
</head>
<body>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${ctx}/product/list">1001 Xırdavat</a>
        </div>
        <ul class="nav navbar-nav">

            <li><a href="${ctx}/product/list">PRODUCTS</a></li>
            <li><a href="${ctx}/order/items" onclick="goToCard(this)">Go To Card</a></li>
        </ul>
        <div class="text-right logout"><a class="btn btn-primary" href="${ctx}/logout">LOG OUT</a></div>
    </div>
</nav>

</body>
</html>
