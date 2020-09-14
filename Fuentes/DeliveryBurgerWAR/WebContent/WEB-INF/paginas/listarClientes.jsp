<jsp:include page="../templates/header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="container">

<div class="columns is-centered is-vcentered">
		<form method="get" action="ListarClienteController.do" class="column is-3">
			<div class="field">
				<label class="label">Filtro RUT</label>
				<div class="control">
					<input name="filtroCliente" class="input" type="text"
						placeholder="'12345678-0'">
				</div>
			</div>
		
			
				<button type="submit" class="button">Filtrar</button>
			</form>
		</div>

	<div class="columns is-centered is-vcentered">
		<div class="column is-7">
			<table class="table">
				<thead>
					<tr>
						<th>Rut</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Edad</th>
						<th>Direccion</th>
						<td>Telefono</td>
						<td>Accion</td>
					</tr>
				</thead>
				<tbody>
					
					
					<c:forEach items="${clientes}" var="c">
					<tr>
						<td>${c.id_cliente}</td>
						<td>${c.nombre}</td>
						<td>${c.apellido}</td>
						<td>${c.edad}</td>
						<td>${c.direccion}</td>
						<td>${c.numero_contacto}</td>
						<td><form method="POST" action="ListarClienteController.do">
									<input type="hidden" name="idEliminarTxt" value="${c.id_cliente}" />
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