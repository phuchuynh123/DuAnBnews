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
public class AdminAddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;
       
    
    public AdminAddCategoryController() {
        super();
       categoryDAO = new CategoryDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/admin/cat/add.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//lay du lieu  tu form
		String name = request.getParameter("name");
		//jvalidate:front-end
		//validate du lieu :servlet
		if("".equals(name)){
			response.sendRedirect(request.getContextPath()+"/admin/cats");
			return;
		}
		Category item = new Category(0,name);
		if(categoryDAO.addItem(item)>0){
			//thanhcong
			response.sendRedirect(request.getContextPath()+"/admin/cats?msg=1");
			return;
		}else{
			//thatbai
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/add.jsp");
		}
	}

}
