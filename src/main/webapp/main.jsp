<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=basePath%></title>
</head>
<body>
	list dept 
	 <br><br>
	 <hr>
	 <c:if test="${deleteResult==true}">
	 <div>${dname}该用户已删除</div>
	 </c:if>
	 
	 <hr><form action="DeptServlet" method="post">
	 <input type="hidden" name="methods" value="deleteAll"/>
		<table>
		<tr>
			<th>部门编号</th>
			<th>部门名称</th>
			<th>部门地址</th>
			<th>部门操作</th>
		</tr>
		
		<c:forEach items="${depts}" var="d">
			<tr>
				<td><input type="checkbox" name="nums" value="${d.deptNo}">${d.deptNo}</td>
				<td>${d.dname}</td>
				<td>${d.loc}</td>
				<td><a href="DeptServlet?methods=delete&deptNo=${d.deptNo}&dname=${d.dname}">删除</a>
				&nbsp;
				<a href="DeptServlet?methods=showDeptByDeptNo&deptNo=${d.deptNo}">修改</a>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	<input type="submit" value="批量删除"/>
		</form>
</body>
</html>