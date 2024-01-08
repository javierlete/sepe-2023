<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container my-5">

	<%@ include file="/WEB-INF/vistas/includes/detalle.jsp"%>
	
	<!-- Modal -->
	<div class="modal fade" id="modal-reserva" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="staticBackdropLabel">Atención</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Has reservado con éxito el libro
					${libro.titulo}</div>
				<div class="modal-footer">
					<a href="index" class="btn btn-primary">¡Genial!</a>
				</div>
			</div>
		</div>
	</div>

</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>