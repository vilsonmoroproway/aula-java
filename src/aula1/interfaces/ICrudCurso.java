/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.interfaces;

import aula1.modelos.Curso;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface ICrudCurso {
    public Curso salvar(Curso curso);
    /*public void excluir(Aluno aluno);
    public void excluir(int id);
    public Curso consultar(int id);
    public void alterar(Aluno aluno);*/
    public List<Curso> consultar();
    
}
