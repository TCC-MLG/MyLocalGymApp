package gym.com.br.mylocalgym.models;

/**
 * Created by Luciano on 02/11/2016.
 */

public class ExtratoView {

    private String nomeAcademia;
    private String valor;
    private String data;

    public ExtratoView(String nomeAcademia, String valor, String data){

        this.nomeAcademia = nomeAcademia;
        this.valor = valor;
        this.data = data;
    }

    public ExtratoView(){}

    public String getNomeAcademia() {
        return nomeAcademia;
    }

    public void setNomeAcademia(String nomeAcademia) {
        this.nomeAcademia = nomeAcademia;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
