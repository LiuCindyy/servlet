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
	
		
		ps = conn.prepareStatement(SQl);

		if (obj != null) {
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
		}

		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		while (rs.next()) {
			Map<String, String> m = new HashMap<String, String>();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
			
				m.put(rsmd.getColumnName(i+1), rs.getString(i+1));
				
			}
			list.add(m);
		}

		return list;

	}
	
	public int exeUpdate (String sql, Object[] obj) throws SQLException {
		Connection conn = this.getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		int rs;
		if (obj!=null) {
			for(int i=0;i<obj.length;i++) {
	//将问号与要查询的列名对应
				ps.setObject(i+1,obj[i]);
			}
		}
		rs=ps.executeUpdate();
		
		System.out.println(rs);
		return rs;
	}

	// �������ݿ�����
	public Connection getConn() {
		Connection conn = null;

		try {
			// 1.�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			// 2.��ȡ���ݿ�����
			conn =  DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "root");
			// �����������
			// Statement st = conn.createStatement();

			// int se =
			// st.executeUpdate("insert into login(name,password) values('niha',12345678)");
			// st.executeUpdate("insert into login(name,password) values('wanger',87654321)");

			// ִ��SQL��� ����

			// ִ��SQL��� ��ѯ
		
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String args[]) throws SQLException {
		DBUtil db = new DBUtil();
		Object[] obj = { "w",12345678 };
		String sql = "Select * from login where username = ? and password = ?";
//		db.exeUpdate(sql, obj);
			
		List<Map<String, String>> resultList =null;
		resultList = db.exeQury(sql, obj);	
		
		for (int i=0; i<resultList.size();i++) {
			
			Map<String,String> map  = new HashMap<String, String>();
			map = resultList.get(i);
				for (String key : map.keySet()) {	
				System.out.println(key);
				System.out.println(map.get(key));
					}
		}
	}
	
}
