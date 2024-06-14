<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autenticação de Usuários</title>
</head>
<body>
	<div>
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