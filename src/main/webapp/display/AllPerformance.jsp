
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/14
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <style type="text/css">
        .btn{
            padding-top: 8px;
            padding-bottom: 8px;
            text-align: left;
        }
    </style>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="margin:auto;width: 1000px;">
<table class="table table-bordered table-hover">
    <caption>班级成绩</caption>
    <thead>
    <tr>
        <th>班级ID</th>
        <th>班级名</th>
        <th>平时成绩</th>
        <th>平时成绩平均分</th>
        <th>考试成绩</th>
        <th>考试成绩平均分</th>
        <th>总成绩</th>
        <th>总成绩平均分</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ca" items="${candCS }">
        <tr>
            <td>${ca.classScore.class_id }</td>
            <td><a href="${pageContext.request.contextPath}/DuplicateChecking/toViewStudents?value=${ca.aClass.class_name}">${ca.aClass.class_name}</a></td>
            <td>${ca.classScore.usual_score }</td>
            <td>${ca.classScore.avg_usual_score }</td>
            <td>${ca.classScore.final_score }</td>
            <td>${ca.classScore.avg_final_score }</td>
            <td>${ca.classScore.total_score }</td>
            <td>${ca.classScore.avg_total_score }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
