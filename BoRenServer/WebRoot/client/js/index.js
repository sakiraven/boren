
var all = {
	'hotPost' : {},
	'cookList':{},
	'url':"img/",
	'notice':{},
	'acctId':-1,
	'message':{},
	'messageStatus':0,
	'acctName':"",
	'acctPwd':"",
	'zcName':"",
	'zcAccount':"",
	'zcPwd':"",
	'ssText':"",
	'gm':{},
	'admin':-1
};


var indexT = new Vue({
	el : ".all",
	data : all,
	created : function() {
		this.getAcctId();
		this.hotPosts();
		this.showList();
		this.showCook();
		this.msgStatus();
	},
	methods : {
		//判断用户是否登录
		getAcctId:function(){
			var key="acctId";
			var cki = $.cookie(key);
			if(cki==undefined)
				cki="acctId=-1";
			var getLogin = cki.split("=");
			for(var i = 0;i<getLogin.length;i++){
				all.acctId=getLogin[1];
			}
			//$.cookie("acctId", "acctId=3", {expires: 7});
		},
		//显示热门
		hotPosts : function() {
			$.getJSON("../postLoveQuery.do", function(data) {
				all.hotPost = data["postList"];
			});
		},
		//跳转板块
		location:function(postId){
			alert(postId)
			location.href="tiezi.html?postId="+postId;
		},
		//板块跳转
		postType:function(type){
			location.href="BanKuaiJieMian.html?postType="+type;
		},
		//显示通知
		showNotice:function(){
			$.getJSON("../queryNotice.do", function(data) {	
				all.notice = data["noticeList"];
			});
		},
		//显示菜单
		showCook :function(){
			$.getJSON("../queryCookBook.do", function(data) {				
				all.cookList = data["cookBookList"];
			});
		},
		//关闭公告
		closeMessage:function(){
			$(".xuhua_bj").hide();
		},
		//查看消息
		showMessage:function(){
			var messageParam = "acctId="+all.acctId;
			$.getJSON("../queryMessageByUserInfo.do", messageParam,function(data) {
				all.message = data["messageList"];
			});
		},
		//消息状态
		msgStatus:function(){
			//轮询
			timer = setInterval(function(){
			var messageParam = "msgSendToId="+all.acctId;
			$.getJSON("../queryMessageSize.do",messageParam,function(data){
				all.messageStatus = data["result"];
				if(all.messageStatus!=0)
					$(".icon-box-add").css("background-color","red");
				else
					$(".icon-box-add").css("background-color","black");
			});
			if(all.acctId==-1)
				clearInterval(timer);
			},"10000");
		},
		//登录窗口显示
		showLogin : function(){
			$(".dl_bj").show();
		},
		//关闭登录
		hideLogin : function(){
			$(".datu1").empty();
			$(".dl_bj").hide();
			
		},
		//**************************************剩男把登录验证写这里
		userLogin:function(){
			var loginParam ="acctName="+all.acctName+
			"&acctPwd="+all.acctPwd ;
			$.getJSON("../clientLogin.do",loginParam,function(data){
				if(data["acctId"]==-1)
					alert("用户名或密码错误——登录失败");
				else{
					alert("登录成功");
					indexT.hideLogin();
					$.cookie("acctId", "acctId="+data["acctId"], {expires: 7});
					all.acctId=data["acctId"];
					all.admin=data["adminId"];
					if(data["adminId"]>1)
						location.replace("../mgr/dfdf/AdminShouYe.html");
					indexT.showList();
				}
			});
		},
		//注销登录
		zhuXiao:function(){
			$.cookie('acctId', "acctId=-1", {expires: 7});
			all.acctId=-1;
			$(".scroll_menu").remove();
			indexT.showList();
		},
		//注册显示
		zhuCe:function(){
			window.location.replace("zhuce.html");
		},
		//注册隐藏
		hide:function(){
			$(".zc_bj").hide();
		},
		//注册按钮
		zhuCeGo:function(){
			var zhuCeParam = "userName="+all.zcName+
							"&acctName="+all.zcAccount+
							"&acctPwd="+all.zcPwd
			$.get("../addAccount.do",zhuCeParam,function(data){
				alert(data["result"])
			})
			indexT.hide();
		},
		//申诉显示 关闭
		ssShow:function(){
			$(".shensu_ui").show();
		},
		//申诉关闭
		ssHide:function(){
			$(".shensu_ui").hide();
		},
		//申诉发送
		ssSend:function(type){
			var ssSendParam = "emailText="+all.ssText+
			"&sendId="+all.acctId+
			"&emailType="+type;
			$.getJSON("../addGm.do",ssSendParam,function(data){
				if(data["result"]==1)
					alert("发送成功");
				else
					alert("发送异常 请联系管理员 qq714158220@qq.com");
				
			});
		},
		//关闭系统通知
//        $(".guanbi_xx1").click(function () {
//            $(".xuhua_bj1").hide();
//        })
		//反馈显示
		fkShow:function(){
			$(".fankui_ui").show();
		},
		fkHide:function(){
			$(".fankui_ui").hide();
		},
		fkSend:function(){
			
		},
		//死亡标签显示关闭
		showList:function(){
			$(".scroll_menu").remove();
			$("#scroll_show_menu_button").remove();
			var test = this;
			  if(all.acctId!=-1){
		        	icoroll({
		                links: $('.scroll'),
		                tip_distance: 30,
		                back_enabled: true,
		                time: 1500
		            }, {
		                position: 'right',
		                elements: [
		                    {'class': 'icon-home-2', 'href': '', 'content': '回到顶部', 'color': 'red'},
		                    {'class': 'icon-mobile', 'href': '#responsive', 'content': '个人信息'},
		                    {'class': 'icon-pencil', 'href': '', 'content': '签到'},
		                    {'class': 'icon-box-add', 'href': '#package', 'content': '消息列表'},
		                    {'class': 'icon-IcoMoon', 'href': '#iconmoon', 'content': '系统通知'},
		                    { 'class':'icon-arrow-left-2','href':'#history','content':'返回首页'}
		                ]
		            });
		        	test.msgStatus();
		        }else{
		        	icoroll({
		                links: $('.scroll'),
		                tip_distance: 30,
		                back_enabled: true,
		                time: 1500
		            }, {
		                position: 'right',
		                elements: [
		                    {'class': 'icon-home-2', 'href': '', 'content': '回到顶部', 'color': 'red'},
		                    { 'class':'icon-arrow-left-2','href':'#history','content':'返回首页'}
		                ]
		            });
		        }
		},
	}
});



