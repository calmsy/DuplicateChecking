<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<ul class="nav nav-pills nav-stacked">
    <li><a href="${pageContext.request.contextPath}/DuplicateChecking/AllPerformance" target="content">查看成绩</a></li>
    <li><a href="${pageContext.request.contextPath}/DuplicateChecking/HomeworkDuplicateCheck" target="content">作业查重</a></li>
    <li><a href="${pageContext.request.contextPath}/upload/upload.jsp" target="content">提交作业</a></li>
</ul>
</body>
</html>