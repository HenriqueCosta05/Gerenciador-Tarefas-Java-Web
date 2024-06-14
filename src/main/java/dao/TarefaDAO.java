package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConnectionFactory;
import model.Tarefa;

public class TarefaDAO {

    public static void insere(Tarefa tarefa) throws SQLException {
        String sql = "INSERT INTO tarefas(titulo, descricao, dataFinal, status, idUsuario) VALUES (?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, tarefa.getTitulo());
            pstm.setString(2, tarefa.getDescricao());
            pstm.setDate(3, new Date(tarefa.getDataFinal().getTime()));
            pstm.setString(4, tarefa.getStatus());
            pstm.setLong(5, tarefa.getIdUsuario());

            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
    }

    public static Tarefa ler(int id) throws SQLException {
        String sql = "SELECT * FROM tarefas WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("id"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setDataFinal(rs.getDate("dataFinal"));
                tarefa.setStatus(rs.getString("status"));
                tarefa.setIdUsuario(rs.getInt("idUsuario"));
                return tarefa;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return null;
    }

    public static ArrayList<Tarefa> lerTodasAsTarefas() throws SQLException {
        String sql = "SELECT * FROM tarefas";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("id"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setStatus(rs.getString("status"));
                tarefa.setIdUsuario(rs.getInt("idUsuario"));
                tarefa.setDataFinal(rs.getDate("dataFinal"));
                
                tarefas.add(tarefa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return tarefas;
    }

    public static ArrayList<Tarefa> lerTarefasPorUsuario(long idUsuario) throws SQLException {
        String sql = "SELECT * FROM tarefas WHERE idUsuario = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, idUsuario);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(rs.getInt("id"));
                tarefa.setTitulo(rs.getString("titulo"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setStatus(rs.getString("status"));
                tarefa.setIdUsuario(rs.getInt("idUsuario"));
                tarefa.setDataFinal(rs.getDate("dataFinal"));
                
                tarefas.add(tarefa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return tarefas;
    }
}
