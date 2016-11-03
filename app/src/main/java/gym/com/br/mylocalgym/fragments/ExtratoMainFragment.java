package gym.com.br.mylocalgym.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.adapters.ExtratoAdapter;
import gym.com.br.mylocalgym.models.ExtratoCliente;
import gym.com.br.mylocalgym.models.ExtratoView;
import gym.com.br.mylocalgym.services.ExtratoClienteService;
import gym.com.br.mylocalgym.utils.AcademiaNames;
import gym.com.br.mylocalgym.utils.ListViewAdapter;
import gym.com.br.mylocalgym.utils.SessionManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtratoMainFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ExtratoClienteService service;

    private View view;

    private Integer clienteId;
    private RadioButton quinze;
    private RadioButton trinta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_extrato_main, container, false);

        this.quinze = (RadioButton) view.findViewById(R.id.ex_15d);
        this.trinta = (RadioButton) view.findViewById(R.id.ex_30d);

        this.buscarSessao();

        this.service = new ExtratoClienteService();

        List<ExtratoCliente> list = this.service.listarExtratoCliente(clienteId, 7);

        this.listarExtrato(list, view);

        this.quinze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service = new ExtratoClienteService();
                List<ExtratoCliente> list = service.listarExtratoCliente(clienteId, 15);

                quinze.setChecked(true);
                trinta.setChecked(false);

                listarExtrato(list, view);
            }
        });

        this.trinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service = new ExtratoClienteService();
                List<ExtratoCliente> list = service.listarExtratoCliente(clienteId, 30);

                quinze.setChecked(false);
                trinta.setChecked(true);

                listarExtrato(list, view);
            }
        });

        return view;
    }

    private void listarExtrato(List<ExtratoCliente> list, View view) {

        if (list != null){
            ArrayList<ExtratoView> arrayList = new ArrayList<>();

            for (ExtratoCliente extratoCliente : list) {

                ExtratoView extratoView = new ExtratoView(extratoCliente.getRazaoSocial(), extratoCliente.getValor(), extratoCliente.getDataTransacao());

                arrayList.add(extratoView);
            }

            ListView listView = (ListView) view.findViewById(R.id.list_extrato);

            ArrayAdapter adapter = new ExtratoAdapter(getActivity(), arrayList);

            listView.setAdapter(adapter);
        }
    }

    private void buscarSessao() {

        SessionManager sessionManager = new SessionManager(getContext());
        // Pega da sessão as informações do usuário
        HashMap<String, String> user = sessionManager.getUserDetails();
        clienteId = Integer.parseInt(user.get(sessionManager.KEY_ID));
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
