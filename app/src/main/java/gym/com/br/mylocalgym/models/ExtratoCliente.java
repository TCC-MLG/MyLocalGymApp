package gym.com.br.mylocalgym.models;

import java.math.BigDecimal;

/**
 * Created by Matheus on 15/10/2016.
 */

public class ExtratoCliente {

    private String dataTransacao;
    private Integer idAcademia;
    private Integer idTransacao ;
    private String razaoSocial;
    private Double valor;

    public ExtratoCliente(){}

    public ExtratoCliente(Object dataTransacao, Object idAcademia, Object idTransacao, Object razaoSocial, Object valor){

        this.dataTransacao = (String) dataTransacao;
        this.idAcademia = (Integer) idAcademia;
        this.idTransacao = (Integer) idTransacao;
        this.razaoSocial = (String) razaoSocial;
        this.valor = (Double) valor;

    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Integer getIdAcademia() {
        return idAcademia;
    }

    public void setIdAcademia(Integer idAcademia) {
        this.idAcademia = idAcademia;
    }

    public Integer getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Integer idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getValor() {
        return valor != null ? valor.toString() : null;
    }

    public void setValor(String valor) {
        this.valor = valor != null ? Double.valueOf(valor): null;
    }
}
