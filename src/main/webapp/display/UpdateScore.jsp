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
    <title>UpdateScore</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="margin:auto;width:1200px;">
<form role="form" action="${pageContext.request.contextPath}/DuplicateChecking/Update">

    ${student.student_name} ${course.course_name}
    <table class="table table-bordered table-hover" style="margin-top:20px; ">
        <thead>
        <tr>
            <th>学号</th>
            <th>课程号</th>
            <th>平时成绩</th>
            <th>期末成绩</th>
            <th>总成绩</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th><input name="student" value="${student.student_id}" readonly="readonly" /></th>
            <th><input name="course" value="${course.course_id}" readonly="readonly"/></th>
            <th><input name="usual" id="usual" type="text" value="${score.usual_score}"></th>
            <th><input name="final" id="final" type="text" value="${score.final_score}"></th>
            <th><input name="total" id="total" type="text" value="${score.total_score}"></th>
        </tr>
        </tbody>
    </table>
    <input id="submit" value="提交" type="submit"/>
</form>
</div>
</body>
</html>
