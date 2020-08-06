<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

<title>Seu RM</title>
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
						<h3>Cadastro Efetuado com Sucesso</h3>
					</div>

					<div class="card-body">
						<form>
							<!-- NOME -->
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input type="text" class="form-control" value="Nome: ${nome }" readonly>
							</div>
							<!-- RM -->
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input type="text" class="form-control" value="RM: ${codigo }" readonly>
							</div>
							<!-- SENHA -->
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								<input type="text" class="form-control" value="Senha: ${senha }" readonly>
							</div>
						</form>

					</div>
					<div class="card-footer">
							<div class="form-group">
								<a href="login.jsp">Voltar para o Login</a>
								<p>Não esqueça de anotar seu RM e Senha</p>
							</div>

					</div>
				</div>
			</div>
		</div>
	</div>	

</body>
</html>