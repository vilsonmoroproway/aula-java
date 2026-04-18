/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelos.Contato;
import utils.ConectaDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ContatoDao {
    public static void salvar(Contato contato){
       String sql = "insert into tb_contatos(nome, email)values(?,?)";
       try{
          PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
          stm.setString(1, contato.getNome());
          stm.setString(2, contato.getEmail());
          stm.execute();
       }catch(SQLException ex){
          throw new RuntimeException(ex.getMessage());
       }
    }
    
    public static void update(Contato contato){
       String sql = "update tb_contatos set nome = ?, email = ? where id = ?";
       try{
          PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
          stm.setString(1, contato.getNome());
          stm.setString(2, contato.getEmail());
          stm.setInt(3, contato.getId());
          stm.execute();
       }catch(SQLException ex){
          throw new RuntimeException(ex.getMessage());
       }
    }
    
    public static List<Contato> getAll() {
        List<Contato> contatos = new ArrayList<>();
	    try{
	    	String sql = "select * from tb_contatos";
	    	PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
	    	ResultSet rs = stm.executeQuery();
	    	while(rs.next()) {
                    Contato ct = new Contato();
                    ct.setId(rs.getInt("id"));
                    ct.setNome(rs.getString("nome"));
	    	    ct.setEmail(rs.getString("email"));
                    contatos.add(ct);
	    	}
	    	return contatos;
	    }catch(SQLException e) {
	    	throw new RuntimeException(e.getMessage());
	    }		
	}
    
    public static Contato getById(int id) {
	try{
		Contato contato = new Contato();
	    	String sql = "select * from tb_contatos where id = ?";
	    	PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
	    	stm.setInt(1, id);
	    	ResultSet rs = stm.executeQuery();
	    	if(rs.next()) {
	    		contato.setId(rs.getInt("id"));
	    		contato.setNome(rs.getString("nome"));
	    		contato.setEmail(rs.getString("email"));	    		
	    	}
	    	return contato;
	    }catch(SQLException e) {
	    	throw new RuntimeException(e.getMessage());
	    }		
	}
}
