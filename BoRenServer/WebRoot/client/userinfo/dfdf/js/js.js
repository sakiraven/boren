/**
 * Created by 27101 on 2019/5/5.
 */


var box = document.getElementById("test")
var btn = document.getElementById("btn")
btn.onclick = function () {
    if (box.offsetLeft == 0) {
        box.style['margin-left'] = -300 + "px"
    } else {
        box.style['margin-left'] = 0 + "px"
    }
}

/*background-color: rgba(255, 255, 255, 0.3);*/

$("#meun li").click(function(){

        $(this).css("background-color","rgba(255, 255, 255, 0.3)").siblings().css("background-color","#336699");
    }
);