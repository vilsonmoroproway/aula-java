/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.dao;

import aula1.interfaces.ICrudCurso;
import aula1.modelos.Aluno;
import aula1.modelos.Curso;
import aula1.utils.ConexaoDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class CursoDao implements ICrudCurso{

    @Override
    public Curso salvar(Curso curso) {
        String sql = "insert into tb_cursos(data_inicio,data_fim)values(?,?)";
        try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setDate(1, new Date(curso.getData_inicio().getTime()));
            stm.setDate(2, new Date(curso.getData_fim().getTime()));
            
            stm.execute();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return curso;
    }

    @Override
    public List<Curso> consultar() {
       List<Curso> cursos = new ArrayList<>();
       //consultar no banco de dados
       String sql = "select * from tb_cursos";
       try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Curso a = new Curso();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                cursos.add(a);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
       
       return cursos;
    }
    
    public Curso consultar(int id) {
        Curso c = new Curso();
       //consultar no banco de dados
       String sql = "select * from tb_cursos where id = ?";
       try {
            PreparedStatement stm = ConexaoDB.getConexao().prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){               
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setData_inicio(rs.getDate("data_inicio"));
                c.setData_fim(rs.getDate("data_fim"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }       
       return c;
    }
    
}
