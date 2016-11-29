package gym.com.br.mylocalgym.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import gym.com.br.mylocalgym.Parameters.MarkerParameter;
import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.models.DadosAcademia;
import gym.com.br.mylocalgym.services.CheckinService;
import gym.com.br.mylocalgym.utils.Job;
import gym.com.br.mylocalgym.utils.SessionManager;


public class CheckinFragment extends Fragment{

    private EditText ck_NomeAc;
    private EditText ck_EndAc;
    private EditText ck_Preco;
    private EditText ck_Status;
    private EditText ck_Transaction;
    private Button ck_Treinar;

    private String title;
    private String snippet;
    private String email;
    private Integer id;
    private String login;

    private Integer checkinId;

    private boolean validado;

    private Handler handler;

    private DadosAcademia academia;

    private CheckinService service;

    public CheckinFragment() {}

    public CheckinFragment(MarkerParameter markerParameter) {

        this.service = new CheckinService();
        this.academia = this.service.buscarAcademiaPorId(markerParameter.getSnippet());

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        //Recupera sessão e checa login
        SessionManager sessionManager = new SessionManager(getContext());
        // Pega da sessão as informações do usuário
        HashMap<String, String> user = sessionManager.getUserDetails();
        email = user.get(sessionManager.KEY_EMAIL);
        login = user.get(sessionManager.KEY_NAME);
        //O numero no parse se é 01 volta 1
        id = Integer.parseInt(user.get(sessionManager.KEY_ID));

        this.service = new CheckinService();

        View rootview = inflater.inflate(R.layout.fragment_checkin, container, false);

        ck_NomeAc = (EditText) rootview.findViewById(R.id.ck_NomeAc);
        ck_EndAc = (EditText) rootview.findViewById(R.id.ck_EndAc);
        ck_Preco = (EditText) rootview.findViewById(R.id.ck_Preco);
        ck_Status = (EditText) rootview.findViewById(R.id.ck_Status);
        ck_Transaction = (EditText) rootview.findViewById(R.id.ck_Transaction);
        ck_Treinar = (Button) rootview.findViewById(R.id.ck_Treinar);


        ck_NomeAc.setText(academia.getRazaoSocial() != null ? academia.getRazaoSocial().toString() : null);
        ck_EndAc.setText(academia.getEndereco() != null ? academia.getEndereco().toString() : null);
        ck_Preco.setText(academia.getValorServico() != null ? academia.getValorServico().toString() : null);
        ck_Status.setText("Sim");
        ck_Transaction.setText("Não enviada");

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Toast.makeText(getContext(), "Solicitação aceita", Toast.LENGTH_LONG).show();
                ck_Transaction.setText("Liberado!");
            }
        };

        ck_Treinar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                checkinId = service.solicitarCheckin(id, academia.getId() != null ? academia.getId() : null);

                if (checkinId != null){

                    Toast.makeText(getContext(), "Solicitação enviada", Toast.LENGTH_LONG).show();
                    ck_Transaction.setText("Aguardando analise");

                    ativarJob();

                }else {
                    Toast.makeText(getContext(), "Solicitação não enviada, tente novamente", Toast.LENGTH_LONG).show();
                }

            }


        });
        return rootview;
    }

    private void ativarJob(){
        Thread t = new Thread(new Job(handler, id, checkinId));
        t.start();
    }


}
