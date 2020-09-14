<jsp:include page="../templates/header.jsp"></jsp:include>


<main class="container is-vcentered">
	<div class="columns is-centered is-vcentered">
		<div class="column is-7">
			<form method="post" action="AgregarRepartidorController.do">
			<div class="card">
				<div class="card-header">
					<div class="card-header-title has-background-grey-lighter has-text-light">Contratar Repartidor</div>
				</div>
				<div class="card-content">
					<div class="field">
						<label class="label">Nombre</label>
						<div class="control">
							<input class="input" name="nombreTxt" type="text" />
						</div>
					</div>
					<div class="field">
						<label class="label">Apellido</label>
						<div class="control">
							<input class="input" name="apellidoTxt" type="text" />
						</div>
					</div>
					<div class="field">
					<label class="label">Numero de Contacto</label>
					<div class="control">
					<input class="input" name="numContactoTxt" type="text" />
					</div>
					</div>
					<div class="field">
						<label class="label">Vehiculo</label>
						<div class="control">
							<label class="checkbox"><input type="checkbox"
								name="bicicletaCheck" value="bicicleta">   Bicicleta  </label></div> 
								<div class="control"><label class="checkbox"><input
								type="checkbox" name="automovilCheck" value="automovil">  Automovil  </label> 
							<div class="control">	<label
								class="checkbox"><input type="checkbox"
								name="motocicletaCheck" value="motocicleta">  Motocicleta</label>
						</div>
					</div>
					<div class="field">
						<label class="label">Disponibilidad</label>
						
							<div class="control">
								<label class="radio"> <input type="radio" name="disponibilidadRadio" value="media jornada mañana">
									Media Jornada Mañana
								</label> <label class="radio"> <input type="radio" name="disponibilidadRadio" value="media jornada tarde">
									Media Jornada Tarde
								</label> <label class="radio"> <input type="radio"
									name="disponibilidadRadio" value="full time"> Full time
								</label>
							</div>

						
					</div>

				</div>
				<div class="card-footer">
					<div class="card-footer-item"><button class="button" type="submit">Guardar</button></div>
				
		</div>	</div>
</div></form>
</div>
		</div>






</main>




<jsp:include page="../templates/footer.jsp"></jsp:include>