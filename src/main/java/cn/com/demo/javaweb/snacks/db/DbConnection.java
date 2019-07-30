
package cn.com.demo.javaweb.snacks.db;
import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//jdbc驱动程序作用
import java.util.Properties;

public class DbConnection {
	public static void main(String[] args) {
		if (getDbConnection(getDbProperties()) != null) {
			System.out.println("数据库连接成功");
		} else {
			System.out.println("数据库连接失败");
		}

		// if(getDbConnection() != null) {
		// System.out.println("数据库连接成功~");
		// } else {
		// System.out.println("数据库连接失败~"); }
	}

	public static Connection getDbConnection(Properties pro) {
		Connection con = null;
		// getProperty 用指定的键在此属性列表中搜索属性。
		String driver = pro.getProperty("driver");
		String url = pro.getProperty("url");
		String user = pro.getProperty("user");
		String pwd = pro.getProperty("pwd");
		try {
			// 加载Oracle数据库驱动类
			Class.forName(driver);
			try {
				// 通过DriverManager获得Connection的实例
				con = DriverManager.getConnection(url, user, pwd);
			} catch (SQLException e) {
				System.out.println("数据库连接异常" + e.getMessage());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动程序加载异常" + e.getMessage());
		}
		return con;
	}

	public static Connection getDbConnection() {
		// 定义jdbc驱动程序的入口程序名称
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 定义数据库url
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// 127.0.0.1(要连网线)=localhost
		// 定义数据库服务器的登录名及口令
		String user = "system";
		String pwd = "hj123456";
		// 定义保存连接Connection的对象
		Connection con = null;
		// 工厂模式（复习）
		try {
			// driver 返回字符串对应的类的对象
			// 加载驱动程序
			Class.forName(driver);// 创建驱动程序对象并加载到Java应用程序中
			// 通过找到driver类，
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("数据库     驱动程序加载异常" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("数据库建立连接异常" + e.getMessage());
		}
		return con;

	}

	public static Properties getDbProperties() {
		// 创建空值属性列表
		Properties pro = new Properties();
		try {
			// 从输入流中读取属性列表（键和元素对）。
			pro.load(new FileInputStream("config/db.properties"));
		} catch (IOException e) {
			System.out.println("数据库属性文件读取异常" + e.getStackTrace());
		}
		return pro;
	}
}
