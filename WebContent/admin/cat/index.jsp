<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/admin/cats/add" title="" class="button">
			<span>Thêm tin <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>
<%
 String msg=request.getParameter("msg");
if("1".equals(msg)){
	out.print("<div style='text-align: center; font-weight: bold; color: red; background: yellow'>Thêm danh mục thành công!</div>");
}
if("2".equals(msg)){
	out.print("<div style='text-align: center; font-weight: bold; color: red; background: yellow'>sửa danh mục thành công!</div>");
}
if("3".equals(msg)){
	out.print("<div style='text-align: center; font-weight: bold; color: red; background: yellow'>xóa danh mục thành công!</div>");
}
if("4".equals(msg)){
	out.print("<div style='text-align: center; font-weight: bold; color: red; background: yellow'>xóa thất bại!</div>");
}
%>
<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách danh muc</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên Danh Muc</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
				<%
					ArrayList<Category> categories=(ArrayList<Category>) request.getAttribute("categories");
					if(categories!=null && categories.size()>0){
						for(Category item:categories){
							
						
					
				
				%>
					<tr>
					
						<td class="align-center"><%=item.getId() %></td>
						<td><a href=""><%=item.getName() %></a></td>
						<td align="center">
							<a href="<%=request.getContextPath() %>/admin/cats/edit?id=<%=item.getId() %>" title="">Sua <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath() %>/admin/cats/delete?id=<%=item.getId()%>" title="">Xoa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
					</tr>
					<%}}else{ %>
					
				   
				</tbody>
				<%} %>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			<div class="numbers">
				<span>Trang:</span> 
				<a href="">1</a> 
				<span>|</span> 
				<a href="">2</a> 
				<span>|</span> 
				<span class="current">3</span> 
				<span>|</span> 
				<a href="">4</a> 
				<span>|</span> 
				<a href="">5</a> 
				<span>|</span> 
				<a href="">6</a> 
				<span>|</span> 
				<a href="">7</a>
				<span>|</span> 
				<a href="">8</a> 
				<span>|</span> 
				<a href="">9</a>
				<span>|</span> 
				<a href="">10</a>   
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 