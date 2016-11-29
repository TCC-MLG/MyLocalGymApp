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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.adapters.ExtratoAdapter;
import gym.com.br.mylocalgym.adapters.UltimasAcademiasAdapter;
import gym.com.br.mylocalgym.models.ExtratoCliente;
import gym.com.br.mylocalgym.models.ExtratoView;
import gym.com.br.mylocalgym.models.UltimasAcademiasView;
import gym.com.br.mylocalgym.services.ExtratoClienteService;
import gym.com.br.mylocalgym.utils.SessionManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltimasAcademiasFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Integer clienteId;
    private ExtratoClienteService service;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_ultimas_academias, container, false);

        this.buscarSessao();
        this.service = new ExtratoClienteService();
        List<ExtratoCliente> list = service.listarExtratoCliente(clienteId, 30);

        if (list != null && !list.isEmpty()){
            listarExtrato(list, view);
        }

        return view;
    }

    private void listarExtrato(List<ExtratoCliente> list, View view) {

        if (list != null){
            ArrayList<UltimasAcademiasView> arrayList = new ArrayList<>();

            for (ExtratoCliente extratoCliente : list) {

                UltimasAcademiasView extratoView = new UltimasAcademiasView(extratoCliente.getRazaoSocial(), extratoCliente.getDataTransacao());

                arrayList.add(extratoView);
            }

            ListView listView = (ListView) view.findViewById(R.id.list_academias);

            ArrayAdapter adapter = new UltimasAcademiasAdapter(getActivity(), arrayList);

            listView.setAdapter(adapter);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }

    private void buscarSessao() {

        SessionManager sessionManager = new SessionManager(getContext());
        // Pega da sessão as informações do usuário
        HashMap<String, String> user = sessionManager.getUserDetails();
        clienteId = Integer.parseInt(user.get(sessionManager.KEY_ID));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
