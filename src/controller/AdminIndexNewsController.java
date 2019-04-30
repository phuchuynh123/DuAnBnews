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
import model.bean.News;
import model.dao.NewsDao;

/**
 * Servlet implementation class AdminIndexNewsController
 */
//@WebServlet("")
public class AdminIndexNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  NewsDao newsDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndexNewsController() {
        super();
        newsDao= new NewsDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<News> arrnews= newsDao.getitem(); 
		request.setAttribute("listnews",arrnews);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/news/indexNews.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
