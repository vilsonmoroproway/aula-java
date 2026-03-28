/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aulas.aulaorm.maven.dao;

import edu.aulas.aulaorm.maven.modelos.Produto;
import edu.aulas.aulaorm.maven.interfaces.IReadDB;
import edu.aulas.aulaorm.maven.interfaces.IWriteDB;
import edu.aulas.aulaorm.maven.utils.ConexaoDB;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ProdutoDao implements IWriteDB<Produto>, IReadDB<Produto>{

    @Override
    public Produto salvar(Produto t) {
        EntityManager em = ConexaoDB.getConexao().createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();
        }catch(Exception ex){
           throw new RuntimeException(ex.getMessage());
        }        
        return t;
    }

    @Override
    public void alterar(Produto t) {
        EntityManager em = ConexaoDB.getConexao().createEntityManager();
        try{
            Produto produtoExistente = em.find(Produto.class, t.getId());
            if(produtoExistente == null){
                throw new RuntimeException("Produto não cadastrado");
            }
            produtoExistente.setDescricao(t.getDescricao());
            produtoExistente.setEstoque(t.getEstoque());
            produtoExistente.setPreco(t.getPreco());
            
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
           
            em.close();
        }catch(Exception ex){
           throw new RuntimeException(ex.getMessage());
        }        
    }

    @Override
    public void excluir(Produto t) {
       EntityManager em = ConexaoDB.getConexao().createEntityManager();
        try{
            Produto produtoExistente = em.find(Produto.class, t.getId());
            if(produtoExistente == null){
                throw new RuntimeException("Produto não cadastrado");
            }
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
           
            em.close();
        }catch(Exception ex){
           throw new RuntimeException(ex.getMessage());
        }  
    }

    @Override
    public List<Produto> consultar() {
        EntityManager em = ConexaoDB.getConexao().createEntityManager();
        List<Produto> lista = em.createQuery("from Produto p",Produto.class).getResultList();   
        em.close();
        return lista;
    }

    @Override
    public Produto consultar(Long id) {
       EntityManager em = ConexaoDB.getConexao().createEntityManager();
       return em.find(Produto.class, id);
    }
    
}
