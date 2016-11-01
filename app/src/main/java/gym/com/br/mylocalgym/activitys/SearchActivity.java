package gym.com.br.mylocalgym.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        academiaNameList = new String[]{"Just Fit", "Smart Fit", "Mais ação",
                "Aero Fitness", "Bem Estar", "Golds GYM", "Fitcare", "Alta Vida",
                "Bony Fit","Olimpo","Agonn", "teste", "teste", "teste", "teste"};

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
}

