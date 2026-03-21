/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.dao;

import aula1.modelos.Aluno;
import aula1.modelos.Curso;
import aula1.modelos.Turma;
import aula1.utils.ConexaoDB;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class TurmaDao {
     public void salvar(Turma turma) {
        String sql = "insert into tb_turmas(id_aluno,id_curso)values(?,?)";
        try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setInt(1, turma.getAluno().getId());
            stm.setInt(2, turma.getCurso().getId());            
            stm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }  
    }
     
     public void excluir(Turma turma) {
        String sql = "delete from tb_turmas where id_aluno = ? and id_curso = ?";
        try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setInt(1, turma.getAluno().getId());
            stm.setInt(2, turma.getCurso().getId());            
            stm.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }  
    }
     
     public List<Turma> consultar() {
       List<Turma> turmas = new ArrayList<>();
       //consultar no banco de dados
       String sql = "select * from tb_turmas";
       try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                int idAluno = rs.getInt("id_aluno");
                int idCurso = rs.getInt("id_Curso");
                
                Aluno aluno = new AlunoDao().consultar(idAluno);
                Curso curso = new CursoDao().consultar(idCurso);
                
                Turma t = new Turma();
                t.setAluno(aluno);
                t.setCurso(curso);
                
                turmas.add(t);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
       
       return turmas;
    }
     
     public List<Turma> consultar(int idcurso) {
       List<Turma> turmas = new ArrayList<>();
       //consultar no banco de dados
       String sql = "select * from tb_turmas where id_curso = ?";
       try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setInt(1, idcurso);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                int idAluno = rs.getInt("id_aluno");
                int idCurso = rs.getInt("id_Curso");
                
                Aluno aluno = new AlunoDao().consultar(idAluno);
                Curso curso = new CursoDao().consultar(idCurso);
                
                Turma t = new Turma();
                t.setAluno(aluno);
                t.setCurso(curso);
                
                turmas.add(t);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
       
       return turmas;
    }
}
