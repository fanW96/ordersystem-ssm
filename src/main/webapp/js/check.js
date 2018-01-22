function checkLogin() {
    var flag = true;
    var uName = document.getElementById("username").value;
    var uPwd = document.getElementById("password").value;
    //用户名正则，4到16位（字母，数字，下划线，减号）
    var namerx = /^[a-zA-Z0-9_-]{4,16}$/;
    //密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
    var pwdrx = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
    if(!namerx.exec(uName)){
        flag = false;
        alert("用户名格式错误：4到16位（字母，数字，下划线，减号）")
    }else if (!pwdrx.exec(uPwd)){
        flag = false;
        alert("密码格式错误：最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符")
    }
    return flag;
}

function checkRegister() {
    var flag = true;
    var uMail = document.getElementById("email").value;
    var uName = document.getElementById("username").value;
    var uPwd = document.getElementById("pwd").value;
    var uRePwd = document.getElementById("repwd").value;
    var readMe = document.getElementById("remember-me");
    var mailP = document.getElementById("mailP");
    var nameP = document.getElementById("nameP");
    var pwdP = document.getElementById("pwdP");
    var pwdCheckP = document.getElementById("pwdCheckP");
    //用户名正则，4到16位（字母，数字，下划线，减号）
    var namerx = /^[a-zA-Z0-9_-]{4,16}$/;
    //密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
    var pwdrx = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
    //邮箱格式正则
    var mailrx = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
    if(!mailrx.exec(uMail)){
        flag = false;
        mailP.style.display ='block'
    }else{
        mailP.style.display ='none'
    }
    if(!namerx.exec(uName)){
        flag = false;
        nameP.style.display ='block'
    }else{
        nameP.style.display ='none'
    }
    if (!pwdrx.exec(uPwd)){
        flag = false;
        pwdP.style.display ='block'
    }else{
        pwdP.style.display ='none'
    }
    if(uPwd != uRePwd){
        flag =false;
        pwdCheckP.style.display ='block'
    }else{
        pwdCheckP.style.display ='none'
    }
    if(!readMe.checked){
        flag = false;
        alert("请确定你已经阅读了相关事项")
    }
    return flag;
}

function checkIncrease() {
    var name = document.getElementById("product.name").value;
    var price = document.getElementById("product.price").value;
    var num = document.getElementById("product.num").value;
    var cate = document.getElementById("product.cate");
    var obj_index = cate.selectedIndex;
    var cate_id = cate.options[obj_index].value;
    if(name == "" || price =="" || num=="" || cate_id==-1){
        alert("打*的都必须填写");
        return false;
    }
    return true;
}