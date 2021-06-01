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
	<div id="app">
	{{message.userInfos[0].userTime}}
	</div>
  </head>
  
  <body>
   	
  </body>
  <script src= "css/jquery-1.12.4.js"></script>
  <script src="css/vue.js"></script>
  
  <script>
 
		var app = new Vue({
			el : '#app',
			data : {
				message : {}
			},
			created : function() {
				this.test1();
			},
			methods : {
				test1 : function() {
					var asd = this;
					$.getJSON("clientLogin.do", "acctName=lzh&acctPwd=123",function(data) {
							asd.message = data["getAccount"];
					})
				}
			}
		})
			
		<%--
			$(function() {
				$.getJSON("clientLogin.do", "acctName=lzh&acctPwd=123",
						function(data) {
							alert(data["getAccount"].admin.adminName);
						});
			})
		--%></script>
</html>
