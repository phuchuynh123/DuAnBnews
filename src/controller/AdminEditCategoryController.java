package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;


//@WebServlet("/AdminIndexController")
public class AdminEditCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
       
    
    public AdminEditCategoryController() {
        super();
       categoryDAO = new CategoryDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=0;
		try{
		id=Integer.parseInt(request.getParameter("id"));
		}catch(NumberFormatException e){
			response.sendRedirect(request.getContextPath()+"/admin/cats?err=1");
			return;
		}
		Category item = categoryDAO.getItem(id);
		if(item == null){
			response.sendRedirect(request.getContextPath()+"/admin/cats");
			return;
		}
		request.setAttribute("category", item);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/cat/edit.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//lay du lieu  tu form
		int id= Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		//jvalidate:front-end
		//validate du lieu :servlet
		if("".equals(name)){
			response.sendRedirect(request.getContextPath()+"/admin/cats");
			return;
		}
		Category item = new Category(id,name);
		if(categoryDAO.editItem(item)>0){
			//thanhcong
			response.sendRedirect(request.getContextPath()+"/admin/cats?msg=2");
			
			return;
		}else{
			//thatbai
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/edit.jsp");
		}
	}

}
