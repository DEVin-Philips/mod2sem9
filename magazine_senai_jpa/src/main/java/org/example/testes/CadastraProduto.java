package org.example.testes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.daos.CategoriaDAO;
import org.example.daos.ProdutoDAO;
import org.example.models.Categoria;
import org.example.models.Produto;
import org.hibernate.sql.results.graph.basic.BasicResultAssembler;

public class CadastraProduto {

    public static void main(String[] args) {
        Produto produto = new Produto();

        produto.setNome("Curso Python");
        produto.setDescricao("Curso da linguagem Python");
        produto.setPreco(500);
        produto.setQtdEstoque(50);

        Categoria categoria = new Categoria();
        categoria.setNome("Cursos");

        produto.setCategoria(categoria);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("magazine_senai");
        EntityManager em = factory.createEntityManager();

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        em.getTransaction().begin();

        categoriaDAO.cadastrar(categoria);
        produtoDAO.cadastrar(produto);

        produto.setQtdEstoque(80);

        em.flush();

        em.clear();

        produto.setNome("blablabla");
        produto.setDescricao("bleblelble");

        Produto prod = em.merge(produto);

        prod.setPreco(1000);

        em.flush();
        em.getTransaction().commit();
    }
}
