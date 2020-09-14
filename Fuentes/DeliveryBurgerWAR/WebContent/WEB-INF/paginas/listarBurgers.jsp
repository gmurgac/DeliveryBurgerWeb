<jsp:include page="../templates/header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="container">

	<div class="columns is-centered is-vcentered">
		<form method="get" action="ListarBurgerController.do" class="column is-3">
			<div class="field">
				<label class="label">Ingredientes</label>
				<div class="control">
					<input name="filtroBurger" class="input" type="text"
						placeholder="Ingrese sus ingredientes favoritos">
				</div>
			</div>
		
			
				<button type="submit" class="button">Filtrar</button>
			</form>
		</div>






	<div class="columns is-vcentered is-centered is-multiline">

		<c:forEach items="${burgers}" var="b">
			<div class="column is-4">
				<div class="card">
					<div class="card-header">
						<div class="card-header-title">
							<div class="columns is-multiline is-centered">
								<div class="column is-12">
									<img src="img/burger.jpg">
								</div>
								<div class="column is-12"><span>${b.nombre}</span></div>
							</div>
							
						</div>
					</div>

					<div class="card-content">
						<p>${b.descripcion}</p>
					</div>
					<div class="card-footer">
						<div class="card-footer-item">
							<h1>Precio $</h1>
							${b.precio}
						</div>

						<div class="card-footer-item">
							<form method="post">
								<input type="hidden" name="idEliminarTxt" value="${b.id_burger}" />
								<button class="button is-danger" type="submit">Eliminar</button>
							</form>
						</div>
					</div>
				</div>

			</div>
		</c:forEach>
	</div>





</main>







<jsp:include page="../templates/footer.jsp"></jsp:include>