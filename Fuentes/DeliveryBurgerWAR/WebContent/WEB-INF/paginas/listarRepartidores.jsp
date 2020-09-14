
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container">
	
	<div class="columns is-centered is-vcentered">
		<form method="get" action="ListarRepartidorController.do">
			<div class="column is-12">

				<div class="field">
					<label class="label">Filtro por estado</label>
					<div class="control">
						<div class="select">
							<select name="filtroSelect">
								<option>Media jornada Mañana</option>
								<option>Media jornada Tarde</option>
								<option>Full time</option>
							</select>
						</div>
					</div>
				</div></div>
				<div class="column is-6"><button class="button" type="submit">Filtrar</button>
			</div>
		</form>
	</div>
	
	
	
	
	
	<div class="columns is-centered is-vcentered">
		<div class="column is-7">
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Numero Telefonico</th>
						<th>Disponibilidad</th>
						<th>Vehiculo</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${repartidores}" var="r">
					<tr>
						<td>${r.id_repartidor}</td>
						<td>${r.nombre}</td>
						<td>${r.apellido}</td>
						<td>${r.numero_telefonico}</td>
						<td>${r.disponibilidad}</td>
						<td>${r.vehiculo}</td> 
						<td><form method="POST" action="ListarRepartidorController.do">
									<input type="hidden" name="idEliminarTxt" value="${r.id_repartidor}" />
									<button class="button is-warning"
										type="submit">Eliminar</button>
								</form></td>

					</tr></c:forEach>
				</tbody>

			</table>


		</div>


	</div>


</main>







<jsp:include page="../templates/footer.jsp"></jsp:include>