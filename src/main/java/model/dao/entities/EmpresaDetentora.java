package model.dao.entities;

public class EmpresaDetentora {
    private Long cnpj_detentora;
    private String razao_social_detentora;

    public EmpresaDetentora(String chaveComposta) {
        splitCompoundKey(chaveComposta);
    }

    public EmpresaDetentora() {

    }

    private void splitCompoundKey(String cols){
        String col[] = cols.split("-", 2);

        this.cnpj_detentora = Long.parseLong(col[0].trim());
        this.razao_social_detentora = col[1].trim();
    }

    public Long getCnpj_detentora() {
        return cnpj_detentora;
    }

    public void setCnpj_detentora(Long cnpj_detentora) {
        this.cnpj_detentora = cnpj_detentora;
    }

    public String getRazao_social_detentora() {
        return razao_social_detentora;
    }

    public void setRazao_social_detentora(String razao_social_detentora) {
        this.razao_social_detentora = razao_social_detentora;
    }
}
