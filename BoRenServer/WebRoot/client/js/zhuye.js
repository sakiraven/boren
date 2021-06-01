/**
 * Created by 清和爸比 on 2019/4/9.
 */



$(function () {

    var tiezigaodu = parseInt($(".tiezi").height());
    $(".zhutishang").height(tiezigaodu);
    var gaodu = tiezigaodu + 410;
    //$(".fenlei").top(365);
    $(".fenlei").css("top", gaodu);
    $(".huati").click(function () {
        $(".fenlei").toggle();
    });




    //if (ss=(bb)) {
    //    $(".caixidingwei").css("width",390);
    //}else{
    //    $(".caixidingwei").weight(373);
    //}

    //var rushukuang=$(".fabiaokuang").attr("top");


    /*  var res=$(".fabiaokuang").text();*/
    //var int = Math.round(length*Math.pow(10,4));
    //alert(int)


    //var wenben=$(".fabiao").height();
    ////alert(wenben)
    //if(rushukuang<wenben){
    //     $(".fabiaokuang").show();
    //}


    //
    //
    //$(".fabiaokuang").keyup(function() {
    //    var len = 0;
    //    var str = $(".fabiaokuang").val();
    //    var index = 0;
    //    var count = 0;
    //    for(;index<str.length;){
    //        if(str.indexOf("\n",index)!=-1){
    //            index = str.indexOf("\n",index)+1;
    //            count++;
    //        }else{
    //            index++;
    //        }
    //    }
    //
    //    for (var i = 0; i < str.length; i++) {
    //        var c = str.charCodeAt(i);
    //        //单字节加1
    //        if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f)) {
    //            len++;
    //        }
    //        else {
    //            len += 2;
    //        }
    //    };
    //
    //    if(len>407||count>7){
    //        $(".fabiaokuang").css("overflow-y","auto");
    //
    //
    //    }else{
    //        $(".fabiaokuang").css("overflow-y","hidden");
    //    };
    //
    //
    //});
})