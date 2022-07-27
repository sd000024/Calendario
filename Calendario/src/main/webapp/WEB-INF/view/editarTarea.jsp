<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>Edita Tarea</title>
</head>
<body>
	<cus:cabecera/>

	<div class="container my-5">
		<form:form class="card shadow-sm text-center"
			action="/${id}/editaTarea" method="POST" modelAttribute="tarea">
			<div class="card-header">
				<c:if test="${errortarea != null}">
					<p class="alert alert-danger">${errortarea}</p>
				</c:if>
				<h2>
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi bi-bookmark-plus"
						viewBox="0 0 16 16">
						<path
							d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
						
						<path
							d="M8 4a.5.5 0 0 1 .5.5V6H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V7H6a.5.5 0 0 1 0-1h1.5V4.5A.5.5 0 0 1 8 4z" /></svg>
					Edita la Tarea
				</h2>
			</div>

			<div class="card-body">
			
			<div class="mb-3">
					<label for="id" class="form-label lead"> ID de Tarea</label>
					<s:bind path="id">
						<form:input path="id"
							class="form-control ${status.error?'is-invalid':''} " 
							 value="${tarea.id }"  type="number" readonly="true" />
						<form:errors path="titulo" cssClass="invalid-feedback"
							element="span" />
					</s:bind>
				<div class="mb-3">
					<label for="titulo" class="form-label lead"> <svg
							xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-card-heading"
							viewBox="0 0 16 16">path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/> <path
								d="M3 8.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5zm0-5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5v-1z" /></svg>
						<b>Titulo</b></label>
					<s:bind path="titulo">
						<form:input path="titulo" placeholder="titulo"
							class="form-control ${status.error?'is-invalid':''} "  value="${tarea.titulo }"/>
						<form:errors path="titulo" cssClass="invalid-feedback"
							element="span" />
					</s:bind>
				</div>
				<div class="mb-3">
					<label for="descripcion" class="form-label lead"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-card-text" viewBox="0 0 16 16">
							<path
								d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z" />
							
							<path
								d="M3 5.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 8zm0 2.5a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5z" /></svg>
						<b>Descripcion</b></label>
					<s:bind path="descripcion">
						<form:textarea path="descripcion" placeholder="descripcion"
							class="form-control ${status.error?'is-invalid':''} " value="${tarea.descripcion }"/>
						<form:errors path="descripcion" cssClass="invalid-feedback"
							element="span" />
					</s:bind>
				</div>
				
				<div class="mb-3">
					<label for="lugar" class="form-label lead"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-card-text" viewBox="0 0 16 16">
							<path
								d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z" />
							
							<path
								d="M3 5.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3 8a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9A.5.5 0 0 1 3 8zm0 2.5a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5z" /></svg>
						<b>Lugar</b></label>
					<s:bind path="descripcion">
						<form:input path="lugar" type="text" class="form-control ${status.error?'is-invalid':''} " value="${tarea.lugar }"/>
						<form:errors path="lugar" cssClass="invalid-feedback"
							element="span" />
					</s:bind>
				</div>
				<div class="mb-3">
					<label for="fechaHora" class="form-label lead"> <svg
							xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-calendar-event"
							viewBox="0 0 16 16">
							<path
								d="M11 6.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1z" />
							
							<path
								d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z" /></svg>
						<b>Fecha y hora</b>
					</label>
					<s:bind path="fechaHora">
						<form:input path="fechaHora" type="datetime-local"
							class="form-control ${status.error?'is-invalid':''}" value="${tarea.fechaHora }" />
						<form:errors cssClass='invalid-feedback' path="fechaHora" />
					</s:bind>
				</div>
				<div class="mb-3">
					<label for="duracion" class="form-label lead"> <svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-clock" viewBox="0 0 16 16">
							<path
								d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z" />
							
							<path
								d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z" /></svg>
						<b>Duración de Tarea</b>
					</label>
					<s:bind path="duracion">
						<form:input type="number" path="duracion"
							placeholder="${placeholder}"
							class="form-control ${status.error?'is-invalid':''} " value="${tarea.duracion }" />
						<form:errors path="duracion" cssClass="invalid-feedback"
							element="span" />
					</s:bind>
				</div>
			</div>

			<div class="card-footer">
				<div class="d-grid gap-2 col-6 mx-auto">
					<button type="submit" class="btn btn-success">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
					  		<path
								d="M8 0a1 1 0 0 1 1 1v6h6a1 1 0 1 1 0 2H9v6a1 1 0 1 1-2 0V9H1a1 1 0 0 1 0-2h6V1a1 1 0 0 1 1-1z"></path>
				  		</svg>
						Edita Tarea
					</button>
				</div>
			</div>
		</form:form>
	</div>

	<%@include file="../componentes/footer.jspf"%>
</body>
</html>