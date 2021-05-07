package model.dao.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class CategoriaRegulatoria {
    private int numero_categoria_regulatoria;
    private String desc_categoria;
    private static AtomicInteger nextId = new AtomicInteger(0);


    public CategoriaRegulatoria(String desc_categoria) {
        this.numero_categoria_regulatoria = getNextId();
        this.desc_categoria = desc_categoria;
    }

    private static int getNextId() {
        return nextId.incrementAndGet();
    }

    public int getNumero_categoria_regulatoria() {
        return numero_categoria_regulatoria;
    }

    public void setNumero_categoria_regulatoria(int numero_categoria_regulatoria) {
        this.numero_categoria_regulatoria = numero_categoria_regulatoria;
    }

    public String getDesc_categoria() {
        return desc_categoria;
    }

    public void setDesc_categoria(String desc_categoria) {
        this.desc_categoria = desc_categoria;
    }

    @Override
    public String toString() {
        return "CategoriaRegulatoria{" +
                "numero_categoria_regulatoria='" + numero_categoria_regulatoria + '\'' +
                ", desc_categoria='" + desc_categoria + '\'' +
                '}';
    }

}
