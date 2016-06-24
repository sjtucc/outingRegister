<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link rel="shortcut icon" href="111.ico"/>
    <base href="<%=basePath%>">
    
    <title>admin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">  
table {  
    border: 2px #CCCCCC solid;  
    width: 360px;  
}  
  
td,th {  
    height: 30px;  
    border: #CCCCCC 1px solid;  
}  
</style> 

<script type="text/javascript">
      function func(){
      
      	
      	 <input type="text" maxlength="100" id="name"  name="name" value =""/>
      }
      window.onload=func; 
</script> 

<script type="text/javascript">



function exportExcel()
  {
      if(confirm("Are you sure to export the database ?")) {
  	 	
  	 	 document.form2.action = "export.action";
		 form2.submit();
		
      } 
      else {
		 return false;
      }
  }
  
  function cleanDatabase()
  {
  	  if(confirm("Are you sure to delete the database ?")) {
  	 	
  	 	 document.form2.action = "delete.action";
		 form2.submit();
		 
      } 
      else {
		 return false;
      }
  }
  
 
 

</script>

  </head>
  
  <body>






  <form name="form2" method="post" action="">
  	<input type="button" value="EXPORT" onclick="exportExcel();" /> <!-- form2.action='export.action';form2.submit(); -->
  	<input type="button" value="CLEAN" onclick="cleanDatabase();" />
  </form>	


<hr />

     <%  
        
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sap","root","111111");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from information");  
        
        
        Statement st1 = conn.createStatement();
        ResultSet resultSet = st1.executeQuery("select count(*) as rowCount from information");
        resultSet.next();
        int rowCount = resultSet.getInt("rowCount");
  
    %>  
    Current number : <input type="text" value=<%=rowCount %> readOnly="readonly" />
    <br>  
    <br>  
    <table align="center" style="width: 1194px; ">  
        <tr>  
            <th>  
                <%  
                    out.print("my_id");  
                %>  
            </th>  
            <th>  
                <%  
                    out.print("my_name");  
                %>  
            </th>  
            <th>  
                <%  
                    out.print("cellphone");  
                %>  
            </th>  
             <th>  
                <%  
                    out.print("my_card");  
                %>  
            </th>
            <th>  
                <%  
                    out.print("partner_name");  
                %>  
            </th>  
            <th>  
                <%  
                    out.print("partner_card");  
                %>  
            </th>  
            <th>  
                <%  
                    out.print("kid_name");  
                %>  
            </th>  
            
            <th>  
                <%  
                    out.print("kid_card");  
                %>  
            </th> 
            <th>  
                <%  
                    out.print("room_type");  
                %>  
            </th>   
            <th>  
                <%  
                    out.print("room_mate");  
                %>  
            </th> 
            <th>  
                <%  
                    out.print("time");  
                %>  
            </th> 
        </tr>  
  
        <%  
            while (rs.next()) {  
        %>  
        <tr>  
            <td>  
                <%  
                    out.print(rs.getString(1));  
                %>  
            </td>  
            <td>  
                <%  
                    out.print(rs.getString(2));  
                %>  
            </td>  
            <td>  
                <%  
                    out.print(rs.getString(3));  
                %>  
            </td>
            <td>  
                <%  
                    out.print(rs.getString(4));  
                %>  
            </td> 
            <td>  
                <%  
                    out.print(rs.getString(5));  
                %>  
            </td> 
            <td>  
                <%  
                    out.print(rs.getString(6));  
                %>  
            </td> 
            
            <td>  
                <%  
                    out.print(rs.getString(7));  
                %>  
            </td> 
            <td>  
                <%  
                    out.print(rs.getString(8));  
                %>  
            </td> 
            <td>  
                <%  
                    out.print(rs.getString(9));  
                %>  
            </td> 
            <td>  
                <%  
                    out.print(rs.getString(10));  
                %>  
            </td> 
                <td>  
                <%  
                    out.print(rs.getString(11));  
                %>  
            </td> 
            
        </tr>  
        <%  
            }  
        %>  
    </table> 
    
    <br />
    <br />
    <br />
    
    
    <%  
        rs.close();  
        st.close();  
        conn.close();  
    %> 
    
 
 
  </body>
</html>
