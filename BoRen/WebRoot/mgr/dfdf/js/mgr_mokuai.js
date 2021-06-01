var mydata = {
	"oneList" : {},
	"twoList" : {},
	"threeList" : {},
	"fourList" : {},
	"allTypeList" : {},
	"typeName1" : "",
	"typeName2" : "",
	"typeName3" : "",
	"typeName4" : "",
	"typeId1" : "",
	"typeId2" : "",
	"typeId3" : "",
	"typeId4" : "",
	"oneListSize" : "",
	"twoListSize" : "",
	"threeListSize" : "",
	"fourListSize" : "",
	"currPageOne" : "",
	"currPageTwo" : "",
	"currPageThree" : "",
	"currPageFour" : "",
	"countPageOne" : "",
	"countPageTwo" : "",
	"countPageThree" : "",
	"countPageFour" : "",

};
var vum = new Vue({
	"el" : "#app",
	"data" : mydata,
	"created" : function() {
		this.typeList();
	},
	"methods" : {
		/** *******获取相应的板块里的内容********************** */
		"postList" : function(curr, typeId, s) {
			$.getJSON("../../postList.do?currPage=" + curr + "&postTypeId="
					+ typeId, function(data) {
				if (mydata.oneList.length == 0
						|| mydata.oneList.length == undefined
						|| mydata.typeId1 == typeId) {
					if (mydata.typeName1 == "") {
						mydata.typeName1 = mydata.allTypeList[s].postType;
						mydata.typeId1 = mydata.allTypeList[s].postTypeId;
					}
					mydata.oneList = data.list;
					mydata.currPageOne = data.currPage;
					mydata.countPageOne = data.countPage;
				} else if (mydata.twoList.length == 0
						|| mydata.twoList.length == undefined
						|| mydata.typeId2 == typeId) {
					if (mydata.typeName2 == "") {
						mydata.typeName2 = mydata.allTypeList[s].postType;
						mydata.typeId2 = mydata.allTypeList[s].postTypeId;
					}
					mydata.currPageTwo = data.currPage;
					mydata.countPageTwo = data.countPage;
					mydata.twoList = data.list;
				} else if (mydata.threeList.length == 0
						|| mydata.threeList.length == undefined
						|| mydata.typeId3 == typeId) {
					mydata.threeList = data.list;
					mydata.currPageThree = data.currPage;
					mydata.countPageThree = data.countPage;
					if (mydata.typeName3 == "") {
						mydata.typeName3 = mydata.allTypeList[s].postType;
						mydata.typeId3 = mydata.allTypeList[s].postTypeId;
					}
				} else if (mydata.fourList.length == 0
						|| mydata.fourList.length == undefined
						|| mydata.typeId4 == typeId) {
					mydata.fourList = data.list;
					mydata.currPageFour = data.currPage;
					mydata.countPageFour = data.countPage;
					if (mydata.typeName4 == "") {
						mydata.typeName4 = mydata.allTypeList[s].postType;
						mydata.typeId4 = mydata.allTypeList[s].postTypeId;
					}
				}
			});
		},
		/** *********获取所有板块********************* */
		"typeList" : function() {
			var vv = this;
			$.getJSON("../../postTypeList.do", function(data) {
				mydata.allTypeList = data.list;

				for ( var i = 0; i < mydata.allTypeList.length; i++) {
					var test = mydata.allTypeList[i].postTypeId;
					vv.postList(1, test, i);
				}
			});
		},
		/** **********首页-上一页-下一页-尾页*********** */
		"pageSelect" : function(curr, tid) {
			if (tid == mydata.typeId1) {
				if (curr >= mydata.countPageOne) {
					mydata.currPageOne = mydata.countPageOne;
				}
			} else if (tid == mydata.typeId2) {
				if (curr >= mydata.countPageTwo) {
					mydata.currPageTwo = mydata.countPageTwo;
				}
			} else if (tid == mydata.typeId3) {
				if (curr >= mydata.countPageThree) {
					mydata.currPageThree = mydata.countPageThree;
				}

			} else if (tid == mydata.typeId4) {
				mydata.currPageFour = mydata.countPageFour;
			}
			if (curr <= 0) {
				if (tid == mydata.typeId1) {
					mydata.currPageOne = "1";
				} else if (tid == mydata.typeId2) {
					mydata.currPageTwo = "1";
				} else if (tid == mydata.typeId3) {
					mydata.currPageThree = "1";
				} else if (tid == mydata.typeId4) {
					mydata.currPageFour = "1";
				}
			}
			this.postList(curr, tid, 0);
		},
		"delPost" : function(postid, type, curr) {
			var bool = confirm("是否删除？");
			if (bool) {

				post = {
					"postId" : postid
				};
				var vss = this;
				$.getJSON("../../delPost.do", post, function(data) {
					vss.postList(curr, type, 0);
				});
			}
		},
	}
});