<%@page import="models.employe"%>
<%@page import="dbconnections.employedb"%>
<%@page import="services.employeservices"%>

<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="bootstrap.jsp" %>
</head>
<body>
<table class="table" border=2px>
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">name</th>
     
      <th scope="col">email</th>
      <th scope="col">password</th>
      <th scope="col">Actions</th>
      
    </tr>
  </thead>
  <tbody>
  <%
employeservices service = new employeservices(employedb.getConnection());
  List <employe> stu = service.fetchall();
  for(employe st : stu){ 
  %>
    <tr>
      <th scope="row"><%=st.getId() %></th>
      <td><%=st.getName() %></td>
  
      <td><%=st.getEmail() %></td>
  <td><%=st.getPassword() %></td>
      <td>
      
      <button class="btn btn-outline-warning">Update</button>
      <a href="delete?id=<%= st.getId() %>">
      <button class="btn btn-outline-danger">Delete</button>
      </a>
      </td>
    </tr>
    <%} %>
    
  </tbody>
</table>
</body>
</html>