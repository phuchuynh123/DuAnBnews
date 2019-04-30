package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

import model.bean.News;
import util.DatabaseConnection;

public class NewsDao {
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	public ArrayList<News> getitem() {
		ArrayList<News> ar = new ArrayList<>();
		String sql="SELECT *,c.name AS namec,n.name AS namen FROM news AS n INNER JOIN categories AS c ON n.cat_id=c.id ORDER BY n.id DESC";
		conn = DatabaseConnection.getConnection();
		try {
			st =conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				News obj = new News(rs.getInt("id"), rs.getString("namen"), rs.getString("preview_text"), rs.getString("detail_text"), rs.getInt("cat_id"), rs.getString("picture"), rs.getString("namec"));
				ar.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		
		
		return ar;
	}
	public int addnews(News objnews) {
		 int result=0;
		 String sql="INSERT INTO news(name,preview_text,detail_text,cat_id,picture) VALUES (?,?,?,?,?)";
		 conn=DatabaseConnection.getConnection();
		 try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, objnews.getName());
			pst.setString(2, objnews.getPreview());
			pst.setString(3, objnews.getDetail());
			pst.setInt(4, objnews.getCatid());
			pst.setString(5, objnews.getPicture());
			result=pst.executeUpdate();
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
}
//String sql = "SELECT news.id AS nid, news.name AS nname, preview_text, detail_text, created_at, picture, categories.id AS cid, categories.name AS cname FROM news"
//+ " INNER JOIN categories ON news.cat_id = categories.id ORDER BY nid DESC";