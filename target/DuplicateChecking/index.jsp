<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<frameset rows="10%,90%" noresize>
    <frame src="display/top.jsp">
    <frameset cols="10%,90%" noresize>
        <frame src="display/left.jsp">
        <frame name="content" src="display/right.jsp">
    </frameset>
</frameset>
</html>