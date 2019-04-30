package controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;


//@WebServlet("/AdminIndexCategoryController")
public class AdminIndexCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private CategoryDAO categorydao; 
    
    public AdminIndexCategoryController() {
        super();
    categorydao=new CategoryDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Category> categories=categorydao.getItems();
		request.setAttribute("categories",categories );
		RequestDispatcher rd=request.getRequestDispatcher("/admin/cat/index.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
