package model.dao.entities;

import java.util.concurrent.atomic.AtomicInteger;

public class RegistroMedicamentoProcesso {
    private Long numero_registro_produto;
    private Long numero_processo;
    private String data_finalizacao_processo;
    private int numero_categoria_regulatoria;
    private Long cnpj_detentora;


    public RegistroMedicamentoProcesso(Long numero_registro_produto, Long numero_processo, String data_finalizacao_processo, int numero_categoria_regulatoria, Long cnpj_detentora) {
        this.numero_registro_produto = numero_registro_produto;
        this.numero_processo = numero_processo;
        this.data_finalizacao_processo = data_finalizacao_processo;
        this.numero_categoria_regulatoria = numero_categoria_regulatoria;
        this.cnpj_detentora = cnpj_detentora;
    }


    public Long getNumero_registro_produto() {
        return numero_registro_produto;
    }

    public void setNumero_registro_produto(Long numero_registro_produto) {
        this.numero_registro_produto = numero_registro_produto;
    }

    public Long getNumero_processo() {
        return numero_processo;
    }

    public void setNumero_processo(Long numero_processo) {
        this.numero_processo = numero_processo;
    }

    public String getData_finalizacao_processo() {
        return data_finalizacao_processo;
    }

    public void setData_finalizacao_processo(String data_finalizacao_processo) {
        this.data_finalizacao_processo = data_finalizacao_processo;
    }

    public int getNumero_categoria_regulatoria() {
        return numero_categoria_regulatoria;
    }

    public void setNumero_categoria_regulatoria(int numero_categoria_regulatoria) {
        this.numero_categoria_regulatoria = numero_categoria_regulatoria;
    }

    public Long getCnpj_detentora() {
        return cnpj_detentora;
    }

    public void setCnpj_detentora(Long cnpj_detentora) {
        this.cnpj_detentora = cnpj_detentora;
    }
}
