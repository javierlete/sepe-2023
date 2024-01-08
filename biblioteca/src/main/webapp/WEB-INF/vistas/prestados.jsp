<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container my-5">

	<%@ include file="/WEB-INF/vistas/includes/listado.jsp"%>

	<div class="offcanvas offcanvas-end" tabindex="-1" id="prestados">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title" id="offcanvasRightLabel">Libros
				prestados</h5>
			<button type="button" class="btn-close" data-bs-dismiss="offcanvas"
				aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<ul class="list-group">
				<c:forEach items="${usuario.libros}" var="l">
					<li class="list-group-item">${l.titulo}</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>