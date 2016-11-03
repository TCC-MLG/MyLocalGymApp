package gym.com.br.mylocalgym.presenters;

import java.math.BigDecimal;

import gym.com.br.mylocalgym.models.ExtratoCliente;

/**
 * Created by Matheus on 15/10/2016.
 */

public class ExtratoClientePresenter {

    private String dataTransacao;
    private Integer idAcademia;
    private Integer idTransacao ;
    private String razaoSocial;
    private String valor;

    public ExtratoCliente convert(){
        ExtratoCliente extratoCliente = new ExtratoCliente();

        extratoCliente.setDataTransacao(this.dataTransacao);
        extratoCliente.setIdAcademia(this.idAcademia);
        extratoCliente.setIdTransacao(this.idTransacao);
        extratoCliente.setRazaoSocial(this.razaoSocial);
        extratoCliente.setValor(this.valor);

        return extratoCliente;

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
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
