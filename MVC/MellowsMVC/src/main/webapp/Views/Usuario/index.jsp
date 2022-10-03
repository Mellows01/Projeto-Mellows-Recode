<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Usuario" import="java.util.List"%>
<%
List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("usuario");
%>
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
<link rel="stylesheet" type="text/css" href="./css/cadastre-se.css">
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



<section class="container">
	<div class="p-4">
		<div class="row justify-content-center">
			<a href="./Views/Usuario/create.jsp" class="btn mb-2 botao1"
				style="background-color: #FFA500"> Novo Usuário </a>
		</div>

		<table class="table table-responsive table-hover">
			<thead class="table-light">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">E-mail</th>
					<th scope="col">Senha</th>
					<th scope="col">Data de Nascimento</th>
					<th scope="col">Tipo do Login</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>

				<%
				for (Usuario u : listaUsuarios) {
				%>
				<tr>
					<td><%=u.getIdUsuario() %></td>
					<td><%=u.getNome()%></td>
					<td><%=u.getEmail()%></td>
					<td><%=u.getSenha()%></td>
					<td><%=u.getDataNascimento()%></td>
					<td><%=u.tipoLogin()%></td>
					<td>
						<div class="d-flex">
							<a href="./update-usuario?idUsuario=<%=u.getIdUsuario()%>"
								class="btn btn-primary" title="Editar"> Editar<i class="ri-file-edit-line"></i>
							</a> <a href="delete-usuario?idUsuario=<%=u.getIdUsuario()%>"
								class="btn btn-danger" title="Excluir"
								onclick="return confirm('Deseja excluir o usuário <%=u.getNome()%>?')">Excluir
								<i class="ri-delete-bin-2-line"></i>
							</a>
						</div>
					</td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>

	</div>
</section>

<!-- footer/contato -->
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
<!-- fim footer -->

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
</body>

</html>