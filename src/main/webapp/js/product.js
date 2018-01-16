function editProduct(id,state){
	//根据id 把当前的状态改为相反的状态
	var mes="";
	if(state==0){
		mes="上架";
		state=1;
	}else{
		mes="下架";
		state=0;
	}
	//去一个servlet处理修改操作
	if(confirm("你确定"+mes+"吗？")){
		window.location.href="ProductServlet?methods=editState&id="+id+"&state="+state;
	}
	
	//拼接字符串带走两个值
	
}


function subSeo(){
	//alert("xxx");
	document.seoFRM.submit();
}