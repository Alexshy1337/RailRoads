<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/route/updatePost">
    <div class="container mx-auto">

        <input type="hidden" name = "id" value="${id}">

        <div class="form-group">
            <label for="stations">Stations</label>
            <input name="stations" id="stations" type="text" class="form-control" value="${stations}">
        </div>
        <div class="form-group">
        <label for="arrivalTime">Arrival Time</label>
        <input name="arrivalTime" id="arrivalTime" type="text" class="form-control" value="${arrivalTime}">
        </div>
        <div class="form-group">
        <label for="waitTime">Wait Time</label>
        <input name="waitTime" id="waitTime" type="text" class="form-control" value="${waitTime}">
        </div>
        <div class="form-group">
            <button type="submit" id="postButton" class="btn btn-success">Save changes</button>
        </div>
    </div>
</form>

</body>
</html>
