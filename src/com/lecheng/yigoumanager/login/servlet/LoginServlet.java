package com.lecheng.yigoumanager.login.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yigou.lecheng.util.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 *处理请求 @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获得页面的用户名
		String loginname = req.getParameter("userName");

		System.out.println("b");

		String SQl = "select * from login where username = ? and password = ?";
		List list = new ArrayList();
		//获得页面提交的密码
		String password=req.getParameter("pwd");
		Object[] obj ={loginname,password};
		DBUtil db = new DBUtil();
		req.setCharacterEncoding("utf-8");
		try {
			list = db.exeQury(SQl, obj);
			if(list==null || list.size()==1) {
				response.sendRedirect("footer.html");
			}else {
				response.sendRedirect("login.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		DBUtil db = new DBUtil;
//		String sql="select* from tuser where loginname=? and password=?";
	}

}
