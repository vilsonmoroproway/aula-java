/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author aluno
 */
public class Senhas {
    public static String gerarHash(String senha){
        //gerar hash com bcrypt
        String hash = BCrypt.hashpw(senha, BCrypt.gensalt());
        return hash;
    }
    
    public static boolean verificarSenha(String senha, String hash){
        return BCrypt.checkpw(senha, hash);
    }
}
