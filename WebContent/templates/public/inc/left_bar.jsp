<%@page import="model.dao.CategoryDAO"%>
<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>Danh mục tin</h2>
<ul>
    <%
     CategoryDAO categoryDAO = new CategoryDAO();
     for(Category objcat:categoryDAO.getItems()){
    	 
     
    %>
	<li><a href="<%=request.getContextPath()%>/cats?cid=<%=objcat.getId()%>"><%=objcat.getName() %></a></li>
	<%} %>
</ul>
