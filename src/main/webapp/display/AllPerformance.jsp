<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/14
  Time: 18:33
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
    <caption>班级成绩</caption>
    <thead>
    <tr>
        <th>班级</th>
        <th>总成绩</th>
        <th>平均成绩</th>
        <th>人数</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="oneClass" items="${AllClass }">
        <tr>
            <td>${oneClass.task_name }</td>
            <td>${oneClass.name }</td>
            <td>${oneClass.task_begin_time }</td>
            <td>${oneClass.task_end_time }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
