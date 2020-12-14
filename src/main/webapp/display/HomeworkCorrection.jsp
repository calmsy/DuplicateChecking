<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/14
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<table class="table table-bordered table-hover">
    <caption>批改作业</caption>
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>语文</th>
        <th>数学</th>
        <th>英语</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${Students }">
        <tr>
            <td>${student.task_name }</td>
            <td>${student.name }</td>
            <td>${student.task_begin_time }</td>
            <td>${student.task_end_time }</td>
            <td>${student.yingyu }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
