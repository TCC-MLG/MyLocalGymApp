package gym.com.br.mylocalgym.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.HashMap;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.models.SaldoCliente;
import gym.com.br.mylocalgym.services.CarteiraClienteService;
import gym.com.br.mylocalgym.utils.SessionManager;

public class SaldoFragment extends Fragment {

    private EditText sSaldo;
    private EditText sDate;
    private Button goRecarregar;

    private Integer clienteId;

    private CarteiraClienteService service;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_saldo, container, false);
        sSaldo = (EditText) rootview.findViewById(R.id.s_Saldo);
        sDate = (EditText) rootview.findViewById(R.id.s_dat);
        goRecarregar = (Button) rootview.findViewById(R.id.s_Recarregar);

        this.buscarSessao();

        this.service = new CarteiraClienteService();

        this.buscarSaldo();

        goRecarregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                service.inserirSaldo(clienteId, new BigDecimal(50));

                buscarSaldo();

                Toast.makeText(getContext(), "Saldo recarregado!", Toast.LENGTH_LONG).show();
            }


        });

        return rootview;

    }

    private void buscarSaldo() {

        this.service = new CarteiraClienteService();

        SaldoCliente saldoCliente = this.service.buscarSaldoPorId(clienteId.longValue());

        if (saldoCliente != null){

            sSaldo.setText(saldoCliente.getSaldo().toString());
            sDate.setText(saldoCliente.getValidade());
        }

    }

    private void buscarSessao() {

        SessionManager sessionManager = new SessionManager(getContext());
        HashMap<String, String> user = sessionManager.getUserDetails();
        clienteId = Integer.parseInt(user.get(sessionManager.KEY_ID));
    }

}
