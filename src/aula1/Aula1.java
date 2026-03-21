/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula1;

import aula1.controllers.AlunoController;
import aula1.controllers.TurmaController;
import aula1.dao.AlunoDao;
import aula1.dao.CursoDao;
import aula1.modelos.Aluno;
import aula1.modelos.Curso;
import aula1.utils.ConexaoDB;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class Aula1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*
         lançar a exceção
         tratar a exceção
        */
       new Menu().setVisible(true);
      // new Matriculas().setVisible(true);
    }
    
    static void xpto(){  /* if(ConexaoDB.getConexao() != null){
            System.out.println("Conectado");
        }*/
       
       Aluno aluno = new Aluno();
       aluno.setId(1);
       aluno.setNome("Maria");
       aluno.setNota(75.5f);
       
      // AlunoDao alunoDao = new AlunoDao();
      // alunoDao.salvar(aluno);*/
        Curso curso = new Curso();
        curso.setId(1);
        curso.setData_inicio(new Date("20/02/2026"));
        curso.setData_fim(new Date("20/03/2026 00:00:00"));
        
       // new CursoDao().salvar(curso);
       
        TurmaController turmaController = new TurmaController();
        turmaController.matricular(aluno, curso);
        
      /*  System.out.println(aluno.toString());
       
       System.out.println(aluno.getId() + " " + aluno.getNome() + " " + aluno.getNota());
       
       Aluno aluno2 = new Aluno(2,"João", 80.0f);
       System.out.print(aluno2.getId() + " " + aluno2.getNome() + " " + aluno2.getNota());
       
        //AlunoController ac = new AlunoController();
        System.out.println(AlunoController.getSituacao(aluno));*/
    }
        
}
