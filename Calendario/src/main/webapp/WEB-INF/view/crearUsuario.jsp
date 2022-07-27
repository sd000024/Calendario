<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
<title><fmt:message key="web.usuario.title" /></title>
</head>
<body>
	<cus:cabecera />

	<div class="container my-5">
		<div class="card shadow-sm mx-auto" style="max-width: 414px;">
			<div class="card-header text-center">
				<c:if test="${errorpass != null}">
					<p class="alert alert-danger">${errorpass}</p>
				</c:if>
				<h3>
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi bi-person-plus-fill"
						viewBox="0 0 16 16">
						<path
							d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
						<path fill-rule="evenodd"
							d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z" /></svg>
					<fmt:message key="web.usuario.titulo" />
				</h3>
			</div>
			<form:form class="card-body text-center" action="/usuario/crea"
				method="POST" modelAttribute="usuario">
				<div class="mb-3">
					<label for="username" class="form-label lead"> <svg
							xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16"> <path
								d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" /></svg>
						<b><fmt:message key="web.usuario.user" /></b>
					</label>
					<s:bind path="username">
						<form:input path="username" placeholder="nombre"
							class="form-control ${status.error?'is-invalid':''} " />
						<form:errors path="username" cssClass="invalid-feedback"
							element="span" />
					</s:bind>
				</div>

				<div class="mb-3">
					<label for="password" class="form-label lead"> <svg
							xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
							<path
								d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z" /></svg>
						<b><fmt:message key='web.login.pass' /></b>
					</label>
					<s:bind path="password">
						<form:input type="password" path="password" placeholder="password"
							class="form-control ${status.error?'is-invalid':''} " />
						<form:errors path="password" cssClass="invalid-feedback"
							element="span" />
					</s:bind>
				</div>

				<div class="mb-3">
					<label for="passwordConfirm" class="form-label lead"> <svg
							xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
							<path
								d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z" /></svg>
						<b><fmt:message key='web.login.passconfirm' /></b>
					</label>
					<s:bind path="passwordConfirm">
						<form:input type="password" path="passwordConfirm"
							class="form-control ${status.error ? 'is-invalid':''}"
							placeholder="Confirm your password"></form:input>
						<form:errors path="passwordConfirm" cssClass="invalid-feedback"
							element="span"></form:errors>
					</s:bind>
				</div>
				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-primary">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-person-plus-fill"
							viewBox="0 0 16 16">
						<path
								d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
						<path fill-rule="evenodd"
								d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z" /></svg>
						Crea Usuario
					</button>
				</div>
			</form:form>
		</div>
	</div>

	<%@include file="../componentes/footer.jspf"%>
</body>
</html>