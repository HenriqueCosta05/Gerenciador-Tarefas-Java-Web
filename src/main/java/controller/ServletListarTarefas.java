package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;
import dao.TarefaDAO;

import java.io.IOException;
import java.util.ArrayList;

public class ServletListarTarefas extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletListarTarefas() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Tarefa> tarefas = TarefaDAO.lerTodasAsTarefas();
            if (tarefas != null && !tarefas.isEmpty()) {
                System.out.println("Tarefas encontradas: " + tarefas.size());
            } else {
                System.out.println("Nenhuma tarefa encontrada"); 
            }
            request.setAttribute("tarefas", tarefas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarTarefas.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
