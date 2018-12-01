<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示员工信息</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		$('.delete').click(function(){
			$('#translatetodelete').attr('action',$('.delete').attr('href')).submit();
			return false;
		})
	})
</script>
</head>
<body>
	<c:if test="${empty requestScope.emps }">
		<h3 align="center">NO EMPLOYEES</h3>
	</c:if>
	<c:if test="${!empty requestScope.emps}">
		<h3 align="center">The Employees List</h3>
		<table width="500px" border="1" align="center">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>MAIL</td>
				<td>GENDER</td>
				<td>DEPTNAME</td>
				<td>DELETE</td>
				<td>UPDATE</td>
			</tr>
			<c:forEach items="${requestScope.emps }" var="emp">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.name }</td>
				<td>${emp.mail }</td>
				<td>${emp.gender == 0? 'MALE':'FEMALE'}</td>
				<td>${emp.dept.deptName }</td>
				<td><a href="emp/${emp.id}" class="delete">DELETE<a></td>
				<td><a href="input/${emp.id}">UPDATE</a></td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
	<!-- 处理请求方式 为DELETE -->
	<form action="" method="post" id="translatetodelete">
		<input type="hidden" name="_method" value="delete"/>
	</form>
	
</body>
</html>