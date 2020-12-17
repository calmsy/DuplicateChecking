<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/DuplicateChecking/Upload" enctype="multipart/form-data" method="post">
    上传文件：<input type="file" name="file"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
