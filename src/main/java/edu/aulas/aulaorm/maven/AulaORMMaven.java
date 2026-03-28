/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.aulas.aulaorm.maven;

import edu.aulas.aulaorm.maven.modelos.Produto;
import edu.aulas.aulaorm.maven.dao.ProdutoDao;
import edu.aulas.aulaorm.maven.views.CadastroProduto;
import java.math.BigDecimal;

/**
 *
 * @author aluno
 */
public class AulaORMMaven {

    public static void main(String[] args) {
       /* Produto p = new Produto();
        p.setDescricao("milho");
        p.setPreco(new BigDecimal(10.5));
        p.setEstoque(10);
        
        new ProdutoDao().salvar(p);*/
       /* List<Produto> produtos = new ProdutoDao().consultar();
        for(Produto p : produtos){
            System.out.println(p.getId() 
                    + " " + p.getDescricao() 
                    + " " + p.getPreco() 
                    + " " + p.getEstoque());
        }
        */
       
      /* Produto p = new Produto();
       //Produto p = new ProdutoDao().consultar(1l);
       p.setId(1l);
       p.setDescricao("Milho de pipoca doce");
       p.setEstoque(20);
       p.setPreco(new BigDecimal(5.5));
       new ProdutoDao().alterar(p);
       */
        new CadastroProduto().setVisible(true);
    }
}
