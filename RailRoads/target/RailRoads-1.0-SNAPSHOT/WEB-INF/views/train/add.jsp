<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add train</title>
</head>
<body>


<form method="post" action="${pageContext.request.contextPath}/train/addPost">
    <div class="container mx-auto">

        <div class="form-group">
            <label for="RouteId">Route ID</label>
            <input name="RouteId" id="RouteId" type="text" class="form-control" placeholder="ID">
        </div>

        <!--  <div class="form-group">
            <label for="categoryId">Тематический раздел</label>
            <select class="form-control" id="categoryId" name="categoryId">
                c:forEach items="{categories}" var="category">
                    <option value="{category.getCategoryId()}">{category.getName()}</option>
                /c:forEach>
            </select>
        </div>
        -->
        <div class="form-group">
            <button type="submit" id="postButton" class="btn btn-success">Add</button>
        </div>

    </div>
</form>
</body>
</html>
