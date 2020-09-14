<jsp:include page="../templates/header.jsp"></jsp:include>



<main class="container">
	<div class="columns is-centered is-vcentered">
		<div class="column is-7">
			<form method="post" action="AgregarBurgerController.do">
			<div class="card">
				<div class="card-header">
					<div class="card-header-title">Crear hamburgesa</div>
				</div>
				<div class="card-content">
					<div class="field">
						<label class="label">Titulo</label>
						<div class="control"><input class="input" type="text" name="nombreTxt" /></div>
					</div>
					<div class="field">
						<label class="label">Descripcion</label>
						<div class="control"><textarea class="textarea" type="text" name="descripcionTxt" rows="10"></textarea></div>
					</div>
					<div class="field">
						<label class="labe">Precio</label>
						<div class="control">
							<input class="input" type="number" name="precioTxt" />
						</div>
					</div>
				</div>
				<div class="card-footer">
					<div class="card-footer-item is-centered"><button class="button is-danger has-text-warning" type="submit">Crear Hamburgesa</button></div>
				</div>
			</div></form>
		</div>
	</div>





</main>


<jsp:include page="../templates/footer.jsp"></jsp:include>