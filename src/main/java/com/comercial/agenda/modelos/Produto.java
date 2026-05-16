package com.comercial.agenda.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table( name = "tb_produtos")
public class Produto {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank( message = "Descrição obrigatória")
    @Size(min = 3, max = 100, message = "Descrição deve ter entre 3 e 100 caracteres")
    private String descricao;
    @NotNull(message = "Preço obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private BigDecimal preco;
    private BigDecimal estoque;

    public Produto() {
    }

    public Produto(Long id, String descricao, BigDecimal preco, BigDecimal estoque) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }
}
