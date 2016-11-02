package gym.com.br.mylocalgym.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import gym.com.br.mylocalgym.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExameFragment extends Fragment {

    private ImageView ex_Imagem;
    private EditText ex_BExame;
    private EditText ex_Status;
    private Button ex_pegar_exame;
    private Button ex_btnEnviar;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_exame, container, false);

        ex_Imagem = (ImageView) rootview.findViewById(R.id.ex_Imagem);
        ex_BExame = (EditText) rootview.findViewById(R.id.ex_BExame);
        ex_Status = (EditText) rootview.findViewById(R.id.ex_Status);
        ex_pegar_exame = (Button) rootview.findViewById(R.id.ex_pegar_exame);
        ex_btnEnviar = (Button) rootview.findViewById(R.id.ex_btnEnviar);

        return rootview;
    }
}
