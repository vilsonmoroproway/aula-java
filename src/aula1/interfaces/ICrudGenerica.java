/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.interfaces;

import java.util.List;

/**
 *
 * @author aluno
 */
public interface ICrudGenerica<T> {
    public T salvar(T t);
    public void excluir(T t);
    public void excluir(int id);
    public T consultar(int id);
    public List<T> consultar();
    public void alterar(T t);
}
