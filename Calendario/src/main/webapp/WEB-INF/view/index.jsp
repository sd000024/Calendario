<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%> 
	
<%@ taglib tagdir="/WEB-INF/tags" prefix="cus"%>

	
<fmt:setBundle basename="web" />

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>"
	type="image/x-icon" />
<%@include file="/WEB-INF/componentes/bootstrapheader.jspf"%>
<title><fmt:message key="web.inicio.title" /></title>
</head>
<body>
	<cus:cabecera />
	<div class="container my-5">
		<c:choose>
		  <c:when test="${aBorar!=null}">
			<div class="text-center">
				<p class="alert alert-danger">${aBorar}</p>
			</div>
		  </c:when>
		  <c:when test="${borrado!=null}">
			<div class="text-center" id="borrado">
				<p class="alert alert-success">${borrado}</p>
			</div>
		  </c:when>
		  <c:when test="${aEditar!=null}">
			<div class="text-center">
				<p class="alert alert-danger">${aEditar}</p>
			</div>
		  </c:when>
		  <c:when test="${editado!=null}">
			<div class="text-center">
				<p class="alert alert-success">${editado}</p>
			</div>
		  </c:when>
		   <c:when test="${error!=null}">
			<div class="text-center">
				<p class="alert alert-danger">${error}</p>
			</div>
			</c:when>
		  <c:when test="${CuentaCreada!=null}">
			<div class="text-center">
				<p class="alert alert-success " id="CuentaCreada">${CuentaCreada}</p>
			</div>
		  </c:when>
		  <c:otherwise>
		  </c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${empty tareas}">
				<div class="text-center">
					<span class="text-muted fs-2">No Existe Tareas</span>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach var="t" items="${tareas}">
					<div class="card shadow-sm mb-3">
						<fmt:parseDate value="${t.fechaHora}" pattern="yyyy-MM-dd'T'HH:mm"
								var="parsedDate" type="date" />
						<div class="row g-0  align-items-center">
							<div class="col-md-4 text-center align-middle my-4">
								<h3>
									<fmt:formatDate value="${parsedDate}" type="date" pattern="dd" />
								</h3>
								<p class="lead my-0">
									<fmt:formatDate value="${parsedDate}" type="date" pattern="MMMM" />
									de
									<fmt:formatDate value="${parsedDate}" type="date" pattern="yyyy" />
								</p>
								<p class="lead text-info">
									<fmt:formatDate value="${parsedDate}" type="date" pattern="HH:mm" />
								</p>
								<span class="fs-6 lead text-muted">Se dura por <span
									class="badge rounded-pill bg-secondary"> ${t.duracion}</span><span> horas</span></span>
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">${ t.titulo }</h5>
									<p class="card-text">${ t.descripcion }</p>
									<div class="d-grid gap-2">
										<sec:authorize access="isAuthenticated()">
											<a role="button" class="btn btn-outline-warning" href="/${t.id}/editaTarea">
													<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
													  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
													  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
													</svg>
												<fmt:message key="web.Calendario.editTarea"/></a>
										
											<a role="button" class="btn btn-outline-danger" href="/${t.id}/cancelarTarea" >
												<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
													fill="currentColor" class="bi bi-trash-fill"
													viewBox="0 0 16 16"> <path
														d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z" /></svg>
												<fmt:message key="web.Calendario.cancelaTarea"/>
											</a>
										</sec:authorize>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>

	<%@include file="/WEB-INF/componentes/footer.jspf"%>
</body>
</html>