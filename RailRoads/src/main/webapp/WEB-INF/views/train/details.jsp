
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Details</title>
</head>
<body>
<h1 class="h3 mb-2 text-gray-800"><?php echo $page_title; ?></h1>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h3 class="m-0 font-weight-bold text-primary">Train</h3>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <tr>
                    <th>ID</th>
                    <th>RouteID</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                <tr>
                    <th>${train.getId()}</th>
                    <th>${train.getRouteId()}</th>
                    <th>
                        <form action="${pageContext.request.contextPath}/train/delete" method="get" id="form${train.getId()}">
                            <input type="hidden" name="id" value="${train.getId()}">
                            <input type="submit" value="Delete" style="float:right" form="form${train.getId()}">
                        </form>
                    </th>
                    <th>
                        <form action="${pageContext.request.contextPath}/train/update" method="get" id="form${train.getId()}">
                            <input type="hidden" name="id" value="${train.getId()}">
                            <input type="hidden" name="routeId" value="${train.getRouteId()}">
                            <input type="submit" value="Edit" style="float:right" form="form${train.getId()}">
                        </form>
                    </th>
                </tr>
            </table>
            <br>
            <h2>Wagons</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>TrainID</th>
                </tr>
                <c:forEach items="${wagons}" var="wagon">

                    <tr>
                        <th>${wagon.getId()}</th>
                        <th>${wagon.getTrainId()}</th>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <h2>Locomotives</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <th>TrainID</th>
                </tr>
                <c:forEach items="${locomotives}" var="locomotive">

                    <tr>
                        <th>${locomotive.getId()}</th>
                        <th>${locomotive.getTrainId()}</th>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a href="${pageContext.request.contextPath}/train/list" class="btn btn-success btn-icon-split justify-content-lg-start">
                <span class="icon text-white-50"></span>
                <span class="text">Back</span>
            </a>
        </div>
    </div>
</div>
</body>
</html>
