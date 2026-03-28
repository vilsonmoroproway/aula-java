/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aulas.aulaorm.maven.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class ConexaoDB {
   public static EntityManagerFactory getConexao(){
       return Persistence.createEntityManagerFactory("AGENDA-PU");
   }   
}
