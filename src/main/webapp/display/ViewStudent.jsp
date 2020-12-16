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
<form role="form">
    ${sandSC.student.student_name} ${sandSC.student.student_id}
    <table class="table table-bordered table-hover" style="margin-top:20px; ">
        <thead>
            <tr>
                <th>课程名</th>
                <th>平时成绩</th>
                <th>期末成绩</th>
                <th>总成绩</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${courses}">
                <c:set var="i" value="1"/>
                <c:forEach var="score" items="${sandSC.scores}">
                    <c:if test="${score.course_id==course.course_id}">
                        <tr>
                            <td>${course.course_name}</td>
                            <td>${score.usual_score}</td>
                            <td>${score.final_score}</td>
                            <td>${score.total_score}</td>
                            <td><a href="${pageContext.request.contextPath}/DuplicateChecking/toUpdateScore?student=${sandSC.student.student_id} &course=${course.course_id} ">修改</a></td>
                        </tr>
                        <c:set var="i" value="0"/>
                    </c:if>
                </c:forEach>
                <c:if test="${i==1}">
                    <tr>
                        <td>${course.course_name}</td>
                        <td>null</td>
                        <td>null</td>
                        <td>null</td>
                        <td><a href="${pageContext.request.contextPath}/DuplicateChecking/toUpdateScore?student=${sandSC.student.student_id} &course=${course.course_id}">修改</a></td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
</form>
</div>
</body>
</html>
