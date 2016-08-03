package gym.com.br.mylocalgym;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.*;

public class Mostra_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText mNome;
    private EditText mEmail;
    private EditText mApe;
    private EditText mTel;
    private EditText mCpf;
    private EditText mEstado;
    private EditText mCidade;
    private EditText mEnd;
    private EditText mPassword;
    private EditText mRPassword;
    private Button mOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra);

        mNome = (EditText) findViewById(R.id.mNome);
        mEmail = (EditText) findViewById(R.id.mEmail);
        mApe = (EditText) findViewById(R.id.mApe);
        mTel = (EditText) findViewById(R.id.mTel);
        mCpf = (EditText) findViewById(R.id.mCpf);
        mEstado = (EditText) findViewById(R.id.mEstado);
        mCidade = (EditText) findViewById(R.id.mCidade);
        mEnd = (EditText) findViewById(R.id.mEnd);
        mPassword = (EditText) findViewById(R.id.mPassword);
        mRPassword = (EditText) findViewById(R.id.mRPassword);
        mOk = (Button) findViewById(R.id.mOk);


        mOk.setOnClickListener(this);



        Bundle bundle = getIntent().getExtras();

        if (bundle.containsKey("NOME"))
        {
            String valor = bundle.getString("NOME");
            mNome.setText(valor);
        }
        if (bundle.containsKey("EMAIL"))
        {
            String valor = bundle.getString("EMAIL");
            mEmail.setText(valor);
        }
        if (bundle.containsKey("APELIDO"))
        {
            String valor = bundle.getString("APELIDO");
            mApe.setText(valor);
        }
        if (bundle.containsKey("TELEFONE"))
        {
            String valor = bundle.getString("TELEFONE");
            mTel.setText(valor);
        }
        if (bundle.containsKey("CPF"))
        {
            String valor = bundle.getString("CPF");
            mCpf.setText(valor);
        }
        if (bundle.containsKey("ESTADO"))
        {
            String valor = bundle.getString("ESTADO");
            mEstado.setText(valor);
        }
        if (bundle.containsKey("CIDADE"))
        {
            String valor = bundle.getString("CIDADE");
            mCidade.setText(valor);
        }
        if (bundle.containsKey("ENDERECO"))
        {
            String valor = bundle.getString("ENDERECO");
            mEnd.setText(valor);
        }
        if (bundle.containsKey("PASSWORD"))
        {
            String valor = bundle.getString("PASSWORD");
            mPassword.setText(valor);
        }
    }

    public void onClick(View v)
    {
        finish();
    }





}
