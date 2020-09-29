<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/train/updatePost">
    <div class="container mx-auto">

        <input type="hidden" name = "id" value="${id}">

        <div class="form-group">
            <label for="RouteId">Route ID</label>
            <input name="RouteId" id="RouteId" type="text" class="form-control" value="${routeId}">
        </div>
        <div class="form-group">
            <button type="submit" id="postButton" class="btn btn-success">Save changes</button>
        </div>
    </div>
</form>

</body>
</html>
