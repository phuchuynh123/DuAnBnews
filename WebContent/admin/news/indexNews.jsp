<%@page import="model.bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath()%>/admin/news/add" class="button">
			<span>Thêm tin tức <img src="<%=request.getContextPath()%>/templates/admin/images/plus-small.gif" alt="Thêm tin tức"></span>
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
		<h2><span>Danh sách tin</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên</th>
						<th style="width:20%">Danh mục</th>
		                <th style="width:11%; text-align: center;">Hình ảnh</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
				<%
				if(request.getAttribute("listnews")!=null){
				ArrayList<News> arnews = (ArrayList<News>) request.getAttribute("listnews");
				
				if(arnews.size()>0){
				   
						for(News obj:arnews){
					
				
				%>
					<tr>
						<td class="align-center"><%=obj.getId()%></td>
						<td><a href=""><%=obj.getName()%></a></td>
						<td><%=obj.getNamec()%></td>
						<td align="center"><img src="<%=request.getContextPath()%>/files/<%=obj.getPicture()%>" class="hoa" /></td>
						<td align="center">
							<a href="">Sửa<img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="">Xóa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
					</tr>
					<%}}} %>
				</tbody>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 