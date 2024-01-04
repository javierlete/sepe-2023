<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Set,com.biblioteca.entidades.*"%>
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
			<a class="navbar-brand" href="#"> <i alt="Logo"
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
						href="javascript:mostrar('principal')">Principal</a></li>
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

	<main class="container my-5">

		<section id="principal">
			<h2>Principal</h2>

			<div id="listado-libros"
				class="row row-cols-1 row-cols-lg-2 row-cols-xl-3 g-4">
				<!-- row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 -->
				
				<% 
				Set<Libro> libros = (Set)request.getAttribute("libros");
				for(Libro l: libros) 
				{%>
				<div class="col">
					<div class="card h-100 mb-3">
						<div class="row g-0">
							<div class="col-4">
								<img src="https://picsum.photos/500/800?<%= l.getId()%>"
									class="img-fluid rounded-start" alt="...">
							</div>
							<div class="col-8 mb-3">
								<div class="card-body">
									<h5 class="card-title"><%=l.getTitulo()%></h5>
									<ul class="list-group list-group-flush">
										<li class="list-group-item">Autor: <%=l.getAutor()%></li>
										<li class="list-group-item">Género: <%=l.getGenero()%></li>
									</ul>
									<p class="card-text">
										<small class="text-body-secondary"><%=l.getUnidades()%>
											libros disponibles</small>
									</p>
									<p class="card-text">
										<small class="text-body-secondary"><%=l.getIsbn()%></small>
									</p>
								</div>
							</div>
							<div class="col-12 position-absolute bottom-0">
								<a class="w-100 stretched-link btn btn-primary"
									href="#">Ver más
									información</a>
							</div>
						</div>
					</div>
				</div>
				<% } %>
			</div>
		</section>

	</main>

	<footer class="p-2 text-bg-dark d-flex justify-content-between">
		<div>&copy;2023 Javier Lete</div>
		<div>
			<ul class="list-unstyled d-flex">
				<li><a href="#" class="text-white"><i
						class="mx-1 bi bi-facebook"></i></a></li>
				<li><a href="#" class="text-white"><i
						class="mx-1 bi bi-twitter-x"></i></a></li>
				<li><a href="#" class="text-white"><i
						class="mx-1 bi bi-instagram"></i></a></li>
				<li><a href="#" class="text-white"><i
						class="mx-1 bi bi-tiktok"></i></a></li>
				<li><a href="#" class="text-white"><i
						class="mx-1 bi bi-youtube"></i></a></li>
			</ul>
		</div>
	</footer>

</body>

</html>