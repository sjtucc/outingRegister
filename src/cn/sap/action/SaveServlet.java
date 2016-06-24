package cn.sap.action;

import java.io.IOException;
import java.io.OutputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.jdbc.JdbcUtils;

public class SaveServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public SaveServlet() {
	        super();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		response.setContentType("text;html;charset=utf-8");
		String my_id = request.getParameter("my_id").trim();
		System.out.println(my_id);
		String psd_r = request.getParameter("psd_r").trim();

		response.setHeader("Content-type","text/html;charset=UTF-8");
		OutputStream stream = response.getOutputStream();
		
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=df.format(date);
		
		Connection conn = null;
		PreparedStatement ps1 = null;
		 try {
			 conn = JdbcUtils.getConnection();  //»ñÈ¡Á¬½Ó
			 conn.setAutoCommit(false);
			 ps1 = conn.prepareStatement("insert into zhucebiao values(?,?,?)");
			 ps1.setString(1,my_id);
			 ps1.setString(2,psd_r);
			 ps1.setString(3,time);
			 ps1.executeUpdate();
			 conn.commit();   
			 
			 
			
			stream.write("0".getBytes("UTF-8"));  //没用，走个形式
			 
		 } catch(SQLException e) {
			 if(conn != null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
             e.printStackTrace();
	      } finally {
	     	 try {
				JdbcUtils.releaseConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	      }
 }
  

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}



}
