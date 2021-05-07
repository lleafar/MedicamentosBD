package model.dao.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class Produto {
    private int numero_produto;
    private String nome_produto;
    private int numero_classe_terapeutica;
    private int numero_tipo_produto;
    private static AtomicInteger nextId = new AtomicInteger(0);

    public Produto(String nome_produto, int numero_classe_terapeutica, int numero_tipo_produto) {
        this.numero_produto = getNextId();
        this.nome_produto = nome_produto;
        this.numero_classe_terapeutica = numero_classe_terapeutica;
        this.numero_tipo_produto = numero_tipo_produto;
    }

    private static int getNextId() {
        return nextId.incrementAndGet();
    }

    public int getNumero_produto() {
        return numero_produto;
    }

    public void setNumero_produto(int numero_produto) {
        this.numero_produto = numero_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getNumero_classe_terapeutica() {
        return numero_classe_terapeutica;
    }

    public void setNumero_classe_terapeutica(int numero_classe_terapeutica) {
        this.numero_classe_terapeutica = numero_classe_terapeutica;
    }

    public int getNumero_tipo_produto() {
        return numero_tipo_produto;
    }

    public void setNumero_tipo_produto(int numero_tipo_produto) {
        this.numero_tipo_produto = numero_tipo_produto;
    }
}
