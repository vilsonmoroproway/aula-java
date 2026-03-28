/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.aulas.aulaorm.maven.interfaces;

import java.util.List;

/**
 *
 * @author aluno
 */
public interface IReadDB<T> {
    List<T> consultar();
    T consultar(Long id);
}
