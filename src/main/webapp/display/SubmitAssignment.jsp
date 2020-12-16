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
SubmitAssignment
<br>
<form action="${pageContext.request.contextPath}/DuplicateChecking/upload" method="post">
    选择上传的文件：<input type="file" name="files"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
