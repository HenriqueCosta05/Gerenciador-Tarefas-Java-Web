<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Tarefa" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/styles.css" />
    <title>Lista de Tarefas</title>
</head>
<body>
<%@ include file="home.jsp" %>
<div>
    <h1>Lista de Tarefas</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Descrição</th>
            <th>Data Final</th>
            <th>Status</th>
            <th>ID do Usuário</th>
        </tr>
        <%
            Object tarefasObj = request.getAttribute("tarefas");
            if (tarefasObj == null) {
                out.println("<tr><td colspan='6'>Nenhuma tarefa encontrada</td></tr>");
            } else if (tarefasObj instanceof ArrayList<?>) {
                ArrayList<?> lista = (ArrayList<?>) tarefasObj;
                if (lista.isEmpty()) {
                    out.println("<tr><td colspan='6'>Nenhuma tarefa encontrada</td></tr>");
                } else {
                    boolean isTarefaList = true;
                    for (Object obj : lista) {
                        if (!(obj instanceof Tarefa)) {
                            isTarefaList = false;
                            break;
                        }
                    }
                    if (isTarefaList) {
                        ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) lista;
                        for (Tarefa tarefa : tarefas) {
        %>
        <tr>
            <td><%= tarefa.getId() %></td>
            <td><%= tarefa.getTitulo() %></td>
            <td><%= tarefa.getDescricao() %></td>
            <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(tarefa.getDataFinal()) %></td>
            <td><%= tarefa.getStatus() %></td>
            <td><%= tarefa.getIdUsuario() %></td>
        </tr>
        <%
                        }
                    } else {
                        out.println("<tr><td colspan='6'>Erro: Tipo de objeto inesperado na lista</td></tr>");
                    }
                }
            } else {
                out.println("<tr><td colspan='6'>Erro: Tipo de objeto inesperado para o atributo 'tarefas'</td></tr>");
            }
        %>
    </table>
</div>
</body>
</html>
