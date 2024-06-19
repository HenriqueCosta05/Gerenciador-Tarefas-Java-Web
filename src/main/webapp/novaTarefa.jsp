<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
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
    <h1>Nova tarefa</h1>
    <p>Preencha o formulário abaixo para cadastrar uma nova tarefa.</p>
    <form action="/GerenciadorTarefas/cadastrarTarefa" method="post">
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
            <% 
                HttpSession currentSession = request.getSession(false);
                if (currentSession != null) {
                    Long usuarioId = (Long) currentSession.getAttribute("usuarioId");
                    if (usuarioId != null) {
            %>
                        <input type="hidden" name="usuarioId" value="<%= usuarioId %>" />
            <% 
                    } else {
                        response.sendRedirect("erro.jsp");
                    }
                } else {
                    response.sendRedirect("erro.jsp");
                }
            %>
        </div>
        <input id="btn" name="btnCriarTarefa" type="submit" value="Criar tarefa" />
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
