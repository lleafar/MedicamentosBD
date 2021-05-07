package model.dao.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class TipoProduto {
    private int numero_tipo_produto;
    private String tipo_produto;

    private static AtomicInteger nextId = new AtomicInteger(0);


    public TipoProduto(String tipo_produto) {
        this.numero_tipo_produto = getNextId();
        this.tipo_produto = tipo_produto;
    }

    private static int getNextId() {
        return nextId.incrementAndGet();
    }

    public int getNumero_tipo_produto() {
        return numero_tipo_produto;
    }

    public void setNumero_tipo_produto(int numero_tipo_produto) {
        this.numero_tipo_produto = numero_tipo_produto;
    }

    public String getTipo_produto() {
        return tipo_produto;
    }

    public void setTipo_produto(String tipo_produto) {
        this.tipo_produto = tipo_produto;
    }
}
