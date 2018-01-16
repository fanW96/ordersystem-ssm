//防止重复提交
  var isCommitted = false;//表单是否已经提交标识，默认为false
         function dosubmit(){
            if(isCommitted==false){
                 isCommitted = true;//提交表单后，将表单是否已经提交标识设置为true
                 return true;//返回true让表单正常提交
             }else{
                 return false;//返回false那么表单将不提交
             }
         }
    
function login(){
	if(loginCheckUname()&&loginCheckUpwd()){
		if(dosubmit()){
		document.loginFrm.submit(); 
		}
	}	
}
function loginCheckUname(){
	 var uname= document.loginFrm.uname.value;
		if(uname.length==0||uname==""||uname==null){
		   document.getElementById("unameSpan").innerHTML="用户名称为空";
		   return false;
		}else{
			return true;
		}
	}
function loginSpanUname(){
	  document.getElementById("unameSpan").innerHTML="";
}
function loginCheckUpwd(){
	 var upwd= document.loginFrm.upwd.value;
	 var reg=/^\d{6}$/;
		if(upwd.length==0||upwd==""||upwd==null){
		   document.getElementById("upwdSpan").innerHTML="用户密码为空";
		   return false;
		}else if(!reg.test(upwd)){
			  document.getElementById("upwdSpan").innerHTML="用户密码长度不是六位";
			   return false;
		}else{
			return true;
		}
		
}



