<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> 
	
	<!--  <link href="style1.css" rel="stylesheet" type="text/css" /> -->
	
	
    <link rel="stylesheet" href="css/style2.css" media="screen" type="text/css" />
    <script src="js/modernizr.js"></script>
    <script src='js/jquery.js'></script>
    
    
	<!-- <script type="text/javascript" src="script.js"></script> -->


	<script type="text/javascript" src="js/ajax.js"></script>
	
	<script type="text/javascript">

		function ifCanToDao(){
			my_name_show();
			cellphone_show();
			my_card_show();
			partner_name_show();
			partner_card_show();
			kid_name_show();
			kid_card_show();
			room_mate_name_show();
			var hidden_my_name = document.getElementById("hidden_my_name").value;
			var hidden_cellphone = document.getElementById("hidden_cellphone").value;
			var hidden_my_card = document.getElementById("hidden_my_card").value;
			
			var hidden_partner_name = document.getElementById("hidden_partner_name").value;
			var hidden_partner_card = document.getElementById("hidden_partner_card").value;
			var hidden_kid_name = document.getElementById("hidden_kid_name").value;
			var hidden_kid_card = document.getElementById("hidden_kid_card").value;
	
			if(hidden_my_name=="ok" && hidden_cellphone=="ok" && hidden_my_card=="ok" && hidden_partner_name!="format error!" 
			   && hidden_partner_card!="format error!"&& hidden_kid_name!="format error!"&& hidden_kid_card!="format error!") {
				document.getElementById("form1").action="deal.action";
				document.getElementById("form1").submit();
			} 
			
		}
		
		 function ifCancel()
  		{
		  	  if(confirm("Are you sure to give up tourism ?")) {
		  	 	cellphone_show();
				my_card_show();
				var hidden_cellphone = document.getElementById("hidden_cellphone").value;
				var hidden_my_card = document.getElementById("hidden_my_card").value;
				if(hidden_cellphone=="ok" && hidden_my_card=="ok") {
		
		  	 	 	document.getElementById("form1").action="giveUp.action";
					document.getElementById("form1").submit();
				 }
		      } 
		      else {
		     /*  document.form1.action = "sap/admin_confirmBug.action";
				 form1.submit(); */
		      }
  		}
  		

	</script>

<%
	if(request.getAttribute("my_name")==null)
		request.setAttribute("my_name", "");
	if(request.getAttribute("cellphone")==null)
		request.setAttribute("cellphone", "");
	if(request.getAttribute("my_card")==null)
		request.setAttribute("my_card", "");
	if(request.getAttribute("partner_name")==null)
		request.setAttribute("partner_name", "");
	if(request.getAttribute("partner_card")==null)
		request.setAttribute("partner_card", "");
	if(request.getAttribute("kid_name")==null)
		request.setAttribute("kid_name", "");
	if(request.getAttribute("kid_card")==null)
		request.setAttribute("kid_card", "");
	if(request.getAttribute("room_mate")==null)
		request.setAttribute("room_mate", "");
	String submit_or_update = "Update";
	if(request.getAttribute("my_name").equals(""))
		submit_or_update = "Submit";
		
 %>

  </head>
  
  <body>


	<form id="form1" action="" method="post">

		<input id="my_id" name="my_id" type="text" class="name" onchange="my_id_show()" value="<%=request.getSession().getAttribute("id") %>" disabled="true"　readOnly="true"/>
		

	
		<input id="my_name" name="my_name" class="name" onchange="my_name_show()" value="<%=request.getAttribute("my_name") %>" placeholder="ID or passport name" title="if a foreigner, pls. fill passport name!"/> <span style="color:red" id="my_name_msg"></span>
	
		
	
		<input id="cellphone" name="cellphone" type="text" class="name" onchange="cellphone_show()" value="<%=request.getAttribute("cellphone") %>" placeholder="mobile number" /><span style="color:red" id="cellphone_msg"></span>
	
		
	
		<input id="my_card" name="my_card" type="text" class="name" onchange="my_card_show()" value="<%=request.getAttribute("my_card") %>" placeholder="ID or passport number"/><span style="color:red" id="my_card_msg"></span>
		
		
		
	
		<input id="partner_name" name="partner_name" type="text" class="name" onchange="partner_name_show()" value="<%=request.getAttribute("partner_name") %>" placeholder="partner's ID or passport name" title="if a foreigner, pls. fill passport name!"/><span style="color:red" id="partner_name_msg"></span>
		
		
	
		<input id="partner_card" name="partner_card" type="text" class="name" onchange="partner_card_show()" value="<%=request.getAttribute("partner_card") %>" placeholder="partner's ID or passport number"/><span style="color:red" id="partner_card_msg"></span>
		
		
		
		<input id="kid_name" name="kid_name" type="text" class="name" onchange="kid_name_show()" value="<%=request.getAttribute("kid_name") %>" placeholder="kid's ID or passport name" title="if a foreigner, pls. fill passport name!"/><span style="color:red" id="kid_name_msg"></span>
		
		
		
		<input id="kid_card" name="kid_card" type="text" class="name" onchange="kid_card_show()" value="<%=request.getAttribute("kid_card") %>" placeholder="kid's ID or passport number"/><span style="color:red" id="kid_card_msg"></span>
		
		
		
		<select id="select" name="room_type" class="name" value="<%=request.getAttribute("room_type") %>"> 
		 <option value="one-bed room" style="background-color:red">one-bed room</option>
		 <option value="two-beds room" style="background-color:red">two-Beds room</option>
		</select>  
	

	
		<input id="room_mate" name="room_mate" type="text" class="name" onchange="room_mate_name_show()" value="<%=request.getAttribute("room_mate") %>" placeholder="room mate's sap id"title="room mate"/><span style="color:red" id="room_mate_name_msg"></span>
		
		
		
			<input class="btn" type="button" value="<%=submit_or_update %>" onclick="ifCanToDao()" />
		
	
			<input class="btn2" type="button" value="Cancel" onclick="ifCancel()" />
	
		
		
		
			<input type="hidden"  id="hidden_my_name" value="0"> 
			<input type="hidden"  id="hidden_cellphone" value="0"> 
			<input type="hidden"  id="hidden_my_card" value="0"> 
			<input type="hidden"  id="hidden_partner_name" value="0"> 
			<input type="hidden"  id="hidden_partner_card" value="0"> 
			<input type="hidden"  id="hidden_kid_name" value="0"> 
			<input type="hidden"  id="hidden_kid_card" value="0"> 
			<input type="hidden"  id="hidden_room_mate_name" value="0"> 
	</form>


</body>


</html>






