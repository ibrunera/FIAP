<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://fonts.googleapis.com/css?family=Big+Shoulders+Display&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/aluno.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<script src="scripts/vl.js"></script>
<script src="scripts/jquery.js"></script>
<script src="scripts/bootstrap.min.js"></script>

<title>Cadastro</title>
</head>

<body background="imagens/fluxo.jpg">

	<div class="container">
		<div class="row">
			<div class="lign-items-center">

				<form id="login" action="CadastroServlet" method="post">
					
					<h1>Cadastro</h1>
					
					<div class="card-body">
						
						<input type="hidden" name="acao" value="cadastrar">
						
						<!-- NOME -->
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<label for="idNome">Nome:</label> 
							<input type="text" name="nome" value="${usuario.nome}" 
							class="form-control" placeholder="Nome" required>
						</div>
						
						<!-- CPF -->
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<label for="idCpf">CPF:</label> 
							<input type="text" name="cpf" value="${usuario.cpf}" 
							class="form-control" placeholder="CPF" required>
						</div>
						
						<!-- DATA NASCIMENTO -->

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<label for="datapicker">Nascimento:</label> 
							<input type="data" name="data" value="${usuario.dataNascimento}"
							class="form-control" placeholder="Data de Nascimento">
						</div>
						
						<!-- E-MAIL -->
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<label for="idEmail">E-mail:</label> 
							<input type="email" name="email" value="${usuario.email}"
							class="form-control" placeholder="E-mail" required>
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<label for="idEmail">Confirmar E-mail:</label> <input type="email"
								class="form-control" placeholder="Confirmar E-mail" required>
						</div>
						
						<!-- SENHA -->

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<label for="idSenha">Senha:</label> 
							<input type="password" name="senha"
							class="form-control" placeholder="Senha" required>
						</div>

						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<label for="idSenha">Confirmar Senha:</label> <input
								type="password" class="form-control"
								placeholder="Confirmar Senha" required>
						</div>

						<div class="form-group">
							<input type="submit" value="Cadastrar"
								class="btn float-right login_btn">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>