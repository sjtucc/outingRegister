<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <link rel="shortcut icon" href="111.ico"/>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
function ifCanToDao() {
	var user = document.getElementById("user").value;
	var password = document.getElementById("password").value;

	if(user=="sap" && password=="sap") {

		document.getElementById("form3").action="houTai.action";
		document.getElementById("form3").submit();
	}
	else {
		/* document.getElementById("form3").action="delete.action";
		document.getElementById("form3").submit(); */
		return false;
	}
		
}
</script>

  </head>
  
  <body>
    <form id="form3" action="" method="post">
    	User:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="user" id="user"/><br/>
    	Password:<input type="password" name="password" id="password"/><br/>
    	<input type="button" value="ok" onclick="ifCanToDao()" />
    </form>
  </body>
</html>
