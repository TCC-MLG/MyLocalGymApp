package gym.com.br.mylocalgym.models;

/**
 * Created by Luciano on 02/11/2016.
 */

public class UltimasAcademiasView {

    private String nomeAcademia;
    private String data;

    public UltimasAcademiasView(String nomeAcademia, String data){

        this.nomeAcademia = nomeAcademia;
        this.data = data;
    }

    public UltimasAcademiasView(){}

    public String getNomeAcademia() {
        return nomeAcademia;
    }

    public void setNomeAcademia(String nomeAcademia) {
        this.nomeAcademia = nomeAcademia;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
