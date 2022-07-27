<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cus"%>
<fmt:setBundle basename="web" />

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<%@include file="/WEB-INF/componentes/bootstrapheader.jspf"%>
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>"
	type="image/x-icon" />
<title><fmt:message key="web.login.title" /></title>
</head>
<body>
	<cus:cabecera />

	<div class="container my-5" style="max-width: 414px;">
		<c:if test="${param.error != null}">
			<p class="alert alert-danger"><fmt:message key="web.login.error" /></p>
		</c:if>
		<form:form class="form-signin card d-flex justify-content-center"
			action="/login" method="POST">
			<div class="card-header">
				<h1 class="h3 mt-2 font-weight-normal text-center">
					<img src="https://image.flaticon.com/icons/png/512/64/64572.png"
						alt="" width="40" height="40">
					<fmt:message key="web.login.title" />
				</h1>
			</div>
			<div class="card-body text-center">
				<div class="my-3">
					<label for="username" class="h4 text-center"> <svg
							xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							fill="currentColor" class="bi bi-person-fill pl-0"
							viewBox="0 0 16 16"> <path
								d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path></svg>
						<fmt:message key="web.login.email" />
					</label>
					<div class="mb-3">
						<input type="text" id="username" name="username"
							class="form-control"
							placeholder="<fmt:message key='web.login.email'/>" required>
					</div>

					<label for="password" class="h4 text-center"> <svg
							xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
							<path
								d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z" /></svg>
						<fmt:message key='web.login.pass' />
					</label>
					<div class="mb-3">
						<input type="password" id="password" name="password"
							class="form-control"
							placeholder="<fmt:message key='web.login.pass'/>" required>
					</div>
				</div>

				<div class="d-grid gap-2">
					<button class="btn btn-primary mt-3" type="submit">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-box-arrow-in-right"
							viewBox="0 0 16 16">  <path fill-rule="evenodd"
								d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z" /> 
								<path fill-rule="evenodd"
								d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" /></svg>
						<fmt:message key='web.login.title' />
					</button>
				</div>
			</div>
		</form:form>
	</div>

	<%@include file="../componentes/footer.jspf"%>
</body>
</html>