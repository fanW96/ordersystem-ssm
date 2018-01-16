<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@include file="top.jsp"%>
<link href="css/right.css" rel="stylesheet" type="text/css" />
<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
在线人数为：${countapp}个人
	<!-- top首页 开始 -->
	<TABLE height=28 cellSpacing=3 cellPadding=0 width=776 align=center
		background="zzjz/btmunu.gif" border=0>
		<TBODY>
			<TR vAlign=bottom>
				<TD>&nbsp;&nbsp;<A class=nav href="index.jsp">首页</A><FONT
					class=nav> &gt; </FONT><A class=nav
					href="ProductServlet?method=showProductList">商品展示</A></TD>
			</TR>
		</TBODY>
	</TABLE>
	<!-- top首页 结束 -->
	<TABLE height=1 cellSpacing=0 cellPadding=0 width=776 align=center
		bgColor=#cccccc border=0>
		<TBODY>
			<TR>
				<TD></TD>
			</TR>
		</TBODY>
	</TABLE>
	<!-- 下面大边框 开始 -->
	<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
		<TBODY>
			<TR>
				<TD vAlign=top width=195 background="zzjz/ny3.gif" bgColor=#ffffff
					height=186><%@include file="left.jsp"%></TD>
				<TD vAlign=top width=3 bgColor=#e8e8e8></TD>
				<TD vAlign=top bgColor=#ffffff height=300>
					<!-- 产品大框 开始 -->
					<table cellspacing="0" cellpadding="4" width="100%" align="center"
						border="0">
						<tbody>

							<tr>
								<td valign="top" width="100%">
									<!-- 产品 开始 -->  

										<table cellspacing="2" cellpadding="0" width="100%"
											bgcolor="#ffffff" border="0">
											<tbody>
											
			<c:forEach items="${list}" var ="p"   >
			
												<tr valign="top">
													<td align="middle" width="106" height="93"><a
														href="javascript:location.href='ProductServlet?methods=detail&pro_id=${p.product_id}'"><font
															color="#000000"> 
																
																
																
																<c:if test="${empty  p.picture}">
                <img src="assets/img/logo.png" style="BORDER-LEFT-COLOR: #000000; BORDER-BOTTOM-COLOR: #000000; BORDER-TOP-COLOR: #000000; BORDER-RIGHT-COLOR: #000000"
																height="65" hspace="0" width="70" align="center" border="0"/>
               </c:if>
                <c:if test="${not empty  p.picture}">
                <img src="upload/${p.picture}" style="BORDER-LEFT-COLOR: #000000; BORDER-BOTTOM-COLOR: #000000; BORDER-TOP-COLOR: #000000; BORDER-RIGHT-COLOR: #000000"
																height="65" hspace="0" width="70" align="center" border="0"
                onerror="this.src='assets/img/a5.png'"
                />
				</c:if>
																
																</font></a></td>
													<td height="93">
														<table cellspacing="1" cellpadding="4" width="100%"
															bgcolor="#cccccc" border="0">
															<tbody>
																<tr valign="top" align="right" bgcolor="#ffffff">
																	<td height="30">
																		<table height="28" cellspacing="1" cellpadding="4"
																			width="100%" bgcolor="#cccccc" border="0">
																			<tbody>
																				<tr bgcolor="#99ccff">
																					<td align="center" width="25%" bgcolor="#f0f0f0">产品名称</td>
																					<td width="25%" bgcolor="#ffffff"><font
																							color="#000000">${p.pro_name}</font></td>
																					<td align="center" width="25%" bgcolor="#f0f0f0">产品数量</td>
																					<td  width="25%" bgcolor="#ffffff"><font color="#ff0033">${p.pro_mount}</font></td>
																				</tr>
																				<tr  bgcolor="#99ccff">
																					<td align="center" width="25%" bgcolor="#f0f0f0">产品型号</td>
																					<td bgcolor="#ffffff" width="25%">${p.category.cate_id}</td>
																					<td align="center" width="25%" bgcolor="#f0f0f0">产品价格</td>
																					<td bgcolor="#ffffff" width="25%">${p.price}<font color="#ff0033">
																							</font>元</td>
																				</tr>
																			</tbody>

																		</table>


																	</td>
																</tr>

															</tbody>
														</table>
													</td>
												</tr>
			    
			</c:forEach>
 
											</tbody>

										</table>
									 <!-- 产品 结束 -->
								</td>
							</tr>

						<tr valign="bottom" align="right">
								<td colspan=3  width="100%">
								    总有${count}行&nbsp;当前是  ${gopage} /${pageNum}页

<a href="ProductServlet?methods=pro_page&gopage=1">首页</a>&nbsp;&nbsp;&nbsp;
<c:if test="${gopage==1&& gopage!=pageNum}">
上一页  <a href="ProductServlet?methods=pro_page&gopage=${gopage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
</c:if>

 <c:if test="${gopage!=1&& gopage!=pageNum}">
   <a href="ProductServlet?methods=pro_page&gopage=${gopage-1}">上一页</a>
   <a href="ProductServlet?methods=pro_page&gopage=${gopage+1}">下一页</a>
</c:if>

<c:if test="${gopage!=1&& gopage==pageNum}">
  <a href="ProductServlet?methods=pro_page&gopage=${gopage-1}">上一页</a>&nbsp;&nbsp;&nbsp;下一页&nbsp;&nbsp;&nbsp;
</c:if>
<a href="ProductServlet?methods=pro_page&gopage=${pageNum}">尾页</a>&nbsp;&nbsp;&nbsp;
								
								
								</td>
							</tr>
						</tbody>
					</table> <!-- 产品大框 开始 -->
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	<!-- 下面大边框 开始 -->
	<%@ include file="bottom.jsp"%>
</BODY>
</HTML>
