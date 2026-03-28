/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.aulas.aulaorm.maven.interfaces;

/**
 *
 * @author aluno
 */
public interface IWriteDB<T> {
   T salvar(T t);
   void alterar(T t);
   void excluir(T t);
}
