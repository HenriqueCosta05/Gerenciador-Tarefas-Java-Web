package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;
import factory.ConnectionFactory;

public class UsuarioDAO {
   
    public static boolean insere(Usuario user) throws SQLException {
        String sql = "INSERT INTO usuarios(nome, login, senha) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
         
            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getLogin());
            pstm.setString(3, user.getSenha());
            
            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(pstm != null) pstm.close();
            if(conn != null) conn.close();
        }
        return false;
    }
    
    public static Usuario ler(long id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) rs.close();
            if(pstm != null) pstm.close();
            if(conn != null) conn.close();
        }
        return null;
    }
    
    public static boolean autenticar(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionFactory.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, login);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) rs.close();
            if(pstm != null) pstm.close();
            if(conn != null) conn.close();
        }
        return false;
    }
}
