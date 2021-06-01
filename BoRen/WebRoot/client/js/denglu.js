/**
 * Created by 清和爸比 on 2019/5/5.
 */
$(function () {

    $(function () {
        $(".kuaisu").show();
        // test 的点击事件
        $(".span4").click(function () {
            $(".zhanghao").show();

            $(".kuaisu").toggle();
        });

    });
    $(function () {

        $(".span5").click(function () {
            $(".kuaisu").show();

            $(".zhanghao").toggle();
        });

    });
    $(function () {

        $(".dl_guanbi").click(function () {


            $(".denglu").toggle();
        });

    });
    $(function () {
        $(".qingdenglu").click(function () {
            $(".denglu").show();



            //$(".denglu").css({"width": $(window).width(), "height": $(window).height()});
            //
            //
            //denglu.style.height = parseInt(getStyle(denglu, "height")) + 20 + "px";
            ////alert($(window).height());
            //alert($(window).width());
            //alert(1);
            $(window).resize(function () {
                //alert(1);
                //alert($(window).height());
                //alert($(window).width());
                var cliWidth = document.body.clientWidth; //浏览器宽var cliHeight=document . body. clientHeight;//浏览器高var divWidth=cliWidth-2 ;var  divHeight=cl iHeight-2;
                var cliHeight=document.body.clientHeight;
                var divWidth=cliWidth-2;
                var divHeight=cliHeight-2;
                $(".denglu").css("width",divWidth + "px");
                $(".denglu").css("height", divHeight + "px");
                //$(".dengluchuangkou").css("margin-left",(divWidth-550)/2 + "px");

                //alert($(window).height());
                //alert($(window).width());
            });
        });

    });

    $(function () {



    });


    //alert($(window).height());                           //浏览器当前窗口可视区域高度
    //alert($(document).height());

})