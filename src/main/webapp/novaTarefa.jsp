<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css" />
<title>Nova Tarefa</title>
</head>
<body>
<%@ include file="home.jsp" %>
	<div>
	<div>
	<h1>Nova tarefa</h1>
	<p>Preencha o formulário abaixo para cadastrar uma nova tarefa.</p>
	</div>
		<form>
			<div>
				<label><strong>Título:</strong></label>
				<input type="text" name="titulo" required/>
			</div>
			<div>
				<label><strong>Data Final:</strong></label>
				<input type="date" name="dataFinal" required/>
			</div>
			<div>
				<label><strong>Descrição:</strong></label>
				<input type="text" name="descricao" required/>
			</div>
			<div>
				<label><strong>Status:</strong></label>
				<input type="text" name="status" required/>
			</div>
			<div>
				<label><strong>Usuário Associado:</strong></label>
				<select name="usuarioId">
				
				</select>
			</div>
				<input id="btn" name="btnCriarTarefa" type="submit" value="Criar tarefa" />
			<div>
			
			</div>
		</form>
	</div>
</body>
</html>