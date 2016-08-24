<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	REMOVE UID
</h1>

<form role="form" method="post">

	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">uid</label>
			<input type="text" name='uid' class="form-contorl">
		</div>

	<div class="box-footer">
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</form>
</body>
</html>
