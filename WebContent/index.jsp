<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>




<form action="springmvc/testModelAttribute" method="Post">
    <input type="hidden" name="id" value="1"/>
    username: <input type="text" name="username" value="Tom"/><br>
    email: <input type="text" name="email" value="tom@atguigu.com"/><br>
    age: <input type="text" name="age" value="12"/>  <br>
    <input type="submit" value="Submit"/>
</form><br><br> 


<a href="springmvc/testSessionAttributes">SessionAttributes</a><br><br> 

<a href="springmvc/testMap">Test Map</a>  <br><br>
<a href="springmvc/testModelAndView">Test ModelAndView</a><br><br>
<a href="springmvc/testServletAPI">Test ServletAPI</a><br><br>

<form action="springmvc/testPojo" method="post">
	用户名：<input type="text" name="username"><br>
	密    码：<input type="password" name="password"><br>
	邮    箱：<input type="email" name="email"><br>
	省：<input  type="text" name="address.province"><br>
	市：<input type="text" name="address.city"><br>
	<input type="submit" value="Submit"><br>
</form>


<br><br>
<a href="springmvc/testRequestParam?username=lisi">Test RequestParam</a>


<br><br>
<a href = "${pageContext.request.contextPath}/springmvc/hello">hello</a>
<br>
</body>
</html>