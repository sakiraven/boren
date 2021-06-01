//参数初始化
var allParam ={
		postInfo:{},
		commentInfo:{},
		commentTwo:{},
		currentPage:1,
		countPage:1,
		cmmtCurrentPage:1,
		cmmtCountPage:1,
		acctId:-1,
		postId:-1,
		sendCmmtText:"",
		louZhuId:-1,
		twoAcctId:-1,
		twoText:"",
		twoCurrentPage:-1,
		twoCountPage:-1,
		login:false,
		hrefFloor:-1
		
};
var postT = new Vue({
	el:".zongti11",
	data:allParam,
	created:function(){
		this.getAcctId();
		this.postShow();
		//this.cmmtTwoShow();
	},
	mounted:function(){
	//	this.format();
		
	},
	watch: {
		commentInfo: function () {
	    this.$nextTick(function () {
	    	//alert($(".shengnanniubi").length)
	    })
	  }
	},
	methods:{
		//**************************帖子评论展示
		postShow:function(){
			var search=window.location.search;
			var param=decodeURI(search);
			if(param!=null&&param!="")
				allParam.postId=param.substring(param.indexOf("postId=")+7);
			//楼主参数
			var postParam = "postId="+allParam.postId+
			"&fansId="+allParam.acctId;
			
			//获取楼主内容
			$.getJSON("../postQueryOneById.do",postParam,function(data){
				allParam.louZhuId = data["postList"][0].postUserId;
				allParam.postInfo=data["postList"][0];
				//楼层参数
				var cmmtParam="cmmtPostId="+allParam.postId+
				"&currentPage="+allParam.cmmtCurrentPage+
				"&cmmtUserId="+allParam.acctId;
				//获取楼层内容
				$.getJSON("../commentQueryByCmmtId.do",cmmtParam,function(data){
					allParam.commentInfo = data["commentList"];
					allParam.cmmtCountPage = data["countPage"];
				});
			});
			
		},
		//获取id
		getAcctId:function(){
			var key="acctId";
			var cki = $.cookie(key);
			if(cki==undefined)
				cki="acctId=-1";
			var getLogin = cki.split("=");
			for(var i = 0;i<getLogin.length;i++){
				allParam.acctId=getLogin[1];
			}
		},
		//*************************************替换表情
		format:function(){
			 /*$.emoticons({
			        'activeCls': 'trigger-active'
			    }, function (api) {
			        var $content = $('.tz_fatieneirong');
			        var $result = $('.tz_fatieneirong');
			            $result.html(api.format($content.val()));
			    });*/
		},
		//***********************************二级评论显示
		cmmtTwoShow:function(cmmtId,currentPage,index,type,sendToId){
			  if (type == 1) {
				  	$(".tz_span6").css("background-color", "#f7f7f7");
					$(".tz_span6").css("border", "1px solid #a4a4a4");
					$(".tz_span6").css("border-bottom", "1px solid #f7f7f7");
					$(".tz_huifu").css("border", "1px solid #a4a4a4");
					
					$(".tz_span5:not(:eq(" + index + "))").show();
					$(".tz_span5:not(:eq(" + index + "))").parent().next().hide();
					$(".tz_span5:not(:eq(" + index + "))").next().hide();
					$(".tz_span5:not(:eq(" + index + "))").next().next().show();
					//_______________________________
					$(".tz_span5:eq(" + index + ")").toggle();
					$(".tz_span5:eq(" + index + ")").parent().next().toggle();
					$(".tz_span5:eq(" + index + ")").next().toggle();
					$(".tz_span5:eq(" + index + ")").next().next().toggle();
				
			}
				allParam.twoAcctId = sendToId;
				if(cmmtId==undefined)
					cmmtd=1;
				if(currentPage==undefined)
					currentPage=1;
				var cmmtParam = "cmmtId=" + cmmtId + 
								"&currentPage="+ currentPage;
		$.getJSON("../queryCommentTwoLevel.do", cmmtParam, function(
				data) {
			allParam.commentTwo = data["commentTwoList"];
			allParam.countPage=data["countPage"];
			//allParam.commentInfo[index].cmmtTwoNum=allParam.commentTwo[0].cmmtTwoNum;
		});
		},
		//**********************************************投币
		postB:function(){
			if(!postT.isLogin()){
				return;
			}
			var bParam = "postId="+allParam.postInfo.postId+
			"&sendId="+allParam.acctId+
			"&sendToId="+allParam.louZhuId;
			$.getJSON("../postTouB.do", bParam, function(data) {
				if(data["result"]>0){
					allParam.postInfo.postCoinNum = data["result"];
					alert("投币成功");
				}else{
					alert("余额不足");
				}
			});
		},
		//****************收藏帖子
		postColl:function(){
			if(!postT.isLogin()){
				return;
			}
			var bParam = "postId="+allParam.postInfo.postId+
			"&acctId="+allParam.acctId
			$.getJSON("../addCollPost.do", bParam, function(data) {
				if(!data["result"]==0){
					alert("收藏成功");
					postT.postShow();
				}
				else{
					alert("无法重复收藏");
				}
			});
		},
		//*********************点赞
		postLove:function(){
			if(!postT.isLogin()){
				return;
			}
			var key = 'userCollPost';
			var cki = $.cookie(key);
			var result = 0;
			if(cki==undefined||cki==null)
				cki = "post=-1,";
				
				var postId= cki.split(",");
				var id =[];
				for(var i=0;i<postId.length;i++){
					id = postId[i].split("=");
					if(id[1]==allParam.postId)
						result=1;
				}
				if(result==0){
					postLoveParam = "postId="+allParam.postInfo.postId+
					"&sendId="+allParam.acctId+
					"&sendToId="+allParam.postInfo.postUserId;
					alert(postLoveParam)
					$.getJSON("../postLove.do",postLoveParam , function(data) {
						alert(data["result"]);
						if(data["result"]=="点赞成功"){
							postT.postShow();
							var getid = allParam.postId;
							cki = cki+"post="+getid+",";
							$.cookie(key, cki, {expires: 7});
						};
					});
				}else{
					alert("已经点赞 请七天后再来");
				}
		},
		//*******************点赞 投币 收藏 判断是否登录
		isLogin:function(){
			var result = true;
			if(allParam.acctId==-1){
				alert("请先登录");
				result = false;
			}
			return result;
		},
		//*******************字体添加样式
		selectText:function(type){
			var txt = window.getSelection?window.getSelection():document.selection.createRange().text;
			var txtBe = $("#ztxt").val();
			if(type=="加粗")
				var txtChange="<b>"+txt+"</b>";
			else if(type=="斜体")
				var txtChange="<i>"+txt+"</i>";
			else if(type=="下划线")
				var txtChange="<hr>"+txt+"<hr>";
			var txtAf = txtBe.replace(txt,txtChange);
			$("#ztxt").val(txtAf);
		},
		//***************************发送评论
		sendComment:function(){
			sendCmmtParam = "cmmtPostId="+allParam.postId+
			"&cmmtText="+allParam.sendCmmtText+
			"&sendId="+allParam.acctId+
			"&sendToId="+allParam.louZhuId
			$.getJSON("../commentAdd.do",sendCmmtParam , function(data) {
				postT.alertResult(data["result"],"评论");
				if(data["result"]==1){
					allParam.cmmtCurrentPage =1;
					$(document).scrollTop(0);
					postT.postShow();
				}
			});
			
		},
		//*************************************发送结果
		alertResult:function(result,key){
			if(result ==1)
				alert(key+"成功");
			else if(result == -1)
				alert(key+"异常 请联系管理员 qq714158220");
			else if(result == -200)
				alert(key+"失败  请文明发言");
		},
		//**************************************发送二级回复
		sendTwo:function(floor,cmmtId){
			if(allParam.twoAcctId==undefined){
				alert("请选择回复人")
				return;
			}
			if(allParam.acctId==allParam.twoAcctId){
				alert("不能回复自己");
				return;
			}
			sendCmmtParam = "cmmtPostId="+allParam.postId+
			"&cmmtTwoText="+allParam.twoText+
			"&sendId="+allParam.acctId+
			"&sendToId="+allParam.twoAcctId+
			"&cmmtId="+cmmtId+
			"&cmmtFloor="+floor;
			$.getJSON("../addCommentTwoLevel.do",sendCmmtParam , function(data) {
				postT.alertResult(data["result"],"回复");
				if(data["result"]==1){
					postT.postShow();
					postT.cmmtTwoShow(cmmtId,1,0,0,allParam.twoAcctId);
				}
			});
		},
		//二级回复
		reCallTwo:function(sendId){
			if(sendId==allParam.acctId)
				alert("不能回复自己");
			else
				allParam.twoAcctId = sendId;
		},
		//关注
		guanZhu:function(guanZhuId){
			var guanZhuParam = "fanUser="+guanZhuId+
			"&fanFansUser="+allParam.acctId;
			alert(guanZhuParam)
			$.getJSON("../guanZhu.do",guanZhuParam , function(data){
				postT.postShow();
			});
		}
	}
});
//********************************************滑动刷新
$(function() {
	
	$(window).scroll(
			function(e) {
				if ($(document).scrollTop() <= 0) {
					console.log("滚动条已经到达顶部为0");
				}
				lastTime = e.timeStamp;
				if ($(document).scrollTop() >= $(document).height()
						- $(window).height()) {
					if (allParam.cmmtCurrentPage == allParam.cmmtCountPage)
						return;
					setTimeout(function() {
						allParam.cmmtCurrentPage += 1;
						postT.postShow();
					}, 500);
				}
			});
	
	 $("body").on("click",".scroll_colors",function(){
		 var CurrentBodyHeight=document.body.offsetHeight > 0 
		 ?document.body.offsetHeight 
		: document.body.clientHeight;
		 //顶部
		 if($(this).parent().index()==0)
			 $('html,body').animate({scrollTop:0},1000);
		 //发帖
		 else if($(this).parent().index()==1){
			 //$('html,body').animate({scrollTop:(document.documentElement.clientHeight)},1000);
			 var top = (parseInt($(".fenleifatie").offset().top)-500)
			 $('html,body').animate({scrollTop:top},1000);
		 }
		 //返回首页
		 else if($(this).parent().index()==2){
			 location.replace("index.html");
		 }
		 //跳转楼层
		 else if($(this).parent().index()==3){
			 var floorIndex = parseInt($("#hrefFloor").val())-2;
			 if(floorIndex==1)
				 $('html,body').animate({scrollTop:0},1000);
			 else{
				 floorLength=$(".tz_yilou").length;
				 var currentPage = 0;
				 if(floorIndex>floorLength){
					 currentPage = parseInt(
							 				parseFloat(floorIndex) % parseFloat(10)
							 				?(parseInt(floorIndex)/parseInt(10)+1)
							 				:(parseInt(floorIndex)/parseInt(10)+1)
						 					);
					 if(currentPage>allParam.cmmtCountPage){
						 alert("最大页数："+allParam.cmmtCountPage+"/n无法进行跳转");
						 return;
					 }else{
						allParam.cmmtCurrentPage=currentPage;
						postT.postShow();
						alert("刷新成功 请重新跳转");
					 }
				 }
				 $("html,body").animate({scrollTop:$(".tz_yilou:eq("+floorIndex+")").offset().top}, 800);
			 }
		 }
	 });
	 
	 
});










