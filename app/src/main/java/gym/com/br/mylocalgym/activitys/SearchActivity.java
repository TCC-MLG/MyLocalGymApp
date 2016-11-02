package gym.com.br.mylocalgym.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.utils.AcademiaNames;
import gym.com.br.mylocalgym.utils.ListViewAdapter;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] academiaNameList;
    ArrayList<AcademiaNames> arraylist = new ArrayList<AcademiaNames>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Generate sample data

        academiaNameList = new String[]{"Unip", "Just Fit", "Smart Fit"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.s_listview);

        for (int i = 0; i < academiaNameList.length; i++) {
            AcademiaNames academiaNames = new AcademiaNames(academiaNameList[i]);
            // Binds all strings into an array
            arraylist.add(academiaNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.s_search);
        editsearch.setOnQueryTextListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                String s = (list.getItemAtPosition(position).toString());

                switch (position){
                    case 0: onItemSelecionado(s);
                        break;
                    case 1: onItemSelecionado(s);
                        break;
                    case 2: onItemSelecionado(s);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void onItemSelecionado(String t){

    }

}

