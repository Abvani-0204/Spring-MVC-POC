<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
</head>
<body>

	<a href="?language=en_US">Enलglish</a>|
	<a href="?language=zh_CN">Chinese</a>|
	<a href="?language=hi_IN">Hindi</a>
	
	<form:form method="POST" modelAttribute="userObjectR" action="ShowRegistration.do">
		<table>
			<tr>
				<td>
					<div>
					<p><spring:message code="form.registration.firstname"/></p>
						<form:input path="firstname" />
					</div>
				</td>
			<td><form:errors path="firstname" class="label error-label"></form:errors></td> 
			</tr>
			<tr>
			
			
			नाम
				<td>
					<div>
						<p><spring:message code="form.registration.lastname"/></p>
						<form:input path="lastname" />
					</div>
				</td>
		 		<td><form:errors path="lastname" class="label error-label"></form:errors></td>
		</tr>
			<tr>
				<td>
					<div>
						<p><spring:message code="form.registration.contact"/></p>
						<form:input path="contact" />
					</div>
				</td>
			<td><form:errors path="contact" class="label error-label"></form:errors></td>
	 		</tr>

			<tr>
				<td>
					<div>
						<p><spring:message code="form.registration.Username"/></p>
						<form:input path="email" />
					</div>
				</td>
		 		<td><form:errors path="email" class="label error-label"></form:errors></td>
		 	</tr>

			<tr>
				<td>
					<div>
						<p><spring:message code="form.registration.Password"/></p>
						<form:password path="password" />
					</div>
				</td>
				<td><form:errors path="password" class="label error-label"></form:errors></td>
 			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>