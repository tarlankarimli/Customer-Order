<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>
<div class="container-fluid">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Product name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Update date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="product">
            <tr>
                <td> <c:out value="${product.getProductId() }"/></td>
                <td> <c:out value="${product.getName() }"/></td>
                <td> <c:out value="${product.getPrice() }"/></td>
                <td> <c:out value="${product.getDescription() }"/></td>
                <td> <c:out value="${product.getUpdated() }"/></td>
                <td>
                    <a class="btn button btn-danger" href="${ctx}/product/delete?id=${product.getProductId()}">Delete</a>
                    <a class="btn button btn-warning" href="${ctx}/product/update?id=${product.getProductId()}">Update</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
    </tbody>
    </table>
</div>
</body>
</html>
