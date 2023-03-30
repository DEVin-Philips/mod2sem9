package org.senai.devinhouse.magazinesenai.models;

import javax.persistence.*;

@Entity(name = "categorias")
/*@SequenceGenerator(name = "CATEGORIA_ID_GENERATOR",
        sequenceName = "SEQ_CATEGORIA",
        allocationSize = 1)*/
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY/*,
                    generator = "CATEGORIA_ID_GENERATOR"*/)
    private int id;
    private String nome;

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
}
