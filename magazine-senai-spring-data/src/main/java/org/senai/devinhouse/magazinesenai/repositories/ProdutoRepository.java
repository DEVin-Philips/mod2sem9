package org.senai.devinhouse.magazinesenai.repositories;

import org.senai.devinhouse.magazinesenai.models.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    @Query(value = "SELECT p FROM Produto p WHERE p.descricao = :descricao")
    public List<Produto> findByDescricao(String descricao);

    @Query(value = "SELECT * FROM PRODUTOS WHERE NOME = :nome", nativeQuery = true)
    public List<Produto> findByNome(String nome);

    public List<Produto> findByPreco(double preco);
}
