var mydata = {
	"currPage" : 1,
	"countPage" : 1,
	"emailList" : {},
	"emailtypeId" : 1,
};
var vum = new Vue({
	"el" : "#myApp",
	"data" : mydata,
	"created" : function() {
		this.gmEmailAll(mydata.emailtypeId, mydata.currPage);
	},
	"methods" : {
		/** ***对应帖子类型的所有帖子********** */
		"gmEmailAll" : function(type, curr) {
			mydata.emailtypeId = type;
			$.getJSON("../../gmEmailAll.do?currPage=" + curr + "&typeId="
					+ type, function(data) {
				mydata.emailList = data.list;
				mydata.currPage = data.currPage;
				mydata.countPage = data.countPage;
			});
		},
		/** ***********删除****************** */
		"delGmEmail" : function(emailId) {
			var vss = this;
			var gmEmail = {
				"emailId" : emailId
			};

			$.getJSON("../../delGmEmail.do", gmEmail, function(data) {
				alert(data.mess);
				vss.gmEmailAll(mydata.emailtypeId, mydata.currPage);
			});
		},
		/** **********首页-上一页-下一页-尾页*********** */
		"pageSelect" : function(curr) {
			if (curr >= mydata.countPage) {
				mydata.currPage = mydata.countPage;
			} else if (curr <= 0) {
				mydata.currPage = 1;
			}
			this.gmEmailAll(mydata.emailtypeId, mydata.currPage);
		},
		/** ******跳转******* */
		"htmlTi" : function(emId) {
			var obj = emId;
			$.getJSON("../../updateGmEmail.do?eid=" + emId, function(data) {
				var url = 'EmailHuiFu.html?obj=' + obj;
				url = encodeURI(url);
				window.location.href = url;

			});
		},
	}
});
$(function() {
	$(".mailxt div").click(
			function() {
				$(this).removeClass().addClass("jubaomail").siblings()
						.removeClass().addClass("fankuimail");
			});

});