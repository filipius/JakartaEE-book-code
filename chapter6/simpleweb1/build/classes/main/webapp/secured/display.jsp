<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong>Upload your code!</strong>

	
	<form method="post" action="upload" enctype="multipart/form-data">
    	Choose a file: <input type="file" name="multiPartServlet" />
    	<input type="submit" value="Upload" />
	</form>

	<div></div>
	
	<strong>Latest result is...</strong>
	
	<div>${task.inicio}</div>
	<div>${task.entrada}</div>
	<div>${task.fim}</div>
	<div>${task.saida}</div>
	
	
</body>
</html>