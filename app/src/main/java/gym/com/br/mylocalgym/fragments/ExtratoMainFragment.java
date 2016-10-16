package gym.com.br.mylocalgym.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.List;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.models.ExtratoCliente;
import gym.com.br.mylocalgym.services.ExtratoClienteService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtratoMainFragment extends ListFragment implements AdapterView.OnItemClickListener {

    private ExtratoClienteService service;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_extrato_main, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        this.service = new ExtratoClienteService();

        List<ExtratoCliente> list = this.service.listarExtratoCliente(2, 20);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Extrato, android.R.layout.simple_list_item_1);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
