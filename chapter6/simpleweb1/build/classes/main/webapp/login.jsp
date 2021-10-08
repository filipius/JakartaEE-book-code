<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong>Hi there!</strong>
	<div>Greetings from your JSP page!</div>

	<form action="main" method="get">
		<input name="nome" type="text" placeholder="username..." />
		<input name="chave" type="password" placeholder="password..." />
		<input type="submit">
	</form>

</body>
</html>