package model.dao.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class ClasseTerapeutica {
    private int numero_classe_terapeutica;
    private String classe_terapeutica;
    private static AtomicInteger nextId = new AtomicInteger(0);

    public ClasseTerapeutica(String classe_terapeutica) {
        this.numero_classe_terapeutica = getNextId();
        this.classe_terapeutica = classe_terapeutica;
    }

    private static int getNextId() {
        return nextId.incrementAndGet();
    }

    public int getNumero_classe_terapeutica() {
        return numero_classe_terapeutica;
    }

    public void setNumero_classe_terapeutica(int numero_classe_terapeutica) {
        this.numero_classe_terapeutica = numero_classe_terapeutica;
    }

    public String getClasse_terapeutica() {
        return classe_terapeutica;
    }

    public void setClasse_terapeutica(String classe_terapeutica) {
        this.classe_terapeutica = classe_terapeutica;
    }

    @Override
    public String toString() {
        return "ClasseTerapeutica{" +
                "numero_classe_terapeutica=" + numero_classe_terapeutica +
                ", classe_terapeutica='" + classe_terapeutica + '\'' +
                '}';
    }
}
