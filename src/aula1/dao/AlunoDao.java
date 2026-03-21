/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.dao;

import aula1.interfaces.ICrud;
import aula1.modelos.Aluno;
import aula1.utils.ConexaoDB;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoDao implements ICrud{

    @Override
    public Aluno salvar(Aluno aluno) {
        String sql = "insert into tb_alunos(nome,nota)values(?,?)";
        try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setString(1, aluno.getNome());
            stm.setFloat(2, aluno.getNota());
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return aluno;
    }

    @Override
    public void excluir(Aluno aluno) {
        excluir(aluno.getId());
    }

    @Override
    public void excluir(int id) {
       String sql = "delete from tb_alunos  where id = ?";
        try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        } 
    }

    @Override
    public Aluno consultar(int id) {
        Aluno a = new Aluno();
       //consultar no banco de dados
       String sql = "select * from tb_alunos where id = ?";
       try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){               
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setNota(rs.getFloat("nota"));               
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }       
       return a;
    }

    @Override
    public List<Aluno> consultar() {
       List<Aluno> alunos = new ArrayList<>();
       //consultar no banco de dados
       String sql = "select * from tb_alunos";
       try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setNota(rs.getFloat("nota"));
                
                alunos.add(a);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
       
       return alunos;
    }

    public List<Aluno> consultar(String filtro) {
       List<Aluno> alunos = new ArrayList<>();
       //consultar no banco de dados
       String sql = "select * from tb_alunos where nome like ?";
       try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setString(1, "%" + filtro + "%");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setNota(rs.getFloat("nota"));
                
                alunos.add(a);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
       
       return alunos;
    }
    
    @Override
    public void alterar(Aluno aluno) {
        String sql = "update tb_alunos set nome = ?,nota = ? where id = ?";
        try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setString(1, aluno.getNome());
            stm.setFloat(2, aluno.getNota());
            stm.setInt(3, aluno.getId());
            stm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    //inserir 
    //Alteração
    //exclusão
    //listar(todos ou um)
}
