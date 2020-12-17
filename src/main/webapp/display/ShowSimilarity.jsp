<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/17
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:if test="${flag==0}">
    <center style="font-size: 20px">没有与该文件重复率超过30%的文件</center>
</c:if>
<c:if test="${flag==1}">
    <div style="margin:auto;width: 800px;">
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>文件名</th>
                <th>重复率</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="myFile" items="${myFiles }">
                <tr>
                    <td>${myFile.fileName}</td>
                    <td>${myFile.similarity}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
</body>
</html>
