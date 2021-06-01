var all = {
		postList:{},
		postHot:{},
		postTypeName:"",
		sendPostTypeId : 0,
		sendPostTitle :"默认标题",
		sendPostText:"",
		acctId:-1,
		postTitle:''
};
var sendPost={
		sendPostTypeId : 0,
		sendPostTitle :"",
}
var paramPost ={
		postTypeId:0,
		currentPage:1,
		postTitle:''
};
var userInfo={
		acctId:-1
}
//***********************************帖子显示
var postType = new Vue({
	el:'.all',
	data:all,
	created:function(){
		this.getAcctId();
		//
	},
	methods:{
		//获取id
		getAcctId:function(){
			var key="acctId";
			var cki = $.cookie(key);
			if(cki==undefined)
				cki="acctI0d=-1";
			var getLogin = cki.split("=");
			for(var i = 0;i<getLogin.length;i++){
				all.acctId=getLogin[1];
			}
		},
		//展示帖子
		showPost:function(){
			var search=window.location.search;
			var param=decodeURI(search);
			if(param!=null&&param!=""){
				paramPost.postTypeId=parseInt(param.substring(param.indexOf("=")+1));
				all.sendPostTypeId=parseInt(param.substring(param.indexOf("=")+1));
				if (all.sendPostTypeId == 1)
					all.postTypeName = "闲聊灌水";
				else if (all.sendPostTypeId == 2)
					all.postTypeName = "编程技术";
				else if (all.sendPostTypeId == 3)
					all.postTypeName = "周边环境";
				else if (all.sendPostTypeId == 4)
					all.postTypeName = "美女帅哥";
			}
			var showPostParam = "currentPage="+paramPost.currentPage+
							"&postTypeId="+paramPost.postTypeId+
							"&postTitle="+all.postTitle;
			$.getJSON("../postTypeQuery.do",showPostParam, function(data) {
				all.postList = data["postList"];
				all.postHot = data["hot"];
				paramPost.currentPage = data["currentPage"];
			});
		},
		//跳转帖子
		location:function(postId){
			location.href="tiezi.html?postId="+postId;
		},
		//发帖字体
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
		//发帖
		sendPost:function(){
			var sendPost = "postText="+all.sendPostText+
			"&postTitle="+all.sendPostTitle+
			"&postTypeId="+all.sendPostTypeId+
			"&postUserId="+all.acctId;
			$.getJSON("../postAdd.do",sendPost, function(data) {
				alert(data["result"]);
				var show = this;
				if(data["result"]==1){
					alert("发帖成功");
					$('html,body').animate({scrollTop:0},1000);
					postType.showPost();
				}else if(data["result"]==-1){
					alert("发帖异常 请联系管理员qq714158220");
				}else if(data["result"]==-200){
					alert("标题或者正文含有非法文字 请纠正您的发言");
				}
					
			});
		},
		//搜索帖子
		serschPost:function(){
			paramPost.currentPage=1;
			postType.showPost();
		}
	}
	
});
//*******************************************滚动刷新
$(function () {
    icoroll({
        links: $('.scroll'),
        tip_distance: 30,
        back_enabled: true,
        time: 1500
    }, {
        position: 'right',
        elements: [
            { 'class':'icon-home-2','href':'#home','content':'回到顶部'},
            { 'class':'icon-chrome','href':'#browsers','content':'发帖'},
            { 'class':'icon-arrow-left-2','href':'#history','content':'首页'}
        ]
    });
});
$(function(){
	flush();
	//滚动刷新
	 function flush(){
		 $(window).scroll(function(e) {
			 if ($(document).scrollTop() <= 0) {
			    console.log("滚动条已经到达顶部为0");
			  }
			  lastTime = e.timeStamp;
			  if ($(document).scrollTop() >= $(document).height() - $(window).height()) {
				 setTimeout(function() {
					 if (lastTime - e.timeStamp == 0) {
						 postType.showPost();
					 }
				 },500);
			  }
			});
	 }
	 //***********************************搜索 帖子
	 $('.zongtisousuo').click(function(){
	 })
	 $('.zongtisousuo').keyup(function(e) {
			/*lastTime = e.timeStamp;
			setTimeout(function() {
				if (lastTime - e.timeStamp == 0) {
					$(document).scrollTop(0);
					postType.showPost();
				}
			}, 1000);*/
	});
	 //返回移动滚动条
	 $("body").on("click",".scroll_colors",function(){
		 if($(this).parent().index()==0)
			 $('html,body').animate({scrollTop:0},1000);
		 else if($(this).parent().index()==1)
			 $('html,body').animate({scrollTop:(document.body.offsetHeight-1000)},1000);
		 else if($(this).parent().index()==2){
			 location.replace("index.html");
		 }
	 })
});