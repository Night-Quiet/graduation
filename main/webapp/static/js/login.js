/**
 * @func: 更改登录、注册这两个div的样式，做到一次只显示一个
 */
window.onload = function(){
    var item = document.getElementsByClassName("item"),
        it = item[0].getElementsByTagName("div"),
        content = document.getElementsByClassName("content"),
        con = content[0].getElementsByTagName("div");

    for(let i=0;i<it.length;i++) {
        it[i].onclick = function() {
            for(let j=0;j<it.length;j++) {
                it[j].className = '';
                con[j].style.display = "none";
                con[i].style.cursor = "pointer";
            }
            this.className = "active";
            it[i].index=i;
            con[i].style.display = "block";
            con[i].style.cursor = "default";
        }
    }
}
