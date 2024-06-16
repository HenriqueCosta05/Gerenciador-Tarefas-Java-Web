<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                if (tarefasObj instanceof ArrayList<?>) {
                    ArrayList<?> lista = (ArrayList<?>) tarefasObj;
                    if (!lista.isEmpty() && lista.get(0) instanceof Tarefa) {
                        ArrayList<Tarefa> tarefas = (ArrayList<Tarefa>) lista;
                        for (Tarefa tarefa : tarefas) {
            %>
            <tr>
                <td><%= tarefa.getId() %></td>
                <td><%= tarefa.getTitulo() %></td>
                <td><%= tarefa.getDescricao() %></td>
                <td><%= tarefa.getDataFinal() %></td>
                <td><%= tarefa.getStatus() %></td>
                <td><%= tarefa.getIdUsuario() %></td>
            </tr>
            <%
                        }
                    }
                }
            %>
        </table>
    
</body>
</html>
