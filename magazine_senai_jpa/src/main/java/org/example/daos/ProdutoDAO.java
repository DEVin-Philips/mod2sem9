package org.example.daos;

import jakarta.persistence.EntityManager;
import org.example.models.Produto;

import java.util.List;

public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }

    public void excluir(Produto produto) {
        produto = this.em.merge(produto);
        if (produto != null) {
            this.em.remove(produto);
        }
    }

    public List<Produto> buscaTodos() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscaPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscaPorDescricao(String desc) {
        String jpql = "SELECT p FROM Produto p WHERE p.descricao = :descricao";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("descricao", desc)
                .getResultList();
    }

    public List<Produto> buscaPorNomeDaCategoria(String nomeCategoria) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nomeCat";
        return this.em.createQuery(jpql, Produto.class).getResultList();
    }

}
