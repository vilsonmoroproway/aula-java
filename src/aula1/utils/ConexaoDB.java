/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class ConexaoDB {
    private static Connection con = null;
    static String user = "root";
    static  String password = "admin";
    static String url = "jdbc:mysql://localhost:3306/bd_java";
    
    public static Connection getConexao() {
        try {
            con = DriverManager.getConnection(url, user, password);            
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return con;
    }
}
