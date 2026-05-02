/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelos.Produto;

/**
 *
 * @author aluno
 */
public class ProdutoDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TagsPU");
    
    public static Produto salvar(Produto p){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }
    
    public static List<Produto> consultar(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Produto p", Produto.class).getResultList();
    }
    
    public void delete(Long idProduto){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Produto p =  em.find(Produto.class, idProduto);
        em.remove(p);
        em.getTransaction().commit();
    }
        
}
