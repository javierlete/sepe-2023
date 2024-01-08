<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section id="detalle">
	<h2>Detalle del libro</h2>

	<div class="card mb-3">
		<div class="row g-0">
			<div class="col-4">
				<img src="https://picsum.photos/500/800"
					class="img-fluid rounded-start" alt="...">
			</div>
			<div class="col-8">
				<div class="card-body">
					<h5 id="libro-titulo" class="card-title">${libro.titulo}</h5>
					<p id="libro-descripcion" class="card-text">${libro.descripcion}</p>
					<p>
						<a href="reserva?id=${libro.id}" id="libro-reservar"
							class="btn btn-primary"> Reservar </a> <a href="index"
							class="btn btn-secondary">Volver al listado</a>
					</p>
					<ul class="list-group list-group-flush">
						<li id="libro-autor" class="list-group-item">Autor:
							${libro.autor}</li>
						<li id="libro-genero" class="list-group-item">Género:
							${libro.genero}</li>
					</ul>
					<p class="card-text">
						<small id="libro-unidades" class="text-body-secondary">${libro.unidades}</small>
					</p>
					<p class="card-text">
						<small id="libro-isbn" class="text-body-secondary">${libro.isbn}</small>
					</p>
				</div>
			</div>
		</div>
	</div>

</section>