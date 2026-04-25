/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelos.Usuario;
import utils.ConectaDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class UsuarioDao {
    public void cadastrar(Usuario u) {
        
        String sql = "INSERT INTO usuarios (nome, email, senha, perfil) VALUES (?, ?, ?, ?)";

        try (Connection con = ConectaDB.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getPerfil());

            ps.execute();           

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public Usuario login(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email=? AND senha=?";

        try (Connection con = ConectaDB.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setPerfil(rs.getString("perfil"));
                return u;
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return null;
    }

}
