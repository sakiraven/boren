/** ***********用户管理**************** */
var mydata = {
	"adminList" : {},
	"currPage" : 1,
	"countPage" : 1,
	"userList" : {},
	"countSize" : "",
	"userName" : "",
	"userId" : 0,
	"day" : "1",
	"adminId" : 0,

};

var vum = new Vue({
	"el" : "#allTheOne",
	"data" : mydata,
	"created" : function() {
		this.leve();
	},
	"methods" : {
		"leve" : function() {
			/** ************查询所有等级***************** */
			$.getJSON("../../adminAll.do", function(data) {
				mydata.adminList = data.allAdmin;
			});
			/** *************查询所有用户************************ */
			this.entitySelect();
		},
		/** *************按照昵称查询用户******************** */
		"findName" : function() {
			$.getJSON("../../allUserInfo.do?userName=" + mydata.userName,
					function(data) {
						mydata.currPage = data.currPage;
						mydata.countPage = data.countPage;
						mydata.userList = data.list;
					});
		},
		/** *************添加封印******************* */
		"addSeal" : function(userId) {
			var am = this;
			$.getJSON("../../addStatusUser.do?userId=" + userId + "&day="
					+ mydata.day);
			setTimeout(am.entitySelect(), 500);
		},
		/** *************封印解除******************* */
		"delSeal" : function() {
			var am = this;
			$.post("../../delStatusUser.do?userId=" + mydata.userId);
			// am.entitySelect();
			setTimeout(am.entitySelect(), 500);

		},
		/** ************更改等级**************** */
		"updateAdmin" : function() {
			var am = this;
			$.getJSON("../../updateAccount.do?userInfoId=" + mydata.userId
					+ "&adminId=" + mydata.adminId, function() {
				am.entitySelect();
			});

		},
		/** **********查询首页************ */
		"entitySelect" : function() {
			$.getJSON("../../allUserInfo.do?currPage=" + mydata.currPage
					+ "&time=" + new Date().getTime(), function(data) {
				mydata.currPage = data.currPage;
				mydata.countPage = data.countPage;
				mydata.userList = data.list;
				mydata.countSize = data.countSize;
			});
		},
		/** **********首页-上一页-下一页-尾页*********** */
		"pageSelect" : function(curr) {
			if (curr >= mydata.countPage) {
				mydata.currPage = mydata.countPage;
			} else if (curr <= 0) {
				mydata.currPage = 1;
			}
			this.entitySelect();
		},
	}
});
$(function() {
	var userId = 0;
	$("#allTheOne").on("click", ".fh", function() {
		userId = $(this).parents("tr").find("td:first").html();
	});
	$("#allTheOne").on("click", ".jf", function() {
		mydata.userId = $(this).parents("tr").find("td:first").html();
		vum.delSeal();
		vum.entitySelect();
	});
	$("#allTheOne").on("change", "select", function() {
		mydata.userId = $(this).parents("tr").find("td:first").html();
		mydata.adminId = $(this).val();
		vum.updateAdmin();
	});
	$("#allTheOne").on("click", "#save", function() {
		vum.addSeal(userId);
		vum.entitySelect();
	});

});