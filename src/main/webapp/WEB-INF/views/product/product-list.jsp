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
            <div class="row">
                <c:forEach items="${productList}" var="product">
                <div class="col-lg-3">
                    <div class="card text-center">
                        <div class="card-header">
                            <h2>${product.getName()}</h2>
                        </div>
                        <div class="card-body">
                            <p class="card-text">${product.getDescription()}</p>
                            <h5 class="card-title">${product.getPrice()}</h5>
                            <a href="#" class="btn btn-primary">Add to cart</a>
                        </div>
                        <div class="card-footer text-muted">
                            ${product.getCreated()}
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </tbody>
    </table>
</div>
</body>
</html>
