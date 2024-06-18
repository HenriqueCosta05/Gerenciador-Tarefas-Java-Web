<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css" />

<title>Autenticação de Usuários</title>
</head>
<body>
<%@ include file="home.jsp" %>
	<div>
	<h1>Logar usuário</h1>
	<p>Preencha o formulário para se autenticar.</p>
		<form action="/GerenciadorTarefas/login" method="post">
			<div>
				<label><strong>Login:</strong></label>
				<input type="text" name="login" />
			</div>
			<div>
				<label><strong>Senha:</strong></label>
				<input type="password" name="senha" />
			</div>
			<br>
			<div> 
				<input id="btn" type="submit" name="btLogar" value="Logar" />
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