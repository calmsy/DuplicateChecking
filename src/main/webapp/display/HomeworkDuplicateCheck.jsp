<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/14
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div style="margin:auto;width: 1000px;">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>文件</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="file" items="${files}">
            <tr>
                <td>${file.name}</td>
                <td><a href="${pageContext.request.contextPath}/DuplicateChecking/toDuplicateCheck?fileName=${file.name}">查询</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
