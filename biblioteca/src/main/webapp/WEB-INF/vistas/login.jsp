<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container my-5">
	<section id="login">
		<form action="login" method="post">
			<div class="row mb-3">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" name="email" value="${email}">
				</div>
			</div>
			<div class="row mb-3">
				<label for="password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password">
				</div>
			</div>
			<div class="row mb-3">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Iniciar
						sesión</button>
				</div>
			</div>
		</form>
	</section>
</main>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>