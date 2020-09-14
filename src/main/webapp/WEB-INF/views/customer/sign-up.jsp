<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    </style>
</head>
<body class="bg-color">
<div class="container">
    <div class="row">
        <%--@elvariable id="customer" type="aj"--%>
        <form:form role="form" class="form-veritical"
                   action="/customer/save" method="post"
                   modelAttribute="customer">
            <div class="form-group">
                <label for="name">Name</label>
                <form:input type="text" path="name" class="form-control" id="name" placeholder="name" name="name"/>
                <form:errors path="name" cssStyle="color: red"></form:errors>
            </div>
            <div class="form-group">
                <label for="phone">Phone number</label>
                <form:input type="text" path="phoneNumber" value="+994" class="form-control" id="phone" placeholder="phone number"
                            name="phoneNumber"/>
                <form:errors path="phoneNumber" cssStyle="color: red"></form:errors>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input type="email" path="email" class="form-control" id="email" placeholder="email" name="email"/>
                <form:errors path="email" cssStyle="color: red"></form:errors>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <form:input type="text" path="password" class="form-control" id="password" placeholder="password" name="password"/>
                <form:errors path="password" cssStyle="color: red"></form:errors>
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form:form>
    </div>
    </tbody>
    </table>
</div>
</body>
</html>
