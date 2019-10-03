<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<form:form method="POST" modelAttribute="userObject" action="userSignIn.do">
<table>
	<tr>
		<td>
			<div>
				<p><spring:message code="form.registration.Username" /></p><form:input path="email" />
			</div>
		</td>
		<td><form:errors path="email" class="label error-label"></form:errors></td>
		
	</tr>
	
	<tr>
		<td>
			<div>
				<p><spring:message code="form.registration.Password" /></p><form:password path="password" />
			</div>
		</td>
	</tr>
	
	<tr>
        <td colspan="2"><input type="submit" value="Submit" /></td>
    </tr>
	
</table>
</form:form>
</body>
</html>