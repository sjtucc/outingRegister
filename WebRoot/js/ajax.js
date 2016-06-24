


	//建立xmlHttp核心对象
       var xmlHttp;
       //创建XMLHttpRequest核心对象
       function createXMLHttp()
       {
           //判断当前使用的浏览器类型
           if(window.XMLHttpRequest)
           {
              //表示使用的是FireFox内核的浏览器
              xmlHttp=new XMLHttpRequest();
           }else
           {
              //表示使用的是IE内核的浏览器
              xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
           }
       }
     
       
      
       function go_to_save_id_and_psd()     //保存注册的用户名密码
       {
           var my_id = document.getElementById("name_r").value;
           var psd_r = document.getElementById("psd_r").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","SaveServlet", true);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=go_to_save_id_and_psd_Callback;
           //发送请求，不传递任何参数
          xmlHttp.send("my_id="+my_id+"&psd_r="+psd_r);
           //xmlHttp.send("my_id="+my_id);
       }
       function go_to_save_id_and_psd_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                  
                  document.getElementById("wuyong").value=text;
              }
           }
       }
       
       
       
       
       //--------------------------------my_id
       function my_id_show()
       {
           var my_id = document.getElementById("name_r").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","MyIdServlet", false);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=my_id_Callback;
           //发送请求，不传递任何参数
           xmlHttp.send("my_id="+my_id);
       }
       function my_id_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                  //设置要使用的CSS样式表
                  //document.getElementById("msg").className="样式表名称";
                  //document.getElementById("my_id_msg").innerHTML=text;
                  document.getElementById("hidden_name").value=text;
              }
           }
       }
       //-----------------------------------my_id
       
       //--------------------------------my_name
       function my_name_show()
       {
           var my_name = document.getElementById("my_name").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","MyNameServlet", false);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=my_name_Callback;
           //发送请求，不传递任何参数
           xmlHttp.send("my_name="+my_name);
       }
       function my_name_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                  //设置要使用的CSS样式表
                  //document.getElementById("msg").className="样式表名称";
                 document.getElementById("hidden_my_name").value=text;
                 if(text != "ok") {
                	 document.getElementById("my_name_msg").innerHTML=text;
                 } else {
               	  if (!!window.ActiveXObject || "ActiveXObject" in window)
            		  document.getElementById("my_name_msg").innerHTML="";
            	  else
            		  document.getElementById("my_name_msg").innerHTML=null;
            	  
              }
              }
           }
       }
       //-----------------------------------my_name
       
        //--------------------------------cellphone
       function cellphone_show()
       {
           var cellphone = document.getElementById("cellphone").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","CellphoneServlet", false);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=cellphone_Callback;
           //发送请求，不传递任何参数
           xmlHttp.send("cellphone="+cellphone);
       }
       function cellphone_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
            	  /*if (!!window.ActiveXObject || "ActiveXObject" in window)    //此方法兼容ie11
            	        alert("我是 IE"); 
            	  else
            		    alert("我不是 IE"); */
            
            	  
   
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                 // alert(text);
                  //设置要使用的CSS样式表
                  //document.getElementById("msg").className="样式表名称";
                  document.getElementById("hidden_cellphone").value=text;
                  if(text != "ok") {
                  document.getElementById("cellphone_msg").innerHTML=text;
                  } else {
                	  if (!!window.ActiveXObject || "ActiveXObject" in window)
                		  document.getElementById("cellphone_msg").innerHTML="";
                	  else
                		  document.getElementById("cellphone_msg").innerHTML=null;
                	  
                  }
              }
           }
       }
       //-----------------------------------cellphone
       
       
       
         //--------------------------------my_card
       function my_card_show()
       {
           var my_card = document.getElementById("my_card").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","MyCardServlet", false);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=my_card_Callback;
           //发送请求，不传递任何参数
           xmlHttp.send("my_card="+my_card);
       }
       function my_card_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                  //设置要使用的CSS样式表
                  //document.getElementById("msg").className="样式表名称";
                  document.getElementById("hidden_my_card").value=text;
                  if(text != "ok") {
                  document.getElementById("my_card_msg").innerHTML=text;
                  } else {
                	  if (!!window.ActiveXObject || "ActiveXObject" in window)
                		  document.getElementById("my_card_msg").innerHTML="";
                	  else
                		  document.getElementById("my_card_msg").innerHTML=null;
                	  
                  }
              }
           }
       }
       //-----------------------------------my_card
 
 
 	  //--------------------------------partner_name
       function partner_name_show()
       {
           var partner_name = document.getElementById("partner_name").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","PartnerNameServlet", true);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=partner_name_Callback;
           //发送请求，不传递任何参数
           xmlHttp.send("partner_name="+partner_name);
       }
       function partner_name_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                  //设置要使用的CSS样式表
                  //document.getElementById("msg").className="样式表名称";
                  document.getElementById("hidden_partner_name").value=text;
                  if(text != "ok") {
                  document.getElementById("partner_name_msg").innerHTML=text;
                  }  else {
                	  if (!!window.ActiveXObject || "ActiveXObject" in window)
                		  document.getElementById("partner_name_msg").innerHTML="";
                	  else
                		  document.getElementById("partner_name_msg").innerHTML=null;
                	  
                  }
              }
           }
       }
       //-----------------------------------partner_name
 

       //--------------------------------partner_card
       function partner_card_show()
       {
           var partner_card = document.getElementById("partner_card").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","PartnerCardServlet", true);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=partner_card_Callback;
           //发送请求，不传递任何参数
           xmlHttp.send("partner_card="+partner_card);
       }
       function partner_card_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                  //设置要使用的CSS样式表
                  //document.getElementById("msg").className="样式表名称";
                  document.getElementById("hidden_partner_card").value=text;
                  if(text != "ok") {
                  document.getElementById("partner_card_msg").innerHTML=text;
                  }   else {
                	  if (!!window.ActiveXObject || "ActiveXObject" in window)
                		  document.getElementById("partner_card_msg").innerHTML="";
                	  else
                		  document.getElementById("partner_card_msg").innerHTML=null;
                	  
                  }
              }
           }
       }
       //-----------------------------------partner_card
 
       
       //--------------------------------kid_name
       function kid_name_show()
       {
           var kid_name = document.getElementById("kid_name").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","KidNameServlet", true);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=kid_name_Callback;
           //发送请求，不传递任何参数
           xmlHttp.send("kid_name="+kid_name);
       }
       function kid_name_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                  //设置要使用的CSS样式表
                  //document.getElementById("msg").className="样式表名称";
                  document.getElementById("hidden_kid_name").value=text;
                  if(text != "ok") {
                  document.getElementById("kid_name_msg").innerHTML=text;
                  }  else {
                	  if (!!window.ActiveXObject || "ActiveXObject" in window)
                		  document.getElementById("kid_name_msg").innerHTML="";
                	  else
                		  document.getElementById("kid_name_msg").innerHTML=null;
                	  
                  }
              } 
           }
       }
       //-----------------------------------kid_name
       
       
       
       //--------------------------------kid_card
       function kid_card_show()
       {
           var kid_card = document.getElementById("kid_card").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","KidCardServlet", true);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=kid_card_Callback;
           //发送请求，不传递任何参数
           xmlHttp.send("kid_card="+kid_card);
       }
       function kid_card_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                  //设置要使用的CSS样式表
                  //document.getElementById("msg").className="样式表名称";
                  document.getElementById("hidden_kid_card").value=text;
                  if(text != "ok") {
                  document.getElementById("kid_card_msg").innerHTML=text;
                  } else {
                	  if (!!window.ActiveXObject || "ActiveXObject" in window)
                		  document.getElementById("kid_card_msg").innerHTML="";
                	  else
                		  document.getElementById("kid_card_msg").innerHTML=null;
                	  
                  }
              }
           }
       }
       //-----------------------------------kid_card
       
       //--------------------------------room_mate_name
       function room_mate_name_show()
       {
           var room_mate = document.getElementById("room_mate").value;
        
           //建立一个xmlHttp核心对象
           createXMLHttp();
           //设置一个请求
           xmlHttp.open("POST","RoomMateNameServlet", true);
           xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  //!!!!后台获取不到参数，这个要写
           //设置请求完成之后处理的回调函数
           xmlHttp.onreadystatechange=room_mate_name_Callback;
           //发送请求，不传递任何参数
           xmlHttp.send("room_mate="+room_mate);
       }
       function room_mate_name_Callback()
       {
           if(xmlHttp.readyState==4)       //定义回调函数
           {
              if(xmlHttp.status==200)     //正常HTML操作
              {
                  //接受返回的内容
                  var text=xmlHttp.responseText;
                  //设置要使用的CSS样式表
                  //document.getElementById("msg").className="样式表名称";
                  document.getElementById("hidden_room_mate_name").value=text;
                  if(text != "ok") {
                  document.getElementById("room_mate_name_msg").innerHTML=text;
                  } else {
                	  if (!!window.ActiveXObject || "ActiveXObject" in window)
                		  document.getElementById("room_mate_name_msg").innerHTML="";
                	  else
                		  document.getElementById("room_mate_name_msg").innerHTML=null;
                	  
                  }
              }
           }
       }
       //-----------------------------------room_mate_name
       
       
