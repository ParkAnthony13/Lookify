<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<h1>New Song</h1>
			<form:form action="/songs/new" method="post" modelAttribute="song">
			    <p>
			        <form:label path="title">Title</form:label>
			        <form:errors path="title" style="color:red;"/>
			        <form:input path="title" type="text"/>
			    </p>
			    <p>
			        <form:label path="artist">Artist</form:label>
			        <form:errors path="artist" style="color:red;"/>
			        <form:textarea path="artist"/>
			    </p>
			    <p>
			        <form:label path="rating">Rating</form:label>
			        <form:errors path="rating" style="color:red;"/>
			        <form:input path="rating" type="number"/>
			    </p>
			    <input type="submit" value="Submit"/>
			</form:form> 
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>