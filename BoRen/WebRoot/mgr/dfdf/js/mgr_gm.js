/** *********GM 管理***************** */
var mydata = {
	"noticeList" : {},// 公告
	"cookList" : {},// 菜品
	"commodityList" : {},// 商品
	"noticeTitle" : "",// 公告标题
	"noticeInfo" : "",// 公告信息
	"cookName" : "",// 菜品名字
	"cookImg" : "",// 菜品图品
	"cookPrice" : "",// 菜品价格
	"shopName" : "",// 商品名字
	"shopPrice" : "",// 商品价格

};
var vum = new Vue({
	"el" : "#myapp",
	"data" : mydata,
	"created" : function() {
		this.allNotice();
		this.allCook();
		this.allCommodity();
	},
	"methods" : {
		// 获取所有公告
		"allNotice" : function() {
			$.getJSON("../../noticeAll.do", function(data) {
				mydata.noticeList = data.list;
			});
		},
		// 获取所有菜品
		"allCook" : function() {
			$.getJSON("../../cookBookAll.do", function(data) {
				mydata.cookList = data.list;
			});
		},
		// 获取所有商品
		"allCommodity" : function() {
			$.getJSON("../../shopListAll.do", function(data) {
				mydata.commodityList = data.list;
			});
		},
		// 添加公告
		"addNotice" : function() {
			var notice = {
				"noticeId" : null,
				"noticeText" : mydata.noticeInfo,
				"noticeTitle" : mydata.noticeTitle
			};
			var vss = this;
			$.getJSON("../../addNotice.do", notice, function(data) {
				alert(data.mess);
				vss.allNotice();
			});
		},
		// 添加菜品
		"addCook" : function() {
			var vss = this;
			var numReg = /^[0-9]+$/;
			var numRe = new RegExp(numReg);
			if (numRe.test(mydata.cookPrice)) {
				var cookbook = {
					"cookId" : null,
					"cookImg" : mydata.cookImg,
					"cookName" : mydata.cookName,
					"cookPrice" : mydata.cookPrice
				};
				$.getJSON("../../addCookBook.do", cookbook, function(data) {
					alert(data.mess);
					vss.allCook();
					mydata.cookImg = "";
					mydata.cookName = "";
					mydata.cookPrice = "";
				});
			} else {
				alert("请输入整数！");
			}
		},
		// 添加商品
		"addCommodity" : function() {
			var vss = this;
			var numReg = /^[0-9]+$/;
			var numRe = new RegExp(numReg);
			if (numRe.test(mydata.shopPrice)) {
				var sl = {
					"shopId" : null,
					"shopName" : mydata.shopName,
					"shopPrice" : mydata.shopPrice
				};
				$.getJSON("../../addShopList.do", sl, function(data) {
					alert(data.mess);
					vss.allCommodity();
					mydata.shopName = "";
					mydata.shopPrice = "";
				});
			} else {
				alert("请输入整数！");
			}
		},
		// 删除公告
		"delNotice" : function(id) {
			var vss = this;
			var notice = {
				"noticeId" : id,
				"noticeText" : null,
				"noticeTitle" : null
			};
			$.getJSON("../../delNotice.do", notice, function(data) {
				alert(data.mess);
				vss.allNotice();

			});
		},
		// 删除菜品
		"delCook" : function(id) {
			var vss = this;
			var cookbook = {
				"cookId" : id,
				"cookImg" : null,
				"cookName" : null,
				"cookPrice" : null
			};
			$.getJSON("../../delCookBook.do", cookbook, function(data) {
				alert(data.mess);
				vss.allCook();
			});
		},
		// 删除 商品
		"delCommodity" : function(id) {
			var vss = this;
			var sl = {
				"shopId" : id,
				"shopName" : null,
				"shopPrice" : null
			};
			$.getJSON("../../delShopList.do", sl, function(data) {
				alert(data.mess);
				vss.allCommodity();
			});
		},

	}
});

$(function() {
	$(".guanbian").click(function() {
		$(this).parent().parent().parent().hide();
	});
	$(".addgonggao").click(function() {
		$("#news").show();
	});
	$(".addcaipu").click(function() {
		$("#cook").show();
	});
	$(".addshangpin").click(function() {
		$("#shop").show();
	});
	$(".ljtj").click(function() {
		$(this).parent().parent().hide();
	});

});