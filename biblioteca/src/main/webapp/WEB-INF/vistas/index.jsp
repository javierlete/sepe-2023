<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container my-5">

	<section id="principal">
		<h2>Principal</h2>

		<div id="listado-libros"
			class="row row-cols-1 row-cols-lg-2 row-cols-xl-3 g-4">
			<!-- row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 -->

			<c:forEach items="${libros}" var="l">
				<div class="col">
					<div class="card h-100 mb-3">
						<div class="row g-0">
							<div class="col-4">
								<img src="https://picsum.photos/500/800?${l.id}"
									class="img-fluid rounded-start" alt="...">
							</div>
							<div class="col-8 mb-3">
								<div class="card-body">
									<h5 class="card-title">${l.titulo}</h5>
									<ul class="list-group list-group-flush">
										<li class="list-group-item">Autor: ${l.autor}</li>
										<li class="list-group-item">Género: ${l.genero}</li>
									</ul>
									<p class="card-text">
										<small class="text-body-secondary">${l.unidades}
											libros disponibles</small>
									</p>
									<p class="card-text">
										<small class="text-body-secondary">${l.isbn}</small>
									</p>
								</div>
							</div>
							<div class="col-12 position-absolute bottom-0">
								<a class="w-100 stretched-link btn btn-primary"
									href="detalle?id=${l.id}">Ver más información</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>