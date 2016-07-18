package com.yigou.lecheng.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
	private static final String SQL = null;

	/**
	 * 数据库连接文件
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public List<Map<String, String>> exeQury(String SQl, Object[] obj)
			throws SQLException {

		Connection conn;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		conn = this.getConn();
		//这个地方刚才你导入的包导入错了java.sql.PreparedStatement 是这个包下面的 你导入的不是这个 所以不行 好了 
		ps = conn.prepareStatement(SQl);

		if (obj != null) {
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
		}

		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		while (rs.next()) {
			Map<String, String> m = new HashMap<>();
			for (int i = 1; i < rsmd.getColumnCount(); i++) {
				//这个地方写的有问题，这个name应该是张三
				m.put(rsmd.getColumnName(i), rs.getString(i));
				
			}
			list.add(m);
		}

		return list;

	}

	// 导入数据库驱动
	public Connection getConn() {
		Connection conn = null;

		try {
			// 1.导入数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获取数据库连接
			conn =  DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "");
			// 创建处理对象
			// Statement st = conn.createStatement();

			// int se =
			// st.executeUpdate("insert into login(name,password) values('niha',12345678)");
			// st.executeUpdate("insert into login(name,password) values('wanger',87654321)");

			// 执行SQL语句 插入

			// 执行SQL语句 查询
			// ResultSet
			// flag=st.executeQuery("select * from stu where name=zhangsan");

		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
		return conn;
	}

//	public static void main(String args[]) throws SQLException {
//		DBUtil db = new DBUtil();

//		Object[] obj = { ,111111 };
//		String sql = "select * from login where username = ? and password = ?";
//		List<Map<String, String>> resultList = db.exeQury(sql, obj);
//		for (Map<String, String> map : resultList) {
//			for (String key : map.keySet()) {
				
//				System.out.println(map.get(key));
//			}
//	}
//	}
}
