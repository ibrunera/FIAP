<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link href="https://fonts.googleapis.com/css?family=Big+Shoulders+Display&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/aluno.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<script src="scripts/validarRM.js"></script>
<script src="scripts/jquery.js"></script>
<script src="scripts/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="css/login.css">

<title>Login</title>

</head>

<body>

	<video autoplay muted loop id="myVideo">
		<source src="videos/alunoLogin.mp4" type="video/mp4">
	</video>
	
	<div class="form-row align-items-center">
		<div class="container">
			<div class="d-flex justify-content-center h-100">
				<div class="card">

					<div class="card-header">
						<h3>Login</h3>
					</div>

					<div class="card-body">
						<form action="Login" method="post">
							<!-- RM -->
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input type="text" class="form-control" placeholder="RM" name="codigo" onblur="validarRm(this,'erroRm')">
							</div>
							<!-- SENHA -->
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								<input type="password" class="form-control" name="senha" placeholder="password">
							</div>
							<div class="row align-items-center remember">
								<input type="checkbox">Lembrar de mim
							</div>
							<!-- BOTAO -->
							<div class="form-group">
								<a>
									<input type="submit" value="Login" class="btn float-right login_btn">
								</a>
							</div>
						</form>

					</div>
					<div class="card-footer">

						<!-- CADASTRO -->

						<div class="d-flex justify-content-center links">
							<a href="cadastro.jsp"> Cadastrar-se</a>
						</div>

						<div class="d-flex justify-content-center">
							<a href="esqueceu-senha.jsp">Esqueci a Senha</a>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>