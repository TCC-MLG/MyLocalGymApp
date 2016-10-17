package gym.com.br.mylocalgym.models;

/**
 * Created by Matheus on 15/10/2016.
 */

public class ExtratoCliente {

    private String dataTransacao;
    private Integer idAcademia;
    private Integer idTransacao ;
    private Integer razaoSocial;
    private Integer valor;


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

    public Integer getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(Integer razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
