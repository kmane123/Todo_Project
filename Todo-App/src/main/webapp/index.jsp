<%@page import="com.DAO.TodoDAO"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>
<%@page import="com.entity.TodoDtls"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/all_css.jsp" %>
</head>
<body>
<%@include file="components/navbar.jsp" %>

<%
	String sucMSG=(String)session.getAttribute("sucMSG");
	if(sucMSG!=null){
		%>
		<div class="alert alert-success" role="alert"><%= sucMSG %></div>
		<%
		session.removeAttribute("sucMSG");
	}
%>

<%
	String failedMSG=(String)session.getAttribute("failedMSG");
	if(failedMSG!=null){
		%>
		<div class="alert alert-danger" role="alert"><%= failedMSG %></div>
		<%
		session.removeAttribute("failedMSG");
	}
%>

<h1 class="text-center text-success p-5">TODO-App</h1>

<div class="container">
	
	<table class="table table-striped" border="1px">
	  <thead class="bg-success text-white">
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Name</th>
	      <th scope="col">Todo</th>
	      <th scope="col">Status</th>
	      <th scope="col">Action</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  <%
	  	TodoDAO dao=new TodoDAO(DBConnection.getConnect());
	  	List<TodoDtls> todo=dao.getTodo();
	  	for(TodoDtls t:todo)
	  	{
	  %>
	    <tr>
	      <td scope="row"><%= t.getId() %></td>
	      <td><%= t.getName() %></td>
	      <td><%= t.getTodo() %></td>
	      <td><%= t.getStatus() %></td>
	      <td>
	      	<a href="edit.jsp?id=<%= t.getId() %>" class="btn btn-sm btn-success">Edit</a>
	      	<a href="delete?id=<%= t.getId() %>" class="btn btn-sm btn-danger">Delete</a>
	      </td>
	    </tr>
	   <%
	   }
	   %>
	   
	  </tbody>
</table>

</div>
</body>
</html>