<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add route</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/route/addPost">
    <div class="container mx-auto">

        <div class="form-group">
            <label for="stations">Stations</label>
            <input name="stations" id="stations" type="text" class="form-control" placeholder="stations">
        </div>

        <div class="form-group">
            <label for="arrivalTime">Arrival Time</label>
            <input name="arrivalTime" id="arrivalTime" type="text" class="form-control" placeholder="arrivalTime">
        </div>
        <div class="form-group">
            <label for="waitTime">Wait Time</label>
            <input name="waitTime" id="waitTime" type="text" class="form-control" placeholder="waitTime">
        </div>

        <div class="form-group">
            <button type="submit" id="postButton" class="btn btn-success">Add</button>
        </div>

    </div>
</form>
</body>
</html>
