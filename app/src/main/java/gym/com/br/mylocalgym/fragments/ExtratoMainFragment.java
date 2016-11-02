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
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.models.ExtratoCliente;
import gym.com.br.mylocalgym.services.ExtratoClienteService;
import gym.com.br.mylocalgym.utils.AcademiaNames;
import gym.com.br.mylocalgym.utils.ListViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExtratoMainFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ExtratoClienteService service;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_extrato_main, container, false);

        ArrayList<String> arrayList = getListTest();

        ListView listView = (ListView) view.findViewById(R.id.list_extrato);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(adapter);

        return view;
    }

    public ArrayList getListTest(){

        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("vamo que vamo");
        arraylist.add("HAJA O QUE HAJAR");
        arraylist.add("FODA-SE VOCES- FODAM-SE SUAS LEIS");

        return arraylist;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

//        this.service = new ExtratoClienteService();
//
//        List<ExtratoCliente> list = this.service.listarExtratoCliente(2, 20);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