$(function () {
	$("body").on("click",".scroll_colors",function() {
		if ($(this).text() == "返回首页") {
			$(location).attr('href', 'index.html');
		}
		if ($(this).text() == "个人信息") {
			$(location).attr('href', 'geren.html');
		}
		if ($(this).text() == "签到") {
			var sign ="acctId="+all.acctId;
			$.get("../sign.do",sign,function(data){
				if(data["result"]==0)
					alert("今日已签到");
				else if(data["result"]==1)
					alert("签到成功");
				else if(data["result"]==-1)
					alert("签到异常 请联系管理员 qq2784260366");
			});
		}
		if($(this).text()=="系统通知"){
             $(".xuhua_bj1").show();
             var noticeParam ="acctId="+all.acctId;
             $.getJSON("../queryGm.do",noticeParam,function(data){
            	 alert(data["gmList"])
            	 all.gm = data["gmList"];
             });
         }
		if ($(this).text() == "消息列表") {
			$(".xuhua_bj").show();
			indexT.msgStatus();
			var messageParam = "msgSendToId="+all.acctId;
			$.getJSON("../queryMessageByUserInfo.do", messageParam,function(data) {
				all.message = data["messageList"];
				$(".icon-box-add").css("background-color","black");
			});
		}
	});
		//通知列表关闭
	$("body").on("click",".guanbi_xx1",function(){
		$(".xuhua_bj1").hide();
	});
	//登录按钮
	$(".dl").click(function() {
		//注册隐藏
		$(".zc_bj").hide();
		//登录显示
		$(".dl_bj").show();
	})
});




;(function($){
	$.fn.jcMarquee = function(options) {
		var defaults = {
			'marquee':'x',
			'margin_bottom':'0',
			'margin_right':'0',
            'speed':'10'
		};
		var options = $.extend(defaults,options);
		return this.each(function() {
	        var $marquee = $(this),
			    $marquee_scroll = $marquee.children('ul');
			$marquee_scroll.append("<li class='clone'>"+"</li>");
			$marquee_scroll.find('li').eq(0).children().clone().appendTo('.clone');
			var $marquee_left = $marquee_scroll.find('li');
			if (options.marquee == 'x') {
				var x = 0;
		        $marquee_scroll.css('width','1000%');
				$marquee_left.find('div').css({'margin-right':options.margin_right});
				$marquee_left.css({'margin-right':options.margin_right});
                function Marquee_x(){ 
	                $marquee.scrollLeft(++x);
					_margin = parseInt($marquee_left.find('div').css('margin-right'));
		            if(x==$marquee_left.width()+_margin) { x = 0 };
				};
		    	var MyMar=setInterval(Marquee_x,options.speed); 
                $marquee.hover(function(){
                    clearInterval(MyMar);
                },function(){
                    MyMar=setInterval(Marquee_x,options.speed);
                });
			}
			if (options.marquee == 'y') {
				var y = 0;
		        $marquee_scroll.css('height','1000%');
				$marquee_left.find('div').css('margin-bottom',options.margin_bottom);
				$marquee_left.css('margin-bottom',options.margin_bottom);
                function Marquee_y(){ 
	                $marquee.scrollTop(++y);
					_margin = parseInt($marquee_left.find('div').css('margin-bottom'));
		            if(y==$marquee_left.height()+_margin) { y = 0 };
				};
		    	var MyMar=setInterval(Marquee_y,options.speed); 
                $marquee.hover(function(){
                    clearInterval(MyMar);
                },function(){
                    MyMar=setInterval(Marquee_y,options.speed);
                });
			};
		});
	};
})(jQuery)



//****************************热度
/*var hot = new Vue({
	el : "#hot",
	data : all,
	created : function() {
		this.hotPosts();
		this.showList();
	},
	methods : {
		hotPosts : function() {
			$.getJSON("../postLoveQuery.do", function(data) {
				all.hotPost = data["postList"];
			});
		},
		location:function(postId){
			location.href="tiezi.html?postId="+postId;
		},
		showList:function(){
			alert(1)
		}
		
	}
});*/
/*//****************************板块跳转
var locationPostType=new Vue({
	el:".sifenlei",
	methods:{
		postType:function(type){
			location.href="BanKuaiJieMian.html?postType="+type;
		}
	}
});
//*****************************菜谱
var cookbook = new Vue({
	el:".cook",
	data:all,
	created:function(){
		this.showCook();
	},
	methods:{
		showCook :function(){
			$.getJSON("../queryCookBook.do", function(data) {				
				all.cookList = data["cookBookList"];
			});
		}
	}
});
//*****************************公告
var notice = new Vue({
	el:".gonggaoneirong",
	data:all,
	created:function(){
		this.showNotice();
	},
	methods:{
		showNotice:function(){
			$.getJSON("../queryNotice.do", function(data) {	
				all.notice = data["noticeList"];
			});
		}
	}
	
})*/
