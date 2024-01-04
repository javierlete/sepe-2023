<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container my-5">

	<section id="admin">
		<h2>Administración</h2>

		<div class="table-responsive">
			<table id="listado"
				class="table table-hover table-striped table-bordered">
				<caption>Libros</caption>
				<thead class="table-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Título</th>
						<th scope="col">ISBN</th>
						<th scope="col">Unidades</th>
						<th scope="col">Género</th>
						<th scope="col">Autor</th>
						<th scope="col">Prestatario</th>
						<th scope="col">OPCIONES</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${libros}" var="l">
						<tr>
							<th scope="row">${l.id}</th>
							<td>${l.titulo}</td>
							<td>${l.isbn}</td>
							<td>${l.unidades}</td>
							<td>${l.genero}</td>
							<td>${l.autor}</td>
							<td>${l.prestatario.nombre}</td>
							<td><a href="admin/libro?id=${l.id}"
								class="btn btn-sm btn-primary">Editar</a> <a
								href="javascript:devolver()" class="btn btn-sm btn-warning">Devolver</a>
								<a href="admin/libro?borrar&id=${l.id}" class="btn btn-sm btn-danger">Borrar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot class="table-dark">
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a href="javascript:mostrar('formulario')"
							class="btn btn-sm btn-primary">Añadir</a></td>
					</tr>
				</tfoot>
			</table>
		</div>
	</section>

</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>