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
    <style>
        .bg-color {
            background: rgba(116, 211, 248, 0.215);
        }
        .count {
            margin-top: 1rem;
            width: 100%;
        }
    </style>
</head>
<body class=" bg-color">
<jsp:include page="../navbar-customer.jsp"></jsp:include>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

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
                            <button type="button" class="btn btn-primary" onclick={addProduct('${product.getProductId()}')}>Add to cart</button>
                        </div>
                        <div class="card-footer text-muted">
                            ${product.getUpdated()}
                        </div>
                        <div class="count">
                            <button type="button" onclick={minus('${product.getProductId()}')}>-</button>
                            <span id="${product.getProductId()}" class="defValue"></span>
                            <button type="button" onclick={plus('${product.getProductId()}')}>+</button>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </tbody>
    </table>
</div>
<script>
    let count = document.getElementsByClassName("defValue")
    for (let i=0;i<count.length; i++) {
        count[i].innerHTML=1;
    }
    function minus(id) {
        count = parseInt(document.getElementById(id).innerHTML);
        count--
        if(count<1) return false
        document.getElementById(id).innerHTML= count;
        }

    function plus(id) {
        count = parseInt(document.getElementById(id).innerHTML);
        count++
        document.getElementById(id).innerHTML= count;
    }
let getquantity;
    let getid;
    let products = [];
    function addProduct(id) {
         getid=id;
         getquantity = document.getElementById(id).innerText;
         products.push({productId: getid, quantity: getquantity});
    }
</script>

<%--<a href="${ctx}/order" onclick="goToCard(this)">Go To Card</a>--%>

    <script>
        function goToCard(e){
            e.href = e.href + "?products=" + JSON.stringify(products);
        }
    </script>
</body>
</html>
