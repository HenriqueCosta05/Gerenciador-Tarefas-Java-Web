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
		<form action="/GerenciadorTarefas/cadastrar" method="post">
			<div>
				<label><strong>Nome completo:</strong></label>
				<input type="text" name="nome" required/>
			</div>
			<div>
				<label><strong>E-mail:</strong></label>
				<input type="email" name="login" required/>
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
		<div>
		<%
			String mensagem = (String) request.getAttribute("mensagem");
			if (mensagem != null) {
				out.print(mensagem);
			}
		%>
		</div>
	</div>
</body>
</html>