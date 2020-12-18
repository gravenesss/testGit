<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>

success<br>

${requestScope.time}<br>


${requestScope.names}<br>


request user: ${requestScope.user }<br><br>
session user: ${sessionScope.user }<br><br>
</body>
</html>