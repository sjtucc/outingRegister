package cn.sap.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.jdbc.JdbcUtils;



//使用@Controller来标识该类为控制器
@Controller
public class Service {
	//@Autowired       //Spring mvc通过IOC中获取request
	HttpServletRequest request;
	HttpServletResponse response; 
	 @ModelAttribute  
     public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
         this.request = request;  
         this.response = response;  
          
     }  
	
	@RequestMapping("/deal.action")
	public ModelAndView queryItem() throws UnsupportedEncodingException, SQLException {
		//request.setCharacterEncoding("GBK");

		String my_id = (String)request.getSession().getAttribute("id");
		String cellphone = (String)request.getParameter("cellphone").trim();
		String my_card = (String)request.getParameter("my_card").trim();
		//String my_name = request.getParameter("my_name");
		my_id = my_id.trim();
		String my_name = new String(request.getParameter("my_name").getBytes("iso-8859-1"),"UTF-8");
	
		System.out.println(my_name);
		
		//下面不一定有，容易空指针异常
		String partner_name = new String(request.getParameter("partner_name").getBytes("iso-8859-1"),"UTF-8");
		//String partner_name = (String)request.getParameter("partner_name");
		String partner_card = (String)request.getParameter("partner_card");
		String kid_name = new String(request.getParameter("kid_name").getBytes("iso-8859-1"),"UTF-8");
		//String kid_name = (String)request.getParameter("kid_name");
		String kid_card = (String)request.getParameter("kid_card");
		
		String room_type = (String)request.getParameter("room_type");
		String room_mate = new String(request.getParameter("room_mate").getBytes("iso-8859-1"),"UTF-8");
		//String room_mate = (String)request.getParameter("room_mate");
		//System.out.println(partner_name);
		
		
		
		
		
		
		//存数据库
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=df.format(date);
		
		 Connection conn = null;
		 PreparedStatement ps1 = null;
		 ResultSet rs1 = null;
		 
		 PreparedStatement ps2 = null;   //if it exists
		 ResultSet rs2 = null;
		 
		 
		 try {
			 conn = JdbcUtils.getConnection();
			 
			 ps2 = conn.prepareStatement("select * from information where my_id=?");
			 ps2.setString(1, my_id);
			 rs2 = ps2.executeQuery();
			 if(rs2.next()) {     ////if it exists,delete!
				 ps2 = conn.prepareStatement("delete from information where my_id=?");
				 ps2.setString(1, my_id);
				 ps2.executeUpdate();
				 
			 }
			 
			 
			 
			 conn.setAutoCommit(false);  //´ò¿ªÊÂÎñ
			 ps1 = conn.prepareStatement("insert into information values(?,?,?,?,?,?,?,?,?,?,?)");
			 ps1.setString(1, my_id);
			 ps1.setString(2, my_name);
			 ps1.setString(3, cellphone);
			 ps1.setString(4, my_card);
			 ps1.setString(5, partner_name);
			 ps1.setString(6, partner_card);
			 ps1.setString(7, kid_name);
			 ps1.setString(8, kid_card);
			 ps1.setString(9, room_type);
			 ps1.setString(10, room_mate);
			 ps1.setString(11, time);
			
 
			 ps1.executeUpdate();
			 conn.commit();  
			
		 } catch(SQLException e) {
                e.printStackTrace();;
         } finally {
        	 JdbcUtils.releaseConnection(conn);
         }
		
		
		

		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		//modelAndView.addObject("itemsList", itemsList);
		// 视图
		modelAndView.setViewName("/WEB-INF/jsps/success.html");

		return modelAndView;
	}
	
	
	
	@RequestMapping("/giveUp.action")
	public ModelAndView giveUp() throws UnsupportedEncodingException, SQLException {
		 String my_id = (String)request.getSession().getAttribute("id");
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			 conn = JdbcUtils.getConnection();
			 
			 conn.setAutoCommit(false); 
			 ps = conn.prepareStatement("delete from information where my_id=?");
			 ps.setString(1, my_id);
			 ps.executeUpdate();
			 conn.commit();  
			
		 } catch(SQLException e) {
                e.printStackTrace();;
         } finally {
        	 JdbcUtils.releaseConnection(conn);
         }
		
		
		

		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		//modelAndView.addObject("itemsList", itemsList);
		// 视图
		modelAndView.setViewName("/WEB-INF/jsps/success.html");

		return modelAndView;
	}
	
	
	
	
	
	
	@RequestMapping("/delete.action")
	public ModelAndView deleteItem() throws UnsupportedEncodingException, SQLException {
		
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			 conn = JdbcUtils.getConnection();
			 
			 conn.setAutoCommit(false); 
			 ps = conn.prepareStatement("delete from information where 1=1");
			
			 ps.executeUpdate();
			 conn.commit();  
			
		 } catch(SQLException e) {
                e.printStackTrace();;
         } finally {
        	 JdbcUtils.releaseConnection(conn);
         }
		
		
		

		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		//modelAndView.addObject("itemsList", itemsList);
		// 视图
		modelAndView.setViewName("/WEB-INF/jsps/admin.jsp");

		return modelAndView;
	}
	
	
	@RequestMapping("/houTai.action")
	public ModelAndView goHouTai() throws UnsupportedEncodingException, SQLException {

		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();


		modelAndView.setViewName("/WEB-INF/jsps/admin.jsp");

		return modelAndView;
	}
	
	@RequestMapping("/export.action")
	public ModelAndView export() throws UnsupportedEncodingException, SQLException {
		 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////       
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=df.format(date);
/*
		try {
			
				WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
               String fileName = "c:/tmp/register"+"_"+time+".xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               List<InfoEntity> list= InfoService.getAllByDb();
               
 
               //要插入到的Excel表格的行号，默认从0开始
               Label labelId= new Label(0, 0, "my_id");
               Label labelName= new Label(1, 0, "my_name");
               Label cellphone= new Label(2, 0, "cellphone");
               Label labelCard= new Label(3, 0, "my_card");
               Label labelName2= new Label(4, 0, "partner_name");
               Label labelCard2= new Label(5, 0, "partner_card");
               Label labelName3= new Label(6, 0, "kid_name");
               Label labelCard3= new Label(7, 0, "kid_card");
               Label labelType= new Label(8, 0, "room_type");
               Label labelMate= new Label(9, 0, "room_mate");
               Label labelTime= new Label(10, 0, "time");
               
               ws.addCell(labelId);
               ws.addCell(labelName);
               ws.addCell(cellphone);
               ws.addCell(labelCard);
               ws.addCell(labelName2);
               ws.addCell(labelCard2);
               ws.addCell(labelName3);
               ws.addCell(labelCard3);
               ws.addCell(labelType);
               ws.addCell(labelMate);
               ws.addCell(labelTime);
               
               for (int i = 0; i < list.size(); i++) {
            	   
                   Label label0= new Label(0, i+1, list.get(i).getMy_id());
                   Label label1= new Label(1, i+1, list.get(i).getMy_name());
                   Label label2= new Label(2, i+1, list.get(i).getCellphone());
                   Label label3= new Label(3, i+1, list.get(i).getMy_card());
                   Label label4= new Label(4, i+1, list.get(i).getPartner_name());
                   Label label5= new Label(5, i+1, list.get(i).getPartner_card());
                   Label label6= new Label(6, i+1, list.get(i).getKid_name());
                   Label label7= new Label(7, i+1, list.get(i).getKid_card());
                   Label label8= new Label(8, i+1, list.get(i).getRoom_type());
                   Label label9= new Label(9, i+1, list.get(i).getRoom_mate());
                   Label label10= new Label(10, i+1, list.get(i).getTime());
                   
                   ws.addCell(label0);
                   ws.addCell(label1);
                   ws.addCell(label2);
                   ws.addCell(label3);
                   ws.addCell(label4);
                   ws.addCell(label5);
                   ws.addCell(label6);
                   ws.addCell(label7);
                   ws.addCell(label8);
                   ws.addCell(label9);
                   ws.addCell(label10);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
               
               */
               
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
               
               
             /*  
               String urlPath = fileName;   
               String filePath = "c:/outing"; 
               URL url = new File(urlPath).toURL();
              // URL url = new URL(urlPath);   
                 try {   
                     downloadFile(url,filePath,time);   
                  } catch (IOException e) {   
                   e.printStackTrace();   
                }  */
               
               
               
               
               
               
            Connection conn = null;
       		PreparedStatement ps = null;
       		String time_tmp = null;
	         conn = JdbcUtils.getConnection();
			 ps = conn.prepareStatement("select * from information into outfile ? CHARACTER SET gbk");
			 time_tmp = "c:/tmp/register"+"_"+time+".xls";                                      //注意：服务器必须有tmp文件夹
			 ps.setString(1, time_tmp);
			 ps.executeQuery(); 
	         try {
				downLoad(time_tmp, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
               
               
       
               
               
               
               
     /*              
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
		*/
		// 创建modelAndView准备填充数据、设置视图
				ModelAndView modelAndView = new ModelAndView();


				modelAndView.setViewName("/WEB-INF/jsps/admin.jsp");

			return modelAndView;
    }

/*	 public static void downloadFile(URL theURL, String filePath, String time) throws IOException {  
	     File dirFile = new File(filePath);
	        if(!dirFile.exists()){//文件路径不存在时，自动创建目录
	          dirFile.mkdir();
	     }
	   //从服务器上获取图片并保存
	      URLConnection  connection = theURL.openConnection();
	      InputStream in = connection.getInputStream();  
	      //FileOutputStream os = new FileOutputStream(filePath+"\\123.xls"); 
	      FileOutputStream os = new FileOutputStream(filePath+"/register"+"_"+time+".xls"); 

	      byte[] buffer = new byte[4 * 1024];  
	      int read;  
	      while ((read = in.read(buffer)) > 0) {  
	          os.write(buffer, 0, read);  
	           }  
	        os.close();  
	        in.close();
	   }*/
	 
	 
	 
	 public void downLoad(String filePath, HttpServletResponse response) throws Exception {    //struts
	     // System.out.println("filePath"+filePath);
	         File f = new File(filePath);
	         if (!f.exists()) {
	             response.sendError(404, "File not found!");
	             return;
	         }
	         BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
	         byte[] buf = new byte[1024];
	         int len = 0;
	         response.reset();
	         response.setContentType("application/x-msdownload");
	         response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
	         OutputStream out = response.getOutputStream();
	         while ((len = br.read(buf)) > 0)
	             out.write(buf, 0, len);
	         br.close();

	         out.close();
	   
	         response.reset();
	     } 
	   
} 
