<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/afb4edac5b.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="./icons/css/all.css" type="text/css"
	media="all" />
	<link rel="stylesheet" type="text/css" href="./css/quemSomos.css">
<title>Projeto Mellows</title>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg mb-5" id="NavBar">
	<div class="container-fluid">
		<a class="navbar-brand" href="./index.html"> <img src="./img/logoMellows.png"
			width="250" alt="logo">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="./usuario">Usuários</a></li>
				<li class="nav-item"><a class="nav-link" href="./login">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="./li">Livros
						Interativos</a></li>
				<li class="nav-item"><a class="nav-link" href="./livro">Livros</a></li>
			</ul>
		</div>
	</div>
</nav>

		<div class="container py-3">
			<form action="./edit-livro">
				<h2 class="text-center">Atualizar Livro</h2>
				<div class="form-group mb-3">
					<label for="id" class="form-label"> ID Livro </label> <input
						type="number" id="id" name="idlivro" class="form-control"
						value="<%=request.getAttribute("idlivro")%>" readonly />
				</div>

				<div class="form-group mb-3">
					<label for="livro" class="form-label"> Nome </label> <input
						type="text" id="livro" name="livro" class="form-control"
						value="<%=request.getAttribute("livro")%>" />
				</div>
				<div class="form-group mb-3">
					<label for="autor" class="form-label"> Autor </label> <input
						type="text" id="autor" name="autor" class="form-control"
						value="<%=request.getAttribute("autor")%>" />
				</div>
				<div class="form-group mb-3">
					<label for="genero" class="form-label"> Gênero </label> <input
						type="text" id="genero" name="genero" class="form-control"
						value="<%=request.getAttribute("genero")%>" />
				</div>
				<div class="form-group mb-3">
					<label for="idUsuario" class="form-label"> ID do Usuario </label> <input
						type="number" id="idUsuario" name="idUsuario" class="form-control"
						value="<%=request.getAttribute("idUsuario")%>" />
				</div>


				<button type="submit" class="btn btn-primary">Enviar</button>
				<a href="./livro" class="btn btn-danger" style="margin-left: 10px">
					Cancelar </a>
			</form>
		</div>

		<footer class="footer bottom">
			<div class="container">
				<br>
				<div class="row">
					<div class="col-sm-8">
						<h6>
							<i class="fa-solid fa-envelope"></i> Fale com a gente!
						</h6>
						<a href="" class="list">contato@mellows.com.br</a>
					</div>

					<div class="col-lg-4 col-sm-12 ">
						<h6>
							<i class="fa-solid fa-globe"></i> Nos siga nas redes
						</h6>
						<p>
							<i class="fa-brands fa-facebook-f"></i><a href="..." class="list">
								Facebook </a>
						</p>
						<p>
							<i class="fa-brands fa-instagram"></i><a href="..." class="list">
								Instagram </a>
						</p>
						<img src="./img/roxo.png" height="200" />

					</div>
				</div>
			</div>
	</div>
	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

</body>
</html>