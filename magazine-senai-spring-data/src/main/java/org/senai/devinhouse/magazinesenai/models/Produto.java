package org.senai.devinhouse.magazinesenai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "produtos")
/*@SequenceGenerator(name = "PRODUTO_ID_GENERATOR",
                   sequenceName = "SEQ_PRODUTO",
                   allocationSize = 1)*/
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY/*,
                    generator = "PRODUTO_ID_GENERATOR"*/)
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    @Column(name = "qtd_estoque")
    private int qtdEstoque;
    @ManyToOne
    private Categoria categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
