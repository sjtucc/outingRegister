package cn.sap.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.jdbc.JdbcUtils;

public class InfoService {
	public static List<InfoEntity> getAllByDb(){
        List<InfoEntity> list=new ArrayList<InfoEntity>();
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
        try {
        	 conn = JdbcUtils.getConnection();
        	 ps = conn.prepareStatement("select * from information");
			 rs = ps.executeQuery();
           
            while (rs.next()) {
            	  String my_id = rs.getString("my_id");
	           	  String my_name = rs.getString("my_name");
	              String cellphone = rs.getString("cellphone");
	           	  String my_card = rs.getString("my_card");
	           	  String partner_name = rs.getString("partner_name");
	           	  String partner_card = rs.getString("partner_card");
	           	  String kid_name = rs.getString("kid_name");
	           	  String kid_card = rs.getString("kid_card");
	           	  String room_type = rs.getString("room_type");
	           	  String room_mate = rs.getString("room_mate");
	           	  String time = rs.getString("time");
	          
                  list.add(new InfoEntity(my_id, my_name, cellphone, my_card, partner_name, partner_card, kid_name, kid_card, room_type, room_mate, time));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
	
	 
}
