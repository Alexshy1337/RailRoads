<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List all wagons</title>
</head>
<body>
<h1 class="h3 mb-2 text-gray-800"><?php echo $page_title; ?></h1>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h3 class="m-0 font-weight-bold text-primary">Train list</h3>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <tr>
                    <th>ID</th>
                    <th>TrainID</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                <c:forEach items="${wagons}" var="wagon">
                    <tr>
                        <th>${wagon.getId()}</th>
                        <th>${wagon.getTrainId()}</th>
                        <th>
                            <form action="${pageContext.request.contextPath}/wagon/delete" method="get" id="del_form${wagon.getId()}">
                                <input type="hidden" name="id" value="${wagon.getId()}">
                                <input type="submit" value="Delete" style="float:right" form="del_form${wagon.getId()}">
                            </form>
                        </th>
                        <th>
                            <form action="${pageContext.request.contextPath}/wagon/update" method="get" id="updform${wagon.getId()}">
                                <input type="hidden" name="id" value="${wagon.getId()}">
                                <input type="hidden" name="trainId" value="${wagon.getTrainId()}">
                                <input type="submit" value="Edit" style="float:right" form="updform${wagon.getId()}">
                            </form>
                        </th>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a href="${pageContext.request.contextPath}/wagon/add" class="btn btn-success btn-icon-split justify-content-lg-start">
                <span class="icon text-white-50"><i class="fas fa-plus-circle"></i></span>
                <span class="text">Add wagon</span>
            </a>
            <br>
            <a href="${pageContext.request.contextPath}" class="btn btn-success btn-icon-split justify-content-lg-start">
                <span class="icon text-white-50"><i class="fas fa-plus-circle"></i></span>
                <span class="text">Back</span>
            </a>
        </div>
    </div>
</div>
</body>
</html>
