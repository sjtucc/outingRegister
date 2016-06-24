<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录界面</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>

<script type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript">
$(function() {
	$('#login').click(function() {
		var a = document.getElementById("hidden_name_go_if_submit").value;
		var b = document.getElementById("hidden_psd_go_if_submit").value;
		if(a==1 && b==1) {
			
			document.getElementById("form1").action="register1.action";
			document.getElementById("form1").submit();
		}

	});
	
	$('#register').click(function() {
			var a = document.getElementById("hidden_name_if_submit").value;
			var b = document.getElementById("hidden_psd_if_submit").value;
			var c = document.getElementById("hidden_psd_confirm_if_submit").value;
		
		  if(a==1 && b==1 && c==1) {
	
		       go_to_save_id_and_psd();	//将账户保存到数据库
		   
		   		//$('.register').submit(); //到登录界面
		   }
		 else {
		  	return false;
		  }	
	});
})


//------login---
function go_name()
{
	var content_name_go = $("#name").val();
	var name_go = $("#name");
	var reg_name_go =/^([Ii]\d{6}|[Cc]\d{7})$/;
	
	if (content_name_go == "" || (!reg_name_go.test(content_name_go))) {
		$(name_go).parent().next().css("display", "none");
		$(name_go).parent().next().next().css("display", "block");
	}  else {
		$(name_go).parent().next().css("display", "block");
		$(name_go).parent().next().next().css("display", "none");
		document.getElementById("hidden_name_go_if_submit").value=1;
	} 
}


function go_psd()
{
	var content_psd_go = $("#psd").val();
	var psd_go = $("#psd");
	var reg_psd_go =/^\d{6}$/;
	
	if (content_psd_go == "" || (!reg_psd_go.test(content_psd_go))) {
		$(psd_go).parent().next().css("display", "none");
		$(psd_go).parent().next().next().css("display", "block");
	}  else {
		$(psd_go).parent().next().css("display", "block");
		$(psd_go).parent().next().next().css("display", "none");
		document.getElementById("hidden_psd_go_if_submit").value=1;
	} 
}

//--------register---



function register_name()
{
	var content_name = $("#name_r").val();
	var r_name = $("#name_r");
	var reg_name =/^([Ii]\d{6}|[Cc]\d{7})$/;
	
	if (content_name == "" || (!reg_name.test(content_name))) {
		$(r_name).parent().next().css("display", "none");
		$(r_name).parent().next().next().css("display", "block");
	} 
	
    my_id_show(); //goto ajax to database
	
	var hidden_name = $("#hidden_name").val();   //接收后台数据，判断在数据库它是否已经存在

	if(reg_name.test(content_name)) {
		if(hidden_name==0) {
			$(r_name).parent().next().css("display", "block");
			$(r_name).parent().next().next().css("display", "none");
			document.getElementById("hidden_name_if_submit").value=1;
		} else {
			$(r_name).parent().next().css("display", "none");
			$(r_name).parent().next().next().css("display", "block");
			alert("exist");
		}
		
	} 
}
function register_psd()
{
	var content_psd = $("#psd_r").val();
	var r_psd = $("#psd_r");
	var reg_psd =/^\d{6}$/;
	if (content_psd == "" || (!reg_psd.test(content_psd))) {
		$(r_psd).parent().next().css("display", "none");
		$(r_psd).parent().next().next().css("display", "block");
	} else if(reg_psd.test(content_psd)){
		$(r_psd).parent().next().css("display", "block");
		$(r_psd).parent().next().next().css("display", "none");
		document.getElementById("hidden_psd_if_submit").value=1;
	} 
}
function register_affirm_psd()
{
	var content_affirm_psd = $("#affirm_psd").val();
	var r_affirm_psd = $("#affirm_psd");
	var content_psd = $("#psd_r").val();
	if (content_affirm_psd != content_psd) {
		$(r_affirm_psd).parent().next().css("display", "none");
		$(r_affirm_psd).parent().next().next().css("display", "block");
	} else {  //两个psd相等，不行，得第一个psd符合条件
		$(r_affirm_psd).parent().next().css("display", "block");
		$(r_affirm_psd).parent().next().next().css("display", "none");
		document.getElementById("hidden_psd_confirm_if_submit").value=1;
	} 
}

function barter_btn(bb) {
	$(bb).parent().parent().fadeOut(1000);
	$(bb).parent().parent().siblings().fadeIn(2000);
}
</script>
   



  </head>
  
<body class="login_body">

<div class="login_div">
	<div class="col-xs-12 login_title">Sign in</div>
	<form id="form1"  action="" class="login" method="post">
		<div class="nav">
			<div class="nav login_nav">
				<div class="col-xs-4 login_username">
					SAP ID:
				</div>
				<div class="col-xs-6 login_usernameInput">
					<input type="text" name="user" id="name" value="" placeholder="&nbsp;&nbsp;SAP ID"  onchange="go_name()" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			<div class="nav login_psdNav">
				<div class="col-xs-4">
					PASSWORD:
				</div>
				<div class="col-xs-6">
					<input type="password" name="password" id="psd" value="" placeholder="&nbsp;&nbsp;6 numbers" onchange="go_psd()" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			<div class="col-xs-12 login_btn_div">
				<input type="submit" class="sub_btn" value="Sign in" id="login" />
			</div>
		</div>
		
		<input type="hidden"  id="hidden_name_go_if_submit" value="0"> 
		<input type="hidden"  id="hidden_psd_go_if_submit" value="0"> 
	</form>

	<div class="col-xs-12 barter_btnDiv">
		<button class="barter_btn" onClick="javascript:barter_btn(this)">No account? Create one!</button>
	</div>
</div>

<div class="register_body">
	<div class="col-xs-12 register_title">REGISTER</div>
	<form action="" class="register" method="post">
		<div class="nav">
			<div class="nav register_nav">
				<div class="col-xs-4">
					SAP ID:
				</div>
				<div class="col-xs-6">
					<input type="text" name="" id="name_r" value="" placeholder="&nbsp;&nbsp;SAP ID" onchange="register_name()" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			<div class="nav register_psdnav">
				<div class="col-xs-4">
					PASSWORD:
				</div>
				<div class="col-xs-6">
					<input type="password" name="" id="psd_r" value="" placeholder="&nbsp;&nbsp;6 numbers" onchange="register_psd()" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			<div class="nav register_affirm">
				<div class="col-xs-4">
					CONFIRM:
				</div>
				<div class="col-xs-6">
					<input type="password" name="" id="affirm_psd" value="" placeholder="&nbsp;&nbsp;6 numbers" onchange="register_affirm_psd()" />
				</div>
				<div class="col-xs-1 ok_gou">
					√
				</div>
				<div class="col-xs-1 error_cuo">
					×
				</div>
			</div>
			
			
			
			<div class="col-xs-12 register_btn_div">
				<input type="submit" class="sub_btn" value="register" id="register" />
			</div>
		</div>
		
		<input type="hidden"  id="hidden_name" value="hidden1"> 
			
			<input type="hidden"  id="hidden_name_if_submit" value="0"> 
			<input type="hidden"  id="hidden_psd_if_submit" value="0"> 
			<input type="hidden"  id="hidden_psd_confirm_if_submit" value="0"> 
			
			<input type="hidden"  id="wuyong" value="0"> 
	</form>
	<div class="col-xs-12 barter_register">
		<button class="barter_registerBtn" onClick="javascript:barter_btn(this)" style="">Have account? To login</button>
	</div>
</div>
<!-- <div style="text-align:center;">
<p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div> -->

</body>

</html>
