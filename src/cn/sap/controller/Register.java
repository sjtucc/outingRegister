package cn.sap.controller;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.jdbc.JdbcUtils;



@Controller
public class Register {
	@Autowired       //Spring mvc通过IOC中获取request
	HttpServletRequest request;
	
	@RequestMapping("/register1.action")
	public ModelAndView queryItem() throws SQLException {
		String u = (String)request.getParameter("user");
		String p = (String)request.getParameter("password");
		if(u!=null && !u.equals(""))
			u = u.trim();
		if(p!=null && !p.equals(""))
			p = p.trim();
		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();
		
		//这里要链接数据库看用户名密码是否正确
		 Connection conn = null;
		 PreparedStatement ps1 = null;
		 PreparedStatement ps2 = null;
		 ResultSet rs1 = null;
		 ResultSet rs2 = null;
		 try {
			 conn = JdbcUtils.getConnection();  //»ñÈ¡Á¬½Ó
			
			 ps1 = conn.prepareStatement("select * from zhucebiao where my_id=? and password=?");
			 ps1.setString(1, u);
			 ps1.setString(2, p);
			 rs1 = ps1.executeQuery();
			 if(rs1.next()) { //id´æÔÚ,name²»ÓÃ¹Ü£¬ÓÐÖØÃû
				 modelAndView.setViewName("outing.jsp");
				 request.getSession().setAttribute("id", u);
				 
				 //获取各个数据填充到jsp中
				 ps2 = conn.prepareStatement("select * from information where my_id=?");
			
				 ps2.setString(1, u);
				 rs2 = ps2.executeQuery();
				 
				 while(rs2.next()) {
					 request.setAttribute("my_name", rs2.getString("my_name"));
					 request.setAttribute("cellphone", rs2.getString("cellphone"));
					 request.setAttribute("my_card", rs2.getString("my_card"));
					 request.setAttribute("partner_name", rs2.getString("partner_name"));
					 request.setAttribute("partner_card", rs2.getString("partner_card"));
					 request.setAttribute("kid_name", rs2.getString("kid_name"));
					 request.setAttribute("kid_card", rs2.getString("kid_card"));
					 request.setAttribute("room_type", rs2.getString("room_type"));
					 request.setAttribute("room_mate", rs2.getString("room_mate"));
				 }
			 } else{
				 modelAndView.setViewName("forward:index.jsp");
			} 
		// 填充数据
		//modelAndView.addObject("itemsList", itemsList);
		// 视图
		//modelAndView.setViewName("outing.jsp");

		return modelAndView;
	} catch(SQLException e) {
        e.printStackTrace();;
     } finally {
    	 JdbcUtils.releaseConnection(conn);
     }
		 return modelAndView;
	}
}
