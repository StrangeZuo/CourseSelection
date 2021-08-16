<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新增</title>
		<link rel="stylesheet"  href="${pageContext.request.contextPath }/css/styles.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script src="${pageContext.request.contextPath }/js/jquery-3.5.1.min.js" type="text/javascript"></script>
	</head>
	<body>
		<div class="add">
			<form action="student?method=add" method="post">
				<table class="tableadd" style="width: 50%;">
					<tr>
						<td>学号</td>
						<td><input type="text" name="stuNo"></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="stuName"></td>
					</tr>
					<tr>
						<td>密码</td>
						<td>
							<input type="password" name="stuPwd" value="stuPwd">
							学生初始密码为123456
						</td>
					</tr>
					<tr>
						<td colspan="4" align="left">
							<button class="edit" type="button" onclick="window.history.back(-1)">
								<i class="fa fa-arrow-left"></i>
								返回
							</button>
							<button class="remove" type="submit">
								<i class="fa fa-save"></i>
								提交
							</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
