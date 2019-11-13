<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	회원가입 완료  
</h1>
Email : ${member.getEmail} <br />
PW : ${member.getPwd} <br />
User : ${member.getUsername} <br />
Cell : ${member.getCell1} - ${member.getCell2} - ${member.getCell3} <br />
<a href="/blog/resoures/html/index.html">홈</a>
</body>
</html>
