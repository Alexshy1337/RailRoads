<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="row">

        <div class="col-xl-3 col-md-3 mb-4">
            <div class="card shadow h-100">
                <div class="card-header py-3">
                    <h3 class="m-0 font-weight-bold text-primary">List of all subjects</h3>
                </div>
                <div class="card-body mx-auto"><br>
                    <div class="btn-group-vertical">
                        <a href="${pageContext.request.contextPath}/train/list" class="btn btn-success btn-icon-split justify-content-lg-start">
                            <span class="icon text-white-50"><i class="fas fa-plus-circle"></i></span>
                            <span class="text">Trains</span>
                        </a>
                        <div class="my-2"></div><br>
                        <a href="${pageContext.request.contextPath}/wagon/list" class="btn btn-warning btn-icon-split justify-content-lg-start">
                            <span class="icon text-white-50"><i class="fas fa-list"></i></span>
                            <span class="text">Wagons</span>
                        </a>
                        <div class="my-2"></div><br>
                        <a href="${pageContext.request.contextPath}/locomotive/list" class="btn btn-warning btn-icon-split justify-content-lg-start">
                            <span class="icon text-white-50"><i class="fas fa-list"></i></span>
                            <span class="text">Locomotives</span>
                        </a>
                        <div class="my-2"></div><br>
                        <a href="${pageContext.request.contextPath}/route/list" class="btn btn-warning btn-icon-split justify-content-lg-start">
                            <span class="icon text-white-50"><i class="fas fa-list"></i></span>
                            <span class="text">Routes</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <!--
        <div class="col-xl-3 col-md-3 mb-4">
            <div class="card shadow h-100">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Управление выставками</h6>
                </div>
                <div class="card-body mx-auto">
                    <div class="btn-group-vertical">
                        <a href="${pageContext.request.contextPath}/exhibition/add" class="btn btn-success btn-icon-split justify-content-lg-start">
                            <span class="icon text-white-50"><i class="fas fa-plus-circle"></i></span>
                            <span class="text">Организовать выставку</span>
                        </a>
                        <div class="my-2"></div>
                        <a href="${pageContext.request.contextPath}/exhibition/list" class="btn btn-warning btn-icon-split justify-content-lg-start">
                            <span class="icon text-white-50"><i class="fas fa-list"></i></span>
                            <span class="text">Список всех выставок</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-xl-3 col-md-3 mb-4">
            <div class="card shadow h-100">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Управление тематическими разделами</h6>
                </div>
                <div class="card-body mx-auto">
                    <div class="btn-group-vertical">
                        <a href="${pageContext.request.contextPath}/category/add" class="btn btn-success btn-icon-split justify-content-lg-start">
                            <span class="icon text-white-50"><i class="fas fa-plus-circle"></i></span>
                            <span class="text">Добавить тематический раздел</span>
                        </a>
                        <div class="my-2"></div>
                        <a href="${pageContext.request.contextPath}/category/list" class="btn btn-warning btn-icon-split justify-content-lg-start">
                            <span class="icon text-white-50"><i class="fas fa-list"></i></span>
                            <span class="text">Список всех тематических разделов</span>
                        </a>
                    </div>
                </div>
            </div>
        </div> -->
    </div>

