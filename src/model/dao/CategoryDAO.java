package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import util.DatabaseConnection;

public class CategoryDAO {
	private Statement st;//gá»�i cÃ¢u truy váº¥n tá»›i csdl
	
	
	private Connection conn;//káº¿t ná»‘i csdl
	private ResultSet rs;//tráº£ vá»� 1 káº¿t quáº£ 
	private PreparedStatement pst;

	public ArrayList<Category> getItems() {
		ArrayList<Category> items = new ArrayList<>();

		String sql = "SELECT id,name FROM categories ORDER BY id DESC";
		try {
			conn = DatabaseConnection.getConnection();
			st = conn.createStatement();//gá»Ÿi cÃ¢u truy váº¥n trÃªn lÃªn cÆ¡ sá»Ÿ dá»¯ liá»‡u
			rs = st.executeQuery(sql);//tráº£ vá»� 1 káº¿t quáº£ cáº§n 1 truy catch
			while (rs.next()) {
				Category item = new Category(rs.getInt("id"), rs.getString("name"));

				items.add(item);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return items;

	}

	public int addItem(Category item) {
		int result = 0;
		String sql = "INSERT INTO categories(name) VALUES(?)";
		try {
			conn = DatabaseConnection.getConnection();//ket noi csdl
			pst = conn.prepareStatement(sql);//thuc thi cau lenh
			pst.setString(1, item.getName());//gan gia tri cho dau cham há»�i
			result = pst.executeUpdate();//so dong

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Category getItem(int id) {
		Category item = new Category();
		
		String sql = "SELECT id,name FROM categories WHERE id=?";
		//String sql="SELECT id,name FROM categories WHERE id="+id;
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
			 item = new Category(id,name);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return item;
	}

	public int editItem(Category item) {
	     String sql="UPDATE categories SET name=? WHERE id=?";
	     int result=0;
	     try {
	    conn= DatabaseConnection.getConnection();
	    pst=conn.prepareStatement(sql);
		pst.setString(1, item.getName());
		pst.setInt(2, item.getId());
		result= pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	     
		return result;
	}

	public int delItem(int id) {
		 String sql="DELETE FROM categories WHERE id=?";
		  int result=0;
		  conn= DatabaseConnection.getConnection();
		  try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		  
		  return result;
			
		}


	
}
