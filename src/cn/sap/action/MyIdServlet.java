package cn.sap.action;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.jdbc.JdbcUtils;



/**
 * Servlet implementation class SLDSession
 */

public class MyIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyIdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		String my_id = request.getParameter("my_id");
		

		
		response.setHeader("Content-type","text/html;charset=UTF-8");
		OutputStream stream = response.getOutputStream();
		
		Connection conn = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		 try {
			 conn = JdbcUtils.getConnection();  //获取连接
			 ps1 = conn.prepareStatement("select * from zhucebiao where my_id=?");
			 ps1.setString(1, my_id);
			 rs1 = ps1.executeQuery();
			 
			 if(rs1.next()) { //id且name记录不存在
				 stream.write("1".getBytes("UTF-8"));
			 } else {
				 stream.write("0".getBytes("UTF-8"));
			 }
		     
		 } catch (SQLException e) {
            if(conn!=null)
				try {
					JdbcUtils.releaseConnection(conn);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            e.printStackTrace();;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
