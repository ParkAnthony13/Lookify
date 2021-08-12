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
			<div class="container navbar">
				<div class="navbar-left">
					<a href="/songs/new" class="btn btn-warning">Add New</a>
					<a href="/search/topTen" class="btn btn-primary">Top Songs</a>
				</div>
				<div class="navbar-right">
					<form action="/search" method="post">
						<input type="text" name="writer"/>
						<button>Search Artists</button>
					</form>
				</div>
			</div>
			<h1>All Songs</h1>
			<table class="table">
			    <thead>
			        <tr>
			            <th>Song Title</th>
			            <th>Artist</th>
			            <th>Action</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${songs}" var="song">
			        <tr>
			            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
			            <td><c:out value="${song.rating}"/></td>
			            <td>
			            	<form action="/songs/${song.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
							</form>
			            </td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>