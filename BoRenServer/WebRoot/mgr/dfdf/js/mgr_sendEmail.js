var mydata = {
	"email" : {},
	"info" : "写上回复内容",
	"userId" : "",
	"typeid" : "",
};
var vum = new Vue({
	"el" : "#app",
	"data" : mydata,
	"created" : function() {
		this.selectEmail();
	},
	"methods" : {
		/** ******获取当前的邮件************** */
		"selectEmail" : function() {
			var url = decodeURI(window.location.href);
			var argsIndex = url.split("?obj=");
			var arg = argsIndex[1];

			$.getJSON("../../getGmEmail.do?emailId=" + arg, function(data) {
				mydata.email = data.list;
				mydata.userId = data.list[0].userInfo.userId;
				mydata.typeid = data.list[0].emailType.emailTypeId;
			});
		},
		/** ************添加邮件******************** */
		"addEmail" : function() {

			var url = "../../addGmEmailAll.do?textInfo=" + mydata.info
					+ "&emailStatus=" + 0 + "&emailType_1=" + 0 + "&sendId="
					+ 1 + "&sendToId=" + mydata.userId + "&typeId="
					+ mydata.typeid;
			$.getJSON(url, function(data) {
				alert(data.mess);
				mydata.info = "写上回复内容";
			});
		}
	}
});