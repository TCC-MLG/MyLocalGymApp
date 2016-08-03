package gym.com.br.mylocalgym;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;


//import com.android.volley.RequestQueue;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONException;
//import org.json.JSONObject;

//import com.google.android.gms.appdatasearch.GetRecentContextCall;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText rgNome;
    private EditText rgEmail;
    private EditText rgApe;
    private EditText rgTel;
    private EditText rgCpf;
    private EditText rgEstado;
    private EditText rgCidade;
    private EditText rgEnd;
    private EditText rgPassword;
    private EditText rgRPassword;
    private Button rgCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rgNome = (EditText) findViewById(R.id.mNome);
        rgEmail = (EditText) findViewById(R.id.mEmail);
        rgApe = (EditText) findViewById(R.id.mApe);
        rgTel = (EditText) findViewById(R.id.mTel);
        rgCpf = (EditText) findViewById(R.id.mCpf);
        rgEstado = (EditText) findViewById(R.id.mEstado);
        rgCidade = (EditText) findViewById(R.id.mCidade);
        rgEnd = (EditText) findViewById(R.id.mEnd);
        rgPassword = (EditText) findViewById(R.id.mPassword);
        rgRPassword = (EditText) findViewById(R.id.mRPassword);
        rgCadastrar = (Button) findViewById(R.id.mOk);

        rgCadastrar.setOnClickListener(this);

    }

    public void onClick(View v)
    {
        Intent it = new Intent(this, Mostra_Activity.class);

        it.putExtra("NOME", rgNome.getText().toString());
        it.putExtra("EMAIL", rgEmail.getText().toString());
        it.putExtra("APELIDO", rgApe.getText().toString());
        it.putExtra("TELEFONE", rgTel.getText().toString());
        it.putExtra("CPF", rgCpf.getText().toString());
        it.putExtra("ESTADO", rgEstado.getText().toString());
        it.putExtra("CIDADE", rgCidade.getText().toString());
        it.putExtra("ENDERECO", rgEnd.getText().toString());
        it.putExtra("PASSWORD", rgPassword.getText().toString());
        startActivity(it);
    }

}