<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home</h1>
	<form action="/blog/homeOk" method="post">
		<input type="radio" name="gender" value="male">Male
		<input type="radio" name="gender" value="female">Female
		<br />
		<input type="checkbox" name="isCookieDel" value="true"> 쿠키 삭제 
		<br />
		<input type="submit" value="OK">
	</form>
</body>
</html>