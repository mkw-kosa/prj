<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원 목록</h1>
<a href="<c:url value='/hr/insert'/>"/>신규 사원 정보 입력</a>
<table border="1">
<tr>
	<th>employee_id</th>
	<th>first_name</th>
	<th>last_name</th>
	<th>email</th>
	<th>phone_number</th>
	<th>hire_date</th>
	<th>job_id</th>
	<th>salary</th>
	<th>commission_pct</th>
	<th>manager_id</th>
	<th>department_id</th>
</tr>
<c:forEach var="emp" items="${empList}">
<tr>
	<td><a href="<c:url value='/hr/${emp.employeeId }'/>">${emp.employeeId }</a></td>
	<td>${emp.firstName }</td>
	<td>${emp.lastName }</td>
	<td>${emp.email }</td>
	<td>${emp.phoneNumber }</td>
	<td>${emp.hireDate }</td>
	<td>${emp.jobId }</td>
	<td>${emp.salary }</td>
	<td>${emp.commissionPct }</td>
	<td>${emp.managerId }</td>
	<td>${emp.departmentId }</td>
</tr>
</c:forEach>
</table>
<!-- ${empList} -->
</body>
</html>