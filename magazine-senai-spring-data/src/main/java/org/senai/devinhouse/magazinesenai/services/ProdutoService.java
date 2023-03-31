package org.senai.devinhouse.magazinesenai.services;

import org.senai.devinhouse.magazinesenai.models.Produto;
import org.senai.devinhouse.magazinesenai.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired private ProdutoRepository repository;

    public void salvar(Produto produto) {
        this.repository.save(produto);
    }

    public List<Produto> buscaTodos() {
        return (List<Produto>) this.repository.findAll();
    }

    public void excluir(Produto produto) {
        this.repository.delete(produto);
    }

    public void excluirPeloId(int id) {
        this.repository.deleteById(id);
    }

}
