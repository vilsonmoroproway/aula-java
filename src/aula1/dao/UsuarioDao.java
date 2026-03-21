/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.dao;

import aula1.modelos.Usuario;
import aula1.utils.ConexaoDB;
import aula1.utils.Senhas;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {
    public Usuario salvar(Usuario usuario){
        String sql = "insert into tb_usuarios(nome,senha, perfil)values(?,?,?)";
        try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setString(1, usuario.getNome());
            stm.setString(2, Senhas.gerarHash(usuario.getSenha()));
            stm.setString(3, usuario.getPerfil().toString());
            stm.execute();
        } catch (SQLException ex) {
           throw new RuntimeException("Usuário já informado.");
        }
       return usuario;
    }
}
