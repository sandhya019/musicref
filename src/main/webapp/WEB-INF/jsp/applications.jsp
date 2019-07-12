<%@page import="org.hibernate.validator.constraints.SafeHtml.Tag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Applications</title>
<style>
body {
	margin: 0;
}

.navbar {
	overflow: hidden;
	background-color: #333; /* 
  position: fixed;
  top: 0; */
}

.navbar td {/* 
	float: left;
	display: block; */
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	font-size: 17px;
}

.navbar td:hover {
	background: #ddd;
	color: black;
}

a {
	color: black;
}
</style>
</head>
<body>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<h2>
				Welcome ${pageContext.request.userPrincipal.name} | <a
					onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h2>

		</c:if>
		${check}
		<c:choose>
		<c:when test="${check}">
	<table align="center" class="navbar" width="100%">
		<tr>
			<td>Application Id</td>
			<td>Applicant name</td>
			<td>Qualification</td>
			<td>date of birth</td>
			<td>post applied</td>
			<td>specialization</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${applications}" var="application">
			<tr>
				<td>${application.getApplicationId()}</td>
				<td>${application.getApplicantName()}</td>
				<td>${application.getEducationalQualification()}</td>
				<td>${application.getDateOfBirth()}</td>
				<td>${application.getPostApplied()}</td>
				<td>${application.getSpecialization()}</td>
				<td><font color="white"><a
						href="accept?id=${application.getApplicationId()}">Accept </a> <a
						href="reject?id=${application.getApplicationId()}">Reject</a></font></td>
			</tr>
		</c:forEach>
		
	</table>
	</c:when>
	<c:otherwise>
	<h1>No Applications to display</h1>
	</c:otherwise>
	</c:choose>
</body>
</html>
<%-- <td>${application.}</td> --%>