<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements --> 
<%
 String err=request.getParameter("err");
if("1".equals(err)){
	out.print("<div style='text-align: center; font-weight: bold; color: red; background: yellow'>Thêm danh mục thành công!</div>");
}
String name =request.getParameter("name");
if(name==null){
	name="";
}
%>   
<div class="grid_12">

	<div class="module">
		 <h2><span>Thêm danh mục</span></h2>
			
		 <div class="module-body">
			<form action="<%=request.getContextPath()%>/admin/cats/add" method="post">
				<p>
					<label>Tên danh mục</label>
					<input type="text" name="name" value="<%=name %>" class="input-medium" />
				</p>
				
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="Thêm" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập Mới" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 