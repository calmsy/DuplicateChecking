<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            alert("welcome");
        });
    </script>
</head>
<frameset rows="10%,90%" noresize>
    <frame src="top.jsp">
    <frameset cols="10%,90%" noresize>
        <frame src="display/left.jsp">
        <frame name="content" src="right.jsp">
    </frameset>
</frameset>
</html>