<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원정보 삭제</h1>
${emp.employeeId }번 사원 ${emp.firstName } ${emp.lastName }의 정보를 삭제합니다.<p>
삭제 후 데이터는 복구할 수 없습니다.<p>
${emp.employeeId }번 사원의 이메일을 입력하세요.
<form action="./delete" method="post">
이메일 : <input type="text" name="email">
<input type="hidden" name="empid" value="${emp.employeeId }">
<input type="submit" value="삭제">
</form>
</body>
</html>