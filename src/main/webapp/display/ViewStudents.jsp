<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/16
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>ViewStudents</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div style="margin:auto;width: 1000px;">
<table class="table table-bordered table-hover">
    <caption>${className}成绩</caption>
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <c:forEach var="course" items="${courses}">
            <th>${course.course_name}</th>
        </c:forEach>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sa" items="${sandSCs }">
        <tr>
            <td>${sa.student.student_id}</td>
            <td>${sa.student.student_name}</td>
            <c:forEach var="course" items="${courses}">
                <c:set var="i" value="1"/>
                <c:forEach var="score" items="${sa.scores}">
                    <c:if test="${score.course_id==course.course_id}">
                        <td>${score.total_score}</td>
                        <c:set var="i" value="0"/>
                    </c:if>
                </c:forEach>
                <c:if test="${i==1}">
                    <td>null</td>
                </c:if>
            </c:forEach>
            <td><a href="${pageContext.request.contextPath}/DuplicateChecking/toViewStudent?id=${sa.student.student_id}">修改</a>
          </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
