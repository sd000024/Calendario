<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%> 
<fmt:setBundle basename="web" />

<nav
	class="navbar nav-pills navbar-expand-lg navbar-dark bg-dark row justify-content-between mx-0">
	<div class="container">
		<div class="col-12 col-lg-4 d-flex justify-content-between">
			<a class="navbar-brand d-flex justify-content-center" href="/"> <img
				src="<c:url value='/img/logo.png'/>" height="50"
				class="d-inline-block align-text-top">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbar"
				aria-controls="navbar" aria-expanded="false">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse col-lg-8 row my-2" id="navbar">
			<ul class="navbar-nav mb-2 col-lg-6">
			
						<li class="nav-item"><a
							href='<s:url value="/"/>'
							class="nav-link text-white text-center"><svg
									xmlns="http://www.w3.org/2000/svg" fill="currentColor"
									class="bi d-block mx-auto mb-1" width="24" height="24"
									viewBox="0 0 16 16">
								<path
										d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z" /></svg>
								<fmt:message key='web.Calendario.lista' /> </a>
							</li>
					<sec:authorize access="isAuthenticated()">
							<li class="nav-item"><a href="/calendario/crea"
								class="nav-link text-white text-center"><svg
										xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										fill="currentColor" class="bi d-block mx-auto mb-1"
										viewBox="0 0 16 16">
								<path
											d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z" />
								
								<path
											d="M8 4a.5.5 0 0 1 .5.5V6H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V7H6a.5.5 0 0 1 0-1h1.5V4.5A.5.5 0 0 1 8 4z" /></svg>
									<fmt:message key='web.Calendario.creaTarea' /> </a>
							</li>
				</sec:authorize>
			</ul>

			<sec:authorize access="not isAuthenticated()">
				<div class="text-end col-lg-6 d-flex justify-content-center">
					<a role="button" class="btn btn-outline-light me-2" href="/login">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-box-arrow-in-right"
							viewBox="0 0 16 16">  <path fill-rule="evenodd"
								d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z" /> 
								<path fill-rule="evenodd"
								d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" /></svg>
						<fmt:message key='web.calendario.login' />
					</a> <a role="button" class="btn btn-primary" href="/usuario/crea">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-person-plus-fill"
							viewBox="0 0 16 16">
						<path
								d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"></path>
						<path fill-rule="evenodd"
								d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"></path></svg>
						<fmt:message key='web.calendario.registro' />
					</a>
				</div>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="px-3 py-2 col-lg-6">
					<div class="container d-flex justify-content-center bd-highlight text-white">
						<c:url value='/logout' var="logout_url" />
						<form:form action="${logout_url}" method="POST" class="mt-2"
						id="logout"> 
							<p id="username">
								<sec:authentication property="principal.username" />
								<button class="btn btn-link text-white" >
									<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
										fill="currentColor" class="bi bi-box-arrow-in-right" 
 										viewBox="0 0 16 16"> 
							<path fill-rule="evenodd"
											d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"></path>
							<path fill-rule="evenodd"
											d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"></path></svg>
								</button>
							</p>
						</form:form>
			</sec:authorize>
		</div>
	</div>
</nav>