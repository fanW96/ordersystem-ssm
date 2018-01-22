<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head><base href="<%=basePath%>" />
<link href="css/right.css" rel="stylesheet" type="text/css" />
</head>
<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
	<%@ include file="top.jsp"%>
	<TABLE height=28 cellSpacing=3 cellPadding=0 width=776 align=center
		background=zjej/btmunu.gif border=0>
		<TBODY>
			<TR vAlign=bottom>
				<TD>&nbsp;&nbsp;<A class=nav href="index.jsp">首页</A><FONT
					class=nav> &gt; </FONT><A class=nav
					href="ProductServlet?method=showProductList">商品展示</A><FONT
					class=nav> &gt; </FONT>商品信息
				</TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE height=1 cellSpacing=0 cellPadding=0 width=776 align=center
		bgColor=#cccccc border=0>
		<TBODY>
			<TR>
				<TD></TD>
			</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
		<TBODY>
			<TR>
				<TD vAlign=top width=195 background=zjej/ny3.gif bgColor=#ffffff
					height=186><%@include file="left.jsp"%></TD>
				<TD vAlign=top width=3 bgColor=#e8e8e8></TD>
				<td valign="top" bgcolor="#ffffff" height="300">
					<table cellspacing="0" cellpadding="0" width="100%" align="center"
						border="0">
						<tbody>
							<tr valign="top">
								<td>
									<table cellspacing="5" cellpadding="3" width="100%"
										bgcolor="#ffffff" border="0">
										<tbody>

											<tr>
												<td valign="top" align="middle" width="150" height="100"><font
													color="#000000"><img
														style="BORDER-LEFT-COLOR: #000000; BORDER-BOTTOM-COLOR: #000000; BORDER-TOP-COLOR: #000000; BORDER-RIGHT-COLOR: #000000"
														height="83" hspace="0"
														src="upload/<s:property value="product.picture"/>" width="86"
														align="default" border="0" /></font></td>
												<td height="100" valign="top">
													<table height="100%" cellspacing="3" cellpadding="0"
														width="100%" border="0">
														<tbody>

															<tr valign="top">
																<td align="right">
																	<table cellspacing="1" cellpadding="3" width="100%"
																		bgcolor="#cccccc" border="0">
																		<tbody>
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品编号</td>
																				<td style="PADDING-LEFT: 10px"><s:property value="product.pid"/> </td>
																			</tr>
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品名称</td>
																				<td style="PADDING-LEFT: 10px"><s:property value="product.pname"/></td>
																			</tr>
																			 
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品类型</td>
																				<td style="PADDING-LEFT: 10px"><s:property value="product.category.description"/></td>
																			</tr>
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品单价</td>
																				<td style="PADDING-LEFT: 10px"><s:property value="product.price"/></td>
																			</tr>
																			<tr valign="top" bgcolor="#ffffff">
																				<td align="middle" width="90" bgcolor="#f0f0f0">产品库存</td>
																				<td style="PADDING-LEFT: 10px"><s:property value="product.mount"/></td>
																			</tr>

																		</tbody>
																	</table>
																	<img src="image/cart.jpg" onclick="javascript:location.href='OrderServlet?methods=increasedOrders&pro_id=${requestScope.pro_info.product_id}'" width="100px" height=40px/>
																	<table cellspacing="2" cellpadding="0" width="100%"
																		border="0">
																		<tbody>
																			<tr valign="top">
																				<td background="商务信息网站套餐.files/line.gif" height="4"></td>
																			</tr>
																		</tbody>
																	</table>
																</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</TR>
		</TBODY>
	</TABLE>
	<%@include file="bottom.jsp"%>

</BODY>
</HTML>


