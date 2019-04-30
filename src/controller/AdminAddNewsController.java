package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Category;
import model.bean.News;
import model.dao.CategoryDAO;
import model.dao.NewsDao;
import util.FileLibrary;
import util.FileUtil;

/**
 * Servlet implementation class AdminIndexNewsController
 */
@MultipartConfig
public class AdminAddNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  NewsDao newsDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddNewsController() {
        super();
        newsDao= new NewsDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO categoryDAO = new CategoryDAO();
		request.setAttribute("categories", categoryDAO.getItems());
		RequestDispatcher rd = request.getRequestDispatcher("/admin/news/addNews.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     request.setCharacterEncoding("UTF-8");	
		//lay du lieu tu form
		String tentin =request.getParameter("tentin");
		int catID = 0;
		try {
			catID = Integer.parseInt(request.getParameter("danhmuc"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/news/index?err=1");
			return;
		}
		String mota = request.getParameter("mota");
		String chitiet = request.getParameter("chitiet");
		Part part = request.getPart("hinhanh");
		String fileName =FileUtil.getFileName(part);
		//doi ten file
		if(!fileName.isEmpty()){
			String dirPath =request.getServletContext().getRealPath("/files");
			File createDir = new File(dirPath);
			if(!createDir.exists()){
				createDir.mkdirs();//tao file
			}
			String filePath =dirPath+File.separator +fileName;
			part.write(filePath);
			System.out.println("Duong dan file :"+filePath);
		}
		//ngay dang 
		News objnews = new News(0, tentin, mota, chitiet,catID, fileName,"");
		if(newsDao.addnews(objnews)>0){
			//thanh cong
			response.sendRedirect(request.getContextPath()+"/admin/news?msg=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/news?msg=0");
		}
		
		
	}

}

