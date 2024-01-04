<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container my-5">

	<section id="formulario">
		<h2>Mantenimiento de libro</h2>

		<form action="admin/libro" method="post" novalidate>
			<div class="row mb-3">
				<label for="id" class="col-sm-2 col-form-label">Id</label>
				<div class="col-sm-10">
					<input readonly type="number" class="form-control" id="id"
						name="id" value="${libro.id}">
				</div>
			</div>
			<div class="row mb-3">
				<label for="titulo" class="col-sm-2 col-form-label">Título
					del libro</label>
				<div class="col-sm-10">
					<input required maxlength="50" type="text" class="form-control"
						id="titulo" name="titulo" value="${libro.titulo}">
					<div class="invalid-feedback">El título es obligatorio y debe
						tener como máximo 50 caracteres</div>
				</div>
			</div>
			<div class="row mb-3">
				<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
				<div class="col-sm-10">
					<textarea maxlength="2000" type="text" rows="5"
						class="form-control" id="descripcion" name="descripcion">${libro.descripcion}</textarea>
				</div>
			</div>

			<div class="row mb-3">
				<label for="isbn" class="col-sm-2 col-form-label">ISBN</label>
				<div class="col-sm-10">
					<input required pattern="^\d{13}$" type="text" class="form-control"
						id="isbn" name="isbn" value="${libro.isbn}">
					<div class="invalid-feedback">El ISBN debe tener 13 dígitos</div>
				</div>
			</div>
			<div class="row mb-3">
				<label for="unidades" class="col-sm-2 col-form-label">Unidades</label>
				<div class="col-sm-10">
					<input required min="0" type="number" class="form-control"
						id="unidades" name="unidades" value="${libro.unidades}">
					<div class="invalid-feedback">El mínimo de unidades es cero</div>
				</div>
			</div>
			<div class="row mb-3">
				<label for="genero" class="col-sm-2 col-form-label">Género</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="genero"
						name="genero" value="${libro.genero}">
				</div>
			</div>
			<div class="row mb-3">
				<label for="autor" class="col-sm-2 col-form-label">Autor</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="autor" name="autor" value="${libro.autor}">
				</div>
			</div>
			<div class="row mb-3">
				<label for="prestatario" class="col-sm-2 col-form-label">Prestatario</label>
				<div class="col-sm-10">
					<select class="form-select" name="prestatario">
						<option selected>Elija...</option>
						<option value="1">Javier</option>
						<option value="2">Pepe</option>
					</select>
				</div>
			</div>
			<div class="row mb-3">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Guardar
						libro</button>
					<a class="btn btn-danger" href="admin/index" type="submit"
						class="btn btn-primary">Cancelar</a>
				</div>
			</div>
		</form>
	</section>
</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>