package gym.com.br.mylocalgym.models;

import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Matheus on 24/10/2016.
 */

public class CheckinView {

    private EditText ck_NomeAc;
    private EditText ck_EndAc;
    private EditText ck_Preco;
    private EditText ck_Status;
    private EditText ck_Transaction;
    private Button ck_Treinar;

    public EditText getCk_NomeAc() {
        return ck_NomeAc;
    }

    public void setCk_NomeAc(EditText ck_NomeAc) {
        this.ck_NomeAc = ck_NomeAc;
    }

    public EditText getCk_EndAc() {
        return ck_EndAc;
    }

    public void setCk_EndAc(EditText ck_EndAc) {
        this.ck_EndAc = ck_EndAc;
    }

    public EditText getCk_Preco() {
        return ck_Preco;
    }

    public void setCk_Preco(EditText ck_Preco) {
        this.ck_Preco = ck_Preco;
    }

    public EditText getCk_Status() {
        return ck_Status;
    }

    public void setCk_Status(EditText ck_Status) {
        this.ck_Status = ck_Status;
    }

    public EditText getCk_Transaction() {
        return ck_Transaction;
    }

    public void setCk_Transaction(EditText ck_Transaction) {
        this.ck_Transaction = ck_Transaction;
    }

    public Button getCk_Treinar() {
        return ck_Treinar;
    }

    public void setCk_Treinar(Button ck_Treinar) {
        this.ck_Treinar = ck_Treinar;
    }
}
