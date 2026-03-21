/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.dao;

import aula1.enums.PerfilUsuario;
import aula1.modelos.Usuario;
import aula1.utils.ConexaoDB;
import aula1.utils.Senhas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class Sessao {
    private static Usuario usuarioConectado = null;
    public static void login(String nome, String senha){
      /* String sql = "select * from tb_usuarios where nome = ? and senha = ?";
       try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setString(1, nome);
            stm.setString(2, senha);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){      
                usuarioConectado = new Usuario();
                usuarioConectado.setId(rs.getInt("id"));
                usuarioConectado.setNome(rs.getString("nome"));
                usuarioConectado.setPerfil(PerfilUsuario.valueOf(rs.getString("perfil")));               
            }else{
                throw  new RuntimeException("Usuário ou senha inválidos.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }   */ 
       String sql = "select * from tb_usuarios where nome = ?";
       try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setString(1, nome);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){   
                if(Senhas.verificarSenha(senha, rs.getString("senha"))){
                  usuarioConectado = new Usuario();
                  usuarioConectado.setId(rs.getInt("id"));
                  usuarioConectado.setNome(rs.getString("nome"));
                  usuarioConectado.setPerfil(PerfilUsuario.valueOf(rs.getString("perfil")));  
                }
                else{
                    throw  new RuntimeException("Senha inválida.");
                }                               
            }else{
                throw  new RuntimeException("Usuário inválido.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static Usuario getUsuarioConectado() {
         return usuarioConectado;
    }
    
}
