package model.dao.entities;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class RegistroMedicamento {
    private Long numero_registro_produto;
    private int numero_produto;
    private String data_vencimento;
    private String principio_ativo;

    public RegistroMedicamento(Long numero_registro_produto, int numero_produto, String data_vencimento, String principio_ativo) {
        this.numero_registro_produto = numero_registro_produto;
        this.numero_produto = numero_produto;
        this.data_vencimento = data_vencimento;
        this.principio_ativo = principio_ativo;
    }


    public Long getNumero_registro_produto() {
        return numero_registro_produto;
    }

    public void setNumero_registro_produto(Long numero_registro_produto) {
        this.numero_registro_produto = numero_registro_produto;
    }

    public int getNumero_produto() {
        return numero_produto;
    }

    public void setNumero_produto(int numero_produto) {
        this.numero_produto = numero_produto;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getPrincipio_ativo() {
        return principio_ativo;
    }

    public void setPrincipio_ativo(String principio_ativo) {
        this.principio_ativo = principio_ativo;
    }
}
