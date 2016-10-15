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
import gym.com.br.mylocalgym.models.SaldoCliente;
import gym.com.br.mylocalgym.services.CarteiraClienteService;

public class SaldoFragment extends Fragment {

    private EditText sSaldo;
    private EditText sDate;
    private Button goRecarregar;

    private CarteiraClienteService service;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_saldo, container, false);
        sSaldo = (EditText) rootview.findViewById(R.id.s_Saldo);
        sDate = (EditText) rootview.findViewById(R.id.s_dat);
        goRecarregar = (Button) rootview.findViewById(R.id.s_Recarregar);

        this.service = new CarteiraClienteService();

        SaldoCliente saldoCliente = this.service.buscarSaldoPorId(2l);

        System.out.println("asdsa");

        sSaldo.setText(saldoCliente.getSaldo().toString());
        sDate.setText(saldoCliente.getValidade());

        goRecarregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Neste momento abre a pagina do Pagseguro!", Toast.LENGTH_LONG).show();

//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                Fragment mFrag = new SaldoFragment();
//                transaction.replace(R.id.conteiner, mFrag);
//                transaction.commit();

            }


        });

        return rootview;

    }

}
