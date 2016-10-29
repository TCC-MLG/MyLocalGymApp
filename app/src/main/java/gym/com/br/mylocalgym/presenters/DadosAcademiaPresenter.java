package gym.com.br.mylocalgym.presenters;

import java.math.BigDecimal;

import gym.com.br.mylocalgym.models.DadosAcademia;

/**
 * Created by Luciano on 29/10/2016.
 */

public class DadosAcademiaPresenter {

    private Integer id;
    private String endereco;
    private String funcionamento;
    private String razaoSocial;
    private BigDecimal valorServico;

    public DadosAcademia convert(){

        DadosAcademia dadosAcademia = new DadosAcademia();

        dadosAcademia.setEndereco(this.endereco);
        dadosAcademia.setFuncionamento(this.funcionamento);
        dadosAcademia.setId(this.id);
        dadosAcademia.setValorServico(this.valorServico);
        dadosAcademia.setRazaoSocial(this.razaoSocial);

        return dadosAcademia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFuncionamento() {
        return funcionamento;
    }

    public void setFuncionamento(String funcionamento) {
        this.funcionamento = funcionamento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }
}
