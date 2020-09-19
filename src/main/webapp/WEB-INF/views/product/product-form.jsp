<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
        .id-visible {
            display: none;
        }
    </style>
</head>
<body>
<jsp:include page="../navbar-product.jsp"></jsp:include>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="view" value="${idView}" />

<div class="container">
    <%--@elvariable id="product" type="aj"--%>
    <form:form action="${ctx}/product/save" method="post" class="form" modelAttribute="product">
        <div class="form-group ${view}">
            <label for="name">ID</label>
            <input type="text" name="productId" id="id" ${view} value="${product.getProductId()}">
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" name="name" id="name" placeholder="product name" value="${product.getName()}">
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" name="price" id="price" placeholder="price" value="${product.getPrice()}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" placeholder="description" name="description" rows="3">${product.getDescription()}</textarea>
        </div>
        <input type="submit" class="btn btn-success" value="Submit">
    </form:form>
</div>
</body>
</html>
