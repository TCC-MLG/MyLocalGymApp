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

public class DadosPessoaisFragment extends Fragment {

    private EditText dpNome;
    private EditText dpApe;
    private EditText dpTelefone;
    private EditText dpExame;
    private EditText dpTreino;
    private Button dpSalvar;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_dados_pessoais, container, false);

        dpNome = (EditText) rootview.findViewById(R.id.dp_Nomec);
        dpApe = (EditText) rootview.findViewById(R.id.dp_Ape);
        dpTelefone = (EditText) rootview.findViewById(R.id.dp_Telefone);
        dpExame = (EditText) rootview.findViewById(R.id.dp_Exame);
        dpTreino = (EditText) rootview.findViewById(R.id.dp_Treinos);
        dpSalvar = (Button) rootview.findViewById(R.id.dp_Salvar);


        dpNome.setText("Jorge Rapahel Gonzalez");
        dpApe.setText("Jorgito");
        dpTelefone.setText("11 983396430");
        dpExame.setText("Exame Arquivo.pdf");
        dpTreino.setText("ABC");

        dpSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Os alterações foram salvas com sucesso", Toast.LENGTH_LONG).show();

            }


        });

        return rootview;

//        return inflater.inflate(R.layout.fragment_saldo,
//                container, false);
    }

}