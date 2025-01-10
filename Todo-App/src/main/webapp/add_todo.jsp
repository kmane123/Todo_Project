<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2">
<%@include file="components/navbar.jsp" %>

<div class="container">
	<div class="row p-5">
		<div class="col-md-6 offset-md-3">
			<div class="card">
				<div class="card-body">
				<h3 class="text-center text-success">Add Todo</h3>
					<form action="add_todo" method="post">
						<div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">Name</label>
					    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
					    <div id="emailHelp" class="form-text"></div>
					  </div>
					  <div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label">TODO</label>
					    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="todo">
					    <div id="emailHelp" class="form-text"></div>
					  </div>
					  <div class="mb-3">
					    <label for="exampleInputPassword1" class="form-label">Status</label>
					    <select class="form-select" aria-label="Default select example" name="status">
						  <option selected>--Select--</option>
						  <option value="Pending">Pending</option>
						  <option value="Complet">Complet</option>
						</select>
					  </div>
					  <div class="text-center">
					  	<button type="submit" class="btn btn-primary">Add</button>
					  </div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>