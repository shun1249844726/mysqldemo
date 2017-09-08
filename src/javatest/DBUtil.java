package javatest;
import java.sql.*;
public class DBUtil {
	 
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/imooc?characterEncoding=utf8&useSSL=true";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";
 
   private static Connection conn = null;
   private static Statement stmt = null;
    static {
        try {
     	   // 注册 JDBC 驱动
			Class.forName("com.mysql.jdbc.Driver");
	        // 打开链接
	        System.out.println("连接数据库...");
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static Connection getConnection(){
    		return conn;
    };
}