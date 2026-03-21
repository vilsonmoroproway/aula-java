/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aula1.interfaces;

import aula1.modelos.Aluno;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface ICrud {
    public Aluno salvar(Aluno aluno);
    public void excluir(Aluno aluno);
    public void excluir(int id);
    public Aluno consultar(int id);
    public List<Aluno> consultar();
    public void alterar(Aluno aluno);
}
