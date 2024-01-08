<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Biblioteca</title>

<base href="${pageContext.request.contextPath}/">

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap 5 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<script defer src="js/bootstrap.bundle.min.js"></script>

<!-- Bootstrap icons -->
<link href="css/bootstrap-icons.min.css" rel="stylesheet">

<!-- DataTables.net -->
<link href="css/dataTables.bootstrap5.min.css" rel="stylesheet">
<script defer src="js/jquery-3.7.0.js"></script>
<script defer src="js/jquery.dataTables.min.js"></script>
<script defer src="js/dataTables.bootstrap5.min.js"></script>

<script defer>
	window.addEventListener('DOMContentLoaded', function() {
		new DataTable('#listado', {
			language : {
				url : 'json/es-ES.json',
			},
		});
		
		if(document.querySelector('#modal-reserva')) {
			new bootstrap.Modal('#modal-reserva').show();
		}
		
		const offcanvasElementList = document.querySelectorAll('.offcanvas');
		const offcanvasList = [...offcanvasElementList].map(offcanvasEl => new bootstrap.Offcanvas(offcanvasEl).show());
	});
	
</script>

<link href="imgs/book.svg" rel="icon">
</head>

<body>

	<nav class="navbar navbar-expand-lg bg-dark sticky-top"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <i
				class="bi bi-book d-inline-block align-text-top"></i> Biblioteca
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="index">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<c:if test="${sessionScope.usuario.rol == 'ADMIN' }">
						<li class="nav-item"><a class="nav-link" href="admin/index">Administración</a></li>
					</c:if>

					<c:if test="${sessionScope.usuario != null}">
						<li class="nav-item"><a class="nav-link" href="prestados">Libros prestados</a></li>

						<li id="rol-usuario" class="navbar-text me-2">[${sessionScope.usuario.rol}]
						</li>
						<li id="usuario" class="navbar-text">${sessionScope.usuario.nombre}</li>
					</c:if>

					<c:choose>
						<c:when test="${sessionScope.usuario == null}">
							<li class="nav-item"><a class="nav-link" href="login">Iniciar
									sesión</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link"
								href="logout">Cerrar sesión</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	<c:if test="${alerta != null}">
		<div class="alert alert-${nivel} alert-dismissible fade show"
			role="alert">
			${alerta}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>