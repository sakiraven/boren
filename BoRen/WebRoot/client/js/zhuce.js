var all = {
    		zcName:"",
    		zcAccount:"",
    		zcPwd:""
    }
    var zhuceT = new Vue({
    	el:'.zc_bj',
    	data:all
    })

$(function () {
    $("#mailbutton").attr("disabled", true);
    var email = 0;
    //var key = 1;
//	验证昵称规则
    var ncint = 0;
//	验证用户名规则
    var yhmint = 0;
//	验证密码规则
    var mm = 0;
//	验证确认密码规则
    var qrmm = 0;
//	验证协议规则
    var xyxz = 0;
    //验证验证码规则
    var yzm = 0;
    //验证滑块是否符合规则
    var hk = 0;
    //验证码随机数 x为上限，y为下限,rand为随机数结果
    var strYhm = "";
    var x = 99999;
    var y = 10000;
    var rand = 0;
//当发送验证码按钮点击时会执行发送验证码的代码

    
    
    $('#emailsave').on('submit', function () {
		
    	
    	
        rand = parseInt(Math.random() * (x - y + 1) + y);
        $("#yzmsjs").val("验证码：" + rand+"<br><br>"+"验证码将会在30分钟后销毁，请尽快使用（注：为保障您的隐私安全，请不要把验证码告诉他人）");
        registPost()
        event.preventDefault() //阻止form表单默认提交
    })
    function registPost() {
        $.ajax({
//            type: "post",
            url: "http://api.guaqb.cn/music/yx/qq.php?",
            data: $('#emailsave').serialize(),
        }).success(function (message) {
            console.log(message)
            alert("发送失败")
        }).fail(function (err) {
            console.log(err)
            alert("发送成功")
            var count11 = 60;
            var countdown = setInterval(CountDown, 1000);
            strYhm = $(".zc_email").val();
            function CountDown() {
                $("#fsyzm").attr("disabled", true);
                $("#fsyzm").val(count11);
                if (count11 == 0) {
                    $(".fsyzm").val("重新发送").removeAttr("disabled");
                    clearInterval(countdown);
                }
                count11--;
            }
        })
    }

    // 同意协议并注册按钮 的点击事件
    $(".submit_zc").click(function () {
        //alert(111)
        // 获取昵称
        var text1 = $(".zc_username").val();
        // 获取用户名
        var text2 = $(".zc_email").val();
        // 获取密码
        var password = $(".zc_password").val();
        // 获取确认密码
        var repsword = $(".zc_querenmm").val();
        // 获取用户协议
        var isChecked = $('#kuang').prop('checked');
        // 获取用户名是不是邮箱
        var str = $(".zc_email").val();
        var ret = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
        if (text1.length == 0) {
            ncint = 0;
            $("#ncnull").html("*昵称不能为空*")
            $(".zc_username").css("border", "1px solid red");
        }
        if (text2 == "") {
            yhmint = 0;
            $("#yhmnull").html("*用户名不能为空*");
            $(".zc_email").css("border", "1px solid red");
            $("#yhmnull").css("color", "#e16366");
        }
        if (password.length == 0) {
            mm = 0;
            $("#mmnull").html("*密码不能为空*")
            $(".zc_password").css("border", "1px solid red");
        }
        if (repsword.length == 0) {
            qrmm = 0;
            $("#qrmmnull").html("*确认密码不能为空*")
            $(".zc_querenmm").css("border", "1px solid red");
        }


        if (isChecked == false) {
            xyxz = 0;
            //$("#yhxynull").show();
            //alert("请勾选用户协议");
        }

//		alert(key)
//		if(key>0){
//
//			location.href="../pagemgr/zhuye.jsp";
//
//		}

        //alert(yzm)
        //alert(hk)
        //alert(xyxz)
//        验证所有条件是否成立，全部成立才执行注册事件
        if (ncint > 0 && yhmint > 0 && mm > 0 && qrmm > 0 && xyxz > 0 && yzm > 0 && hk > 0) {
        	var zhuCeParam = "userName="+$(".zc_username").val()+
    		"&acctName="+$(".zc_email").val()+
    		"&acctPwd="+$(".zc_password").val();
    		$.get("../clientAddAccount.do",zhuCeParam,function(data){
    			alert(data["result"]);
    		});
        } else {
            alert("有规则未成立");
        }
    });
$(".yzm").on('input propertychange',function(){
    var mail = $(".yzm").val();
    if (mail == "") {
        $(".yzmmm").html("*验证码不能为空*")
        yzm = 0;
    } else if (mail == rand && strYhm == $(".zc_email").val()) {
        yzm++;
        $(".yzmmm").html("*验证码正确*")
    } else {
        $(".yzmmm").html("*验证码错误*")
        yzm = 0;
    }
})
    // 验证昵称规则是否成立
    $('.zc_username').on('input propertychange', function () {
        // 获取昵称
        var text1 = $(".zc_username");
        if (text1.val() == "") {
            ncint = 0;
            $("#ncnull").html("*昵称不能为空*")
            $(".zc_username").css("border", "1px solid red");
        } else {
            var count = $(this).val().length;
            if (count > 0 && count < 7) {
                // 正则表达式
                var ce = new RegExp("^[A-Za-z0-9\u4e00-\u9fa5]+$");
                // 获取输入框中的值
                var usernamee = document.getElementById("nicheng").value.trim();
                if (!ce.test(usernamee)) {
                    $("#ncnull").html("*昵称只能由中文 英文 数字组成*")
                    ncint = 0;
                } else {
                    //第一次++
                    ncint++;
                    $("#ncnull").html("");
                    $(".zc_username").css("border", "none");
                }
            } else if (count == 0) {
                ncint = 0;
                $("#ncnull").html("*昵称不能为空*")
                $(".zc_username").css("border", "1px solid red");
            } else if (count > 6) {
                ncint = 0;
                $("#ncnull").html("昵称最多6个字符");
            }
        }
    })
    // 验证用户名规则是否成立
    $('.zc_email').on('input propertychange', function () {
        var text2 = $(".zc_email");
        if (text2.val() == "") {
            yhmint = 0;
            $("#yhmnull").html("*用户名不能为空*");
            email = 0;
            $(".zc_email").css("border", "1px solid red");
            $("#yhmnull").css("color", "#e16366");
            $("#mailbutton").attr("disabled", true);

            $("#mailbutton").css("color", "#467da2");
            $("#mailbutton").css("background-color", "#203b52")

        } else {
            var strr = $(".zc_email").val();
            var rett = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
            if (rett.test(strr)) {
                //第二次++
                yhmint++;
                email++;
                $("#yhmnull").html("");
                $(".zc_email").css("border", "none");
                $("#mailbutton").removeAttr("disabled");
                $("#mailbutton").css("color", "#67c1f5");
                $("#mailbutton").css("background-color", "#2b4e6e")
            } else {
                yhmint = 0;
                $("#yhmnull").html("*用户名必须为邮箱*")
                $("#yhmnull").css("color", "#e16366");
                email = 0;
                $("#mailbutton").attr("disabled", true);
                $("#mailbutton").css("color", "#467da2");
                $("#mailbutton").css("background-color", "#203b52")
            }
        }
    })
    // 验证密码规则是否成立
    $('.zc_password').on('input propertychange', function () {
        // 获取密码
        var password = $(".zc_password");
        // 获取确认密码
        var repsword = $(".zc_querenmm");
        if (password.val() == "") {
            mm = 0;
            qrmm = 0;
            $("#mmnull").html("*密码不能为空*")
            $(".zc_password").css("border", "1px solid red");
        } else {
            var count = $(this).val().length;
            if (password.val() == repsword.val()) {
                //第三次++
                $("#qrmmnull").html("")
            } else {
                qrmm = 0;
                $("#qrmmnull").html("*两次密码输入不一致*")
                mm = 0;
            }
            $('.zc_password').keyup(function () {
                var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
                var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
                var enoughRegex = new RegExp("(?=.{6,}).*", "g");
                if (false == enoughRegex.test($(this).val())) {
                    var count = $(this).val().length;
                    mm = 0;
                    qrmm = 0;
                    $("#mmnull").html("*密码强度：弱*")
                    $(".zc_password").css("border", "1px solid red");
                    $("#mmnull").css("color", "#e16366");
                    // 密码小于六位的时候，密码强度图片都为灰色
                    var password = $(".zc_password");
                    // 获取确认密码
                    var repsword = $(".zc_querenmm");
                    if (password.val() == "") {
                        mm = 0;
                        qrmm = 0;
                        $("#mmnull").html("*密码不能为空*")
                        $(".zc_password").css("border", "1px solid red");
                        $("#qrmmnull").html("")
                    }
                } else if (strongRegex.test($(this).val())) {
                    //第四次++
                    if ($(".zc_password").val() == $(".zc_querenmm").val()) {
                        mm++;
                        qrmm++;
                    }
                    $("#mmnull").html("*密码强度：强*")
                    $(".zc_password").css("border", "none");
                    $("#mmnull").css("color", " #67c1f5");
                    var password = $(".zc_password");
                    // 获取确认密码
                    var repsword = $(".zc_querenmm");
                    // 密码为八位及以上并且字母数字特殊字符三项都包括,强度最强
                } else if (mediumRegex.test($(this).val())) {
                    $("#mmnull").html("*密码强度：中*")
                    mm = 0;
                    qrmm = 0;
                    $(".zc_password").css("border", "none");
                    $("#mmnull").css("color", "#ffac55");
                    var password = $(".zc_password");
                    // 获取确认密码
                    var repsword = $(".zc_querenmm");
                    if (password.val() == repsword.val()) {
                     $("#qrmmnull").html("")
                     }

                    // 密码为七位及以上并且字母、数字、特殊字符三项中有两项，强度是中等
                } else {
                    mm = 0;
                    qrmm = 0;
                    $("#mmnull").html("*密码强度：弱*")
                    $(".zc_password").css("border", "1px solid red");
                    $("#mmnull").css("color", "#e16366");
                    var password = $(".zc_password");
                    //获取确认密码
                    var repsword = $(".zc_querenmm");
                    if (password.val() == repsword.val()) {
                     $("#qrmmnull").html("")
                     }
                    if (password.val() == "") {

                     $("#mmnull").html("*密码不能为空*")
                     $(".zc_password").css("border","1px solid red");
                     $("#qrmmnull").html("")
                     }
                    // 如果密码为6为及以下，就算字母、数字、特殊字符三项都包括，强度也是弱的
                }
                //return true;
            });
        }
        // 验证确认密码规则是否成立
        $('.zc_querenmm').on('input propertychange', function () {
            //获取密码
            var password = $(".zc_password");
            // 获取确认密码
            var repsword = $(".zc_querenmm");
            if (password.val() == "") {
                mm = 0;
                qrmm = 0;
                $("#mmnull").html("*密码不能为空*")
                $(".zc_password").css("border", "1px solid red");
            } else {
                var count = $(this).val().length;
                if (password.val() == repsword.val()) {
                    $("#qrmmnull").html("");
                    var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
                    var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
                    var enoughRegex = new RegExp("(?=.{6,}).*", "g");
                    if (false == enoughRegex.test($(this).val())) {
                        var count = $(this).val().length;
                        mm = 0;
                        qrmm = 0;
                        $("#mmnull").html("*密码强度：弱*")
                        $(".zc_password").css("border", "1px solid red");
                        $("#mmnull").css("color", "#e16366");
                        // 密码小于六位的时候，密码强度图片都为灰色
                        var password = $(".zc_password");
                        // 获取确认密码
                        var repsword = $(".zc_querenmm");
                        if (password.val() == "") {
                            mm = 0;
                            qrmm = 0;
                            $("#mmnull").html("*密码不能为空*")
                            $(".zc_password").css("border", "1px solid red");
                            $("#qrmmnull").html("")
                        }
                    } else if (strongRegex.test($(this).val())) {
                        //第四次++
                        if ($(".zc_password").val() == $(".zc_querenmm").val()) {
                            mm++;
                            qrmm++;
                        }
                        $("#mmnull").html("*密码强度：强*")
                        $(".zc_password").css("border", "none");
                        $("#mmnull").css("color", " #67c1f5");
                        var password = $(".zc_password");
                        // 获取确认密码
                        var repsword = $(".zc_querenmm");
                        // 密码为八位及以上并且字母数字特殊字符三项都包括,强度最强
                    } else if (mediumRegex.test($(this).val())) {
                        $("#mmnull").html("*密码强度：中*")
                        mm = 0;
                        qrmm = 0;
                        $(".zc_password").css("border", "none");
                        $("#mmnull").css("color", "#ffac55");
                        var password = $(".zc_password");
                        // 获取确认密码
                        var repsword = $(".zc_querenmm");
                        if (password.val() == repsword.val()) {
                         $("#qrmmnull").html("")
                         }

                        // 密码为七位及以上并且字母、数字、特殊字符三项中有两项，强度是中等
                    } else {
                        mm = 0;
                        qrmm = 0;
                        $("#mmnull").html("*密码强度：弱*")
                        $(".zc_password").css("border", "1px solid red");
                        $("#mmnull").css("color", "#e16366");
                        var password = $(".zc_password");
                        //获取确认密码
                        var repsword = $(".zc_querenmm");
                        if (password.val() == repsword.val()) {
                         $("#qrmmnull").html("")
                         }
                        if (password.val() == "") {

                         $("#mmnull").html("*密码不能为空*")
                         $(".zc_password").css("border","1px solid red");
                         $("#qrmmnull").html("")
                         }
                        // 如果密码为6为及以下，就算字母、数字、特殊字符三项都包括，强度也是弱的
                    }
                } else {
                    mm = 0;
                    qrmm = 0;
                    $("#qrmmnull").html("*两次密码输入不一致*")
                }
            }
        })
    })
//验证码规则是否成立
//    $('.yzm').on('input propertychange', function () {
//
//
//    })
//判断协议选项是否被选中
    $("#kuang").click(function () {
        var isChecked = $('#kuang').prop('checked');
        if (isChecked == false) {
            $("#yhxynull").show();
            xyxz = 0;
        } else {
            xyxz++;
            $("#yhxynull").hide();
        }
    })
    //当用户在用户名输入框那里离开的时候会执行 阿贾克斯 代码，从数据库里实时判断此账号是否存在
    $(".zc_email").blur(function () {
        if (email > 0) {
            var yhm = $(".zc_email").val();
            $.post("../../AccountServlet", "yhm=" + yhm + "&opr=yzyhm", callBack);
            function callBack(data) {
                if (data > 0) {
                    $("#yhmnull").html("*用户名已经被注册*");
                    $(".zc_email").css("border", "1px solid red");
                    $("#yhmnull").css("color", "#e16366");
                    $("#mailbutton").attr("disabled", true);
                    $("#mailbutton").css("color", "#467da2");
                    $("#mailbutton").css("background-color", "#203b52")
                } else {
                    $("#yhmnull").html("用户名可以注册");
                    $(".zc_email").css("none");
                    $("#yhmnull").css("color", "#67c1f5");
                    $("#mailbutton").removeAttr("disabled");
                    $("#mailbutton").css("color", "#67c1f5");
                    $("#mailbutton").css("background-color", "#2b4e6e")
                }
            }
        }
    })

    $("#datu1").html('<div id="imgVer" style="display:inline-block;"></div>');
    imgVer({
        el: '$("#imgVer")',
        width: '300',
        height: '116',
        img: [
            'images/ver.png',
            'images/ver-1.png',
            'images/ver-2.png',
            'images/ver-3.png'
        ],
        success: function () {
            hk = 1;
        },
        error: function () {
            hk = 0;
        }
    });

})

