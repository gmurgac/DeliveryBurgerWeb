<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery Hamburgesas en tu Ciudad</title>
<link href="css/styles.css" rel="stylesheet" />

<link href="vendor/bulma-0.9.0/css/bulma.min.css" rel="stylesheet" />


</head>
<body>
<header>
<nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="ListarBurgerController.do">
      <img src="img/burger.jpg" width="112" height="28">
    </a>

    <a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <a class="navbar-item" href="AgregarRepartidorController.do">
        Agregar Repartidor
      </a>
      <a class="navbar-item" href="ListarRepartidorController.do">
        Listar Repartidores
      </a>

      <a class="navbar-item" href="AgregarBurgerController.do">
        Agregar Burger
      </a>
      <a class="navbar-item" href="ListarBurgerController.do">
        Listar Burgers
      </a>
	<a class="navbar-item" href="AgregarClienteController.do">
        Agregar Cliente
      </a>
      <a href="ListarClienteController.do" class="navbar-item">
        Listar Clientes
      </a>
    </div>

    
  </div>
</nav>
</header>
</body>
</html>