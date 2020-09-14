<jsp:include page="../templates/header.jsp"></jsp:include>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<main class="container">
<c:if test="${errores!=null }">
		<div class="columns is-centered">
			<div class="column is-6 notification is-warning has-text-centered">
				<ul>
					<c:forEach items="${errores}" var="error"><li>${error}</li></c:forEach>
				</ul>
			</div>
		</div>	


</c:if>


	<div class="columns is-centered is-vcentered">
		<div class="column is-7">
			<form method="post" action="AgregarClienteController.do">
			<div class="card">
				<div class="card-header">
					<div class="card-header-title">Agregar Cliente</div>
				</div>
				<div class="card-content">
					<div class="field"><label class="label">RUT</label>
					<div class="control">
					<input class="input" type="text" name="rutTxt" placeholder="12345678-k"/> 
					</div>
					</div>
					<div class="field">
						<label class="label">Nombre</label>
						<div class="control">
							<input class="input" type="text" name="nombreTxt" placeholder="Ingrese Nombre" />
						</div>
					</div>
					<div class="field"><label class="label">Apellido</label>
						<div class="control">
							<input class="input" name="apellidoTxt" type="text" placeholder="Ingrese Apellido" />
						</div>
					</div>
					<div class="field"><label class="label">Edad</label>
						<div class="control">
							<input class="input" type="number" name="edadTxt" />
						</div>
					</div>
					<div class="field"><label class="label">Direccion</label>
						<div class="control">
							<input class="input" name="direccionTxt" type="text" placeholder="Ingrese su direccion" />
						</div>
					</div>
					<div class="field"><label class="label">Telefono</label>
						<div class="control">
							<input class="input" name="telefonoTxt" type="text" placeholder="Ingrese numero de contacto" />
						</div>
					</div>
				</div>
				<div class="card-footer">
					<div class="card-footer-item">
						<button class="button is-link" type="submit">Guardar</button>
					</div>
				</div>
			</div></form>
		</div>
	</div>



</main>


<jsp:include page="../templates/footer.jsp"></jsp:include>