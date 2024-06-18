<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Usuario" %>
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
        <form action="/GerenciadorTarefas/novaTarefa" method="post">
            <div>
                <label for="titulo"><strong>Título:</strong></label>
                <input type="text" id="titulo" name="titulo" required/>
            </div>
            <div>
                <label for="dataFinal"><strong>Data Final:</strong></label>
                <input type="date" id="dataFinal" name="dataFinal" required/>
            </div>
            <div>
                <label for="descricao"><strong>Descrição:</strong></label>
                <input type="text" id="descricao" name="descricao" required/>
            </div>
            <div>
                <label for="status"><strong>Status:</strong></label>
                <input type="text" id="status" name="status" required/>
            </div>
            <div>
                <input id="btn" name="btnCriarTarefa" type="submit" value="Criar tarefa" />
            </div>
        </form>
    </div>
</body>
</html>
