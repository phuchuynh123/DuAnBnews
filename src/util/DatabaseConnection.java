package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* https://ngockhuong.com
*/

public class DatabaseConnection {
	private static String db = "bnews";
	private static String url = "jdbc:mysql://localhost:3306/" + db + "?useUnicode=true&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "";
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		try {
			//tìm và nạp driver:(java8 khong cần)
			Class.forName("com.mysql.jdbc.Driver");
			// tạo kết nối giữa java với hệ quản trị csdl
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
