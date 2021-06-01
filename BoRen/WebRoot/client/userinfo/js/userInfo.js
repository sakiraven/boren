
var allParam = {
		userInfo:{},
		acctId:{},
		userEx:""
};


var userInfo = new Vue({
	el:".all",
	data:allParam,
	created:function(){
		
		this.getAcctId();
		this.showUserInfo();
		
	},
	methods:{
		//显示用户信息
		showUserInfo:function(){
				var showUserParam = "account.acctId="+allParam.acctId ;
				$.getJSON("../../queryUserInfoOne.do", showUserParam, function(data) {
					allParam.userInfo = data["userInfo"];
					allParam.userEx=allParam.userInfo.userEx+"%"
					$(".jindu").html(" <div class='skillbar css'><span class='title'></i> 等级 </span><span class='percent'>"+allParam.userInfo.userEx+"%</span> <div class='filled' data-width='"+allParam.userInfo.userEx+"%'></div></div>")
					alert(allParam.userInfo.userEx)
				});
		},location:function(){
			location.href="zhifu/index.php";
		},buyVip:function(){
			var spendParam = "account.acctId="+allParam.acctId+
			"&shopId=1"+
			"&userBalance=10";
			$.getJSON("../../spend.do", spendParam, function(data) {
				alert(data["result"]);
				userInfo.showUserInfo();
				
			});
		},
		//判断用户是否登录
		getAcctId:function(){
			var key="acctId";
			var cki = $.cookie(key);
			if(cki==undefined)
				cki="acctId=-1";
			var getLogin = cki.split("=");
			for(var i = 0;i<getLogin.length;i++){
				allParam.acctId=getLogin[1];
			}
			//$.cookie("acctId", "acctId=3", {expires: 7});
		}
	}
});
$(function(){
	
	$(".filled").attr("data-width","71%")
})
