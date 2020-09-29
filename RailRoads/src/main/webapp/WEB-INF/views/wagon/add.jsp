<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add wagon</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/wagon/addPost">
    <div class="container mx-auto">

        <div class="form-group">
            <label for="trainId">Train ID</label>
            <input name="trainId" id="trainId" type="text" class="form-control" placeholder="ID">
        </div>

        <div class="form-group">
            <button type="submit" id="postButton" class="btn btn-success">Add</button>
        </div>

    </div>
</form></body>
</html>
