package org.example.testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.daos.ProdutoDAO;
import org.example.models.Categoria;
import org.example.models.Produto;

import java.util.List;

public class BuscaProduto {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("magazine_senai");
        EntityManager em = factory.createEntityManager();
        ProdutoDAO dao = new ProdutoDAO(em);

        em.getTransaction().begin();

        /*Produto produto = em.find(Produto.class, 1);
        Categoria categoria = em.find(Categoria.class, 1);

        produto.setCategoria(categoria);*/

        List<Produto> produtos = dao.buscaTodos();

        List<Produto> outrosProdutos = dao.buscaPorNome("Curso Java");

        em.getTransaction().commit();
        em.close();

        for (Produto p : produtos) {
            System.out.println(p.getNome());
        }

        for (Produto p: outrosProdutos) {
            System.out.printf("Cursos encontrados com nome 'Curso Java': %s.%n", p.getDescricao());
        }

        produtos.get(0).getCategoria().getNome();

    }
}
