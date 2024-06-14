<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Tarefas por Usuário</title>
</head>
<body>
<main>
	<form>
		<div>
			<label><strong>Usuário Associado:</strong></label>
			<input type="text" name="usuarioAssociado"/>
		</div>
			<div> 
				<input id="btn" type="submit" name="btLogar" value="Logar" />
			</div>
	</form>
	<div>
		<table>
			 <%
                // Recupera a lista de tarefas do request
                List<String> tarefas = (List<String>) request.getAttribute("tarefas");
                if (tarefas != null) {
                    for (String tarefa : tarefas) {
            %>
		</table>
	</div>
	</main>
</body>
</html>