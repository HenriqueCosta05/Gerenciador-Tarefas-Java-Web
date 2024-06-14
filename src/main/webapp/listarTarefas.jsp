<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<table>
			  <%
                // Recupera a lista de tarefas do request
                List<String> tarefas = (List<String>) request.getAttribute("tarefas");
                if (tarefas != null) {
                    for (String tarefa : tarefas) {
            %>
            <tr>
                <td><%= tarefa %></td>
            </tr>
            <%
                    }
                }
            %>
		</table>
	</main>
</body>
</html>