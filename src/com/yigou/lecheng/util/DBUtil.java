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
	 * ���ݿ������ļ�
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
		//����ط��ղ��㵼��İ��������java.sql.PreparedStatement ������������ �㵼��Ĳ������ ���Բ��� ���� 
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
				//����ط�д�������⣬���nameӦ��������
				m.put(rsmd.getColumnName(i), rs.getString(i));
				
			}
			list.add(m);
		}

		return list;

	}

	// �������ݿ�����
	public Connection getConn() {
		Connection conn = null;

		try {
			// 1.�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			// 2.��ȡ���ݿ�����
			conn =  DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "");
			// �����������
			// Statement st = conn.createStatement();

			// int se =
			// st.executeUpdate("insert into login(name,password) values('niha',12345678)");
			// st.executeUpdate("insert into login(name,password) values('wanger',87654321)");

			// ִ��SQL��� ����

			// ִ��SQL��� ��ѯ
			// ResultSet
			// flag=st.executeQuery("select * from stu where name=zhangsan");

		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			System.out.println("��������ʧ��");
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
