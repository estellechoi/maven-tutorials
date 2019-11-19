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
	회원가입 완료 ___ ${result}
</h1>
Email : ${m.email} <br />
PW : ${m.pwd} <br />
User : ${m.username} <br />
<%-- Sports : ${m.sports} <br /> --%>
${serverTime} <br />
<a href="/blog/resoures/html/indexJdbc.html">홈</a>
</body>
</html>
