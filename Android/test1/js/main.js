/**
 * Created by dell-pc on 2017/2/6.
 */
var oUl = document.getElementsByTagName("ul")[0];
var oBtn = document.getElementsByClassName("btn");
var html = ' ';
var remove = [];//定义一个数组保存被选中图片的索引
for (var i = 1; i <= 16; i++) {
    html += "<li style='background-image: url(images/" + i + ".jpg)';></li>";
}
oUl.innerHTML = html;
//把for循环生成的16个li添加到ul中
var aLi = oUl.getElementsByTagName("li");
position();
//封装一个定位的方法
function position() {
    for (var i = 0; i < aLi.length; i++) {
        aLi[i].style.left = i % 3 + "rem";
        aLi[i].style.top = Math.floor(i / 3) + "rem";
    }
}
//点击选择按钮
oBtn[0].addEventListener("touchend", reMove, false);//监听事件
oBtn[1].addEventListener("touchend", fnClick, false);
var mark = true;
function fnClick() {
    if (mark) {
        this.innerHTML = "取消";
        //给每个li绑定点击事件，选择图片
        for (var i = 0; i < aLi.length; i++) {
            aLi[i].index = i;//给每个Li添加索引
            aLi[i].onOff = true;//添加一个自定义属性做开关
            aLi[i].addEventListener("touchend", fnSec, false);
        }
    } else {
        this.innerHTML = "选择";
        oBtn[0].style.display = "none";
        //当点击取消按钮不能再选择图片 所以取消Li的事件监听
        for (var i = 0; i < aLi.length; i++) {
            aLi[i].removeEventListener("touchend", fnSec, false);
            aLi[i].style.opacity = 1;
        }
        remove.length = 0;
    }
    mark = !mark;//取反
}
//选择图片
function fnSec() {
    if (this.onOff) {
        this.style.opacity = 0.5;
        this.onOff = false;
        oBtn[0].style.display = "block";
        //把选中的图片序列号添加到remove数组中
        remove.push(this.index);
        console.log(remove);

    } else {
        this.style.opacity = 1;
        this.onOff = true;
        for (var i = 0; i < remove.length; i++) {
            if (remove[i] == this.index) {
                remove.splice(i, 1);//删除i下标位置的数组元素 1指删除一个
            }
        }
        if(remove.length==0){
            oBtn[0].style.display = "none";
        }
    }

}
//删除图片
function reMove() {
    //console.log(remove);
    /*  for (var i=0;i<remove.length;i++){
     //remove.pop()删除数组的最后一个值并返回
     //删除子节点
     oUl.removeChild(aLi[remove.pop()]);
     }*/
    //对数组进行排序，保证从序列号大的Li依次删除
    remove = remove.sort(function (a, b) {
        return a - b;
    });
    //console.log(remove);
    while (remove.length) {//remove.length==0
        oUl.removeChild(aLi[remove.pop()]);
    }
    oBtn[0].style.display = "none";
    oBtn[1].innerHTML = "选择";
    position();
    mark = false;
    fnClick();
}

/*
 0 1 2 Math.floor(i/3)向下取整 0
 3 4 5 Math.floor(i/3)向下取整 1
 */
