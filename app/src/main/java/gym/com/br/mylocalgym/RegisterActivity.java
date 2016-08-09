package gym.com.br.mylocalgym;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


//import com.android.volley.RequestQueue;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONException;
//import org.json.JSONObject;

//import com.google.android.gms.appdatasearch.GetRecentContextCall;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout inputLayoutEmail, inputLayoutPassword, inputLayoutrPassword;
    private boolean ValCampos;
    private EditText rNomec;
    private EditText rEmail;
    private EditText rApe;
    private EditText rTelefone;
    private EditText rCpf;
    private EditText rEstado;
    private EditText rCidade;
    private EditText rEnd;
    private EditText rPassword;
    private EditText rRPassword;
    private Button rCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_remail);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_rpassword);
        inputLayoutrPassword = (TextInputLayout) findViewById(R.id.input_layout_rrpassword);

        rNomec = (EditText) findViewById(R.id.rNomec);
        rEmail = (EditText) findViewById(R.id.rEmail);
        rApe = (EditText) findViewById(R.id.rApe);
        rTelefone = (EditText) findViewById(R.id.rTelefone);
        rCpf = (EditText) findViewById(R.id.rCpf);
        rEstado = (EditText) findViewById(R.id.rEstado);
        rCidade = (EditText) findViewById(R.id.rCidade);
        rEnd = (EditText) findViewById(R.id.rEnd);
        rPassword = (EditText) findViewById(R.id.rPassword);
        rRPassword = (EditText) findViewById(R.id.rRPassword);
        rCadastrar = (Button) findViewById(R.id.rCadastrar);

        rCadastrar.setOnClickListener(this);

    }

    public void onClick(View v)
    {
        Cadastrar();
    }

//        Intent it = new Intent(this, Mostra_Activity.class);
//
//        it.putExtra("NOME", rgNome.getText().toString());
//        it.putExtra("EMAIL", rgEmail.getText().toString());
//        it.putExtra("APELIDO", rgApe.getText().toString());
//        it.putExtra("TELEFONE", rgTel.getText().toString());
//        it.putExtra("CPF", rgCpf.getText().toString());
//        it.putExtra("ESTADO", rgEstado.getText().toString());
//        it.putExtra("CIDADE", rgCidade.getText().toString());
//        it.putExtra("ENDERECO", rgEnd.getText().toString());
//        it.putExtra("PASSWORD", rgPassword.getText().toString());
//        startActivity(it);
//    }

    // setar o foco de um determinado componente
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    // método será chamado no onClick
    public void Cadastrar(){

        ValCampos=false;

        if (!validarEmail()) {
            return;
        }

        if (!validarPassword()) {
            return;
        }
        if (!comparaPassword()){
            return;
        }
        ValCampos=true;
        Toast.makeText(this, "Usuário cadastrado", Toast.LENGTH_LONG).show();
    }

    // validar a senha
    private boolean validarPassword() {
        if (rPassword.getText().toString().trim().length() < 8) {
            inputLayoutPassword.setError(getString(R.string.erro_msg_password));
            requestFocus(rPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }
    // Compara as senhas informadas
    private boolean comparaPassword() {
        if (rPassword.getText().toString().trim() != rRPassword.getText().toString().trim()) {
            inputLayoutPassword.setError(getString(R.string.erro_msg_compara_password));
            requestFocus(rRPassword);
            return false;
        } else {
            inputLayoutrPassword.setErrorEnabled(false);
        }

        return true;
    }

    // validar o endereço de e-mail
    private boolean validarEmail() {
        String email = rEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.erro_msg_email));
            requestFocus(rEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    // verifica se o formato do email é válido
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}