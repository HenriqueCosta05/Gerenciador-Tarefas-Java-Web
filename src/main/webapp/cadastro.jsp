<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css" />
<title>Cadastro de Usuários</title>
</head>
<body>
<%@ include file="home.jsp" %>
	<div>
	<h1>Cadastrar usuário</h1>
	<p>Preencha o formulário para começar.</p>
		<form>
			<div>
				<label><strong>Nome completo:</strong></label>
				<input type="text" name="nome" />
			</div>
			<div>
				<label><strong>E-mail:</strong></label>
				<input type="email" name="email" />
			</div>
			<div>
				<label><strong>Senha:</strong></label>
				<input type="password" name="senha" />
			</div>
			<br>
			<div> 
				<input id="btn" type="submit" name="btLogar" value="Cadastrar" />
			</div>
		</form>
	</div>
</body>
</html>