<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org" lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="webjars/bootstrap/5.2.2/css/bootstrap.min.css">
    <title>Add Todo</title>
</head>
<body>
    <div class="container">
        <h1>Enter Todo Details</h1>
        <form:form method="post" modelAttribute="todo">
            Description: <form:input type="text" path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
            <form:input type="hidden" path="done"/>
            <form:input type="hidden" path="id"/>
            <input type="submit" class="btn btn-success">
        </form:form>
    </div>
    <script src="webjars/bootstrap/5.2.2/js/bootstrap.bundle.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>