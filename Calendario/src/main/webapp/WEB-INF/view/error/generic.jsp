<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cus"%>
<fmt:setBundle basename="web" />

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<%@include file="/WEB-INF/componentes/bootstrapheader.jspf"%>
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
<title>Error</title>
</head>
<body>
	<cus:cabecera />

	<div class="container my-5">
		<h3 class="text-danger text-center">
		  <small class="text-muted"><fmt:message key="web.error.generico"/> </small> error<small class="text-muted">.</small>
		</h3>
	</div>


	<%@include file="../../componentes/footer.jspf"%>
</body>
</html>