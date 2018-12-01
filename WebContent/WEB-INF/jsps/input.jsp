<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加员工</title>
</head>
<body>
	<h3>${command.id !=null ? '修改员工信息' : '增加员工'}</h3>
	<form:form action="../emp" method="post" modelAttribute="command">
		<c:if test="${command.id != null }">
			<input type="hidden" name="_method" value="put">
			<form:hidden path="id"/>
		</c:if>
		<table>
			<tr>
				<td>NAME</td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><form:input path="mail"/></td>
			</tr>
			<c:if test="${command.id == null }">
				<tr>
					<td>GENDER</td>
					<td><form:radiobuttons path="gender" items="${requestScope.genders }"></form:radiobuttons></td>
				</tr>
			</c:if>
			<tr>
				<td>DEPARTMENT</td>
				<td>
					<form:select path="dept.deptId" items="${requestScope.depts}" itemLabel="deptName" itemValue="deptId">
					</form:select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="${command.id !=null ? 'UPDATE' : 'ADD' }"></td>
			</tr>
		</table>		
	</form:form>
</body>
</html>