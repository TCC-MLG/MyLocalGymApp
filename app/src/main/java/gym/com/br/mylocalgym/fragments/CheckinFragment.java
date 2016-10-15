package gym.com.br.mylocalgym.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gym.com.br.mylocalgym.R;


public class CheckinFragment extends Fragment {

    private EditText ck_NomeAc;
    private EditText ck_EndAc;
    private EditText ck_Preco;
    private EditText ck_Status;
    private EditText ck_Transaction;
    private Button ck_Treinar;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_checkin, container, false);

        ck_NomeAc = (EditText) rootview.findViewById(R.id.ck_NomeAc);
        ck_EndAc = (EditText) rootview.findViewById(R.id.ck_EndAc);
        ck_Preco = (EditText) rootview.findViewById(R.id.ck_Preco);
        ck_Status = (EditText) rootview.findViewById(R.id.ck_Status);
        ck_Transaction = (EditText) rootview.findViewById(R.id.ck_Transaction);
        ck_Treinar = (Button) rootview.findViewById(R.id.ck_Treinar);


        ck_NomeAc.setText("Just Fit");
        ck_EndAc.setText("Logo ali, 33");
        ck_Preco.setText("14,00");
        ck_Status.setText("Não");
        ck_Transaction.setText("Não enviada");

        ck_Treinar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Solicitação enviada", Toast.LENGTH_LONG).show();
                ck_Transaction.setText("Aguardando analise");

            }


        });
        return rootview;
    }

}
