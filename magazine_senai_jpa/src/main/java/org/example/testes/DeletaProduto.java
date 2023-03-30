package org.example.testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.daos.ProdutoDAO;
import org.example.models.Produto;

public class DeletaProduto {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("magazine_senai");
        EntityManager em = factory.createEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(em);

        em.getTransaction().begin();

        Produto produto = em.find(Produto.class, 9);
        Produto outroProduto = em.find(Produto.class, 10);

        if (produto != null) {
            em.remove(produto);
        }

        if (outroProduto != null) {
            em.remove(outroProduto);
        }

        Produto prod = new Produto();
        prod.setId(5);

        produtoDAO.excluir(prod);

        em.getTransaction().commit();
        em.close();
    }
}
