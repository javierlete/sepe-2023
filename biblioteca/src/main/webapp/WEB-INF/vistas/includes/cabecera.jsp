<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<title>Biblioteca</title>

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
					<li class="nav-item"><a class="nav-link"
						href="index">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<li id="menu-admin" class="nav-item"><a class="nav-link"
						href="javascript:mostrar('admin')">Administración</a></li>
					<li id="menu-admin" class="nav-item"><a class="nav-link"
						href="#" data-bs-toggle="offcanvas" data-bs-target="#prestados"
						aria-controls="prestados">Libros prestados</a></li>
					<li id="rol-usuario" class="navbar-text me-2">[Administrador]
					</li>
					<li id="usuario" class="navbar-text">Javier</li>

					<li id="menu-admin" class="nav-item"><a class="nav-link"
						href="javascript:mostrar('login')">Cerrar sesión</a></li>
				</ul>
			</div>
		</div>
	</nav>