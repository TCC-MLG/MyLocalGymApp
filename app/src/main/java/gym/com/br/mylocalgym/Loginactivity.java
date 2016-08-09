package gym.com.br.mylocalgym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Loginactivity extends AppCompatActivity {

    private TextInputLayout inputLayoutEmail, inputLayoutPassword;

    private EditText lgEmail, lgPassword;
    private Button lgLogin;
    private TextView lgRegisterlink;
    private boolean Loginok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);

        lgEmail = (EditText)findViewById(R.id.lgEmail);
        lgPassword = (EditText)findViewById(R.id.lgPassword);
        lgLogin = (Button)findViewById(R.id.lgLogin);
        lgRegisterlink = (TextView)findViewById(R.id.lgRegisterLink);

        //Define em qual TextImput será informado a msg de erro
        lgPassword.addTextChangedListener(new MyTextWatcher(lgPassword));
        lgEmail.addTextChangedListener(new MyTextWatcher(lgEmail));

        // Quando o botão for clicado
        lgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Chama metodo acessar que vai modificar a variavel Loginok
                Acessar();
                if (Loginok == true){
                AlertDialog.Builder btn = new AlertDialog.Builder(Loginactivity.this);
                btn.setMessage(lgEmail.getText().toString() +' '+ lgPassword.getText().toString());
                btn.setNeutralButton("OK", null);
                btn.show();
                }else {return;}
            }
        });

        lgRegisterlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Register = new Intent(Loginactivity.this, RegisterActivity.class);
                Loginactivity.this.startActivity(Register);
            }
        });
    }

    // método do botão btAcessar declarado no layout, na propriedade onClick
    public void Acessar(){

        Loginok=false;

        if (!validarEmail()) {
            return;
        }

        if (!validarPassword()) {
            return;
        }
        Loginok=true;
        Toast.makeText(this, "Login válido!!!", Toast.LENGTH_LONG).show();
    }

    // setar o foco de um determinado componente
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    // validar a senha
    private boolean validarPassword(){
        if(lgPassword.getText().toString().trim().length() < 8) {
            inputLayoutPassword.setError(getString(R.string.erro_msg_password));
            requestFocus(lgPassword);
            return false;
        }else{
            inputLayoutPassword.setErrorEnabled(false);
        }
        return true;
    }

    // validar o endereço de e-mail
    private boolean validarEmail() {
        String email = lgEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.erro_msg_email));
            requestFocus(lgEmail);
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

    // validar os campos no momento da digitação
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.lgPassword:
                    validarPassword();
                    break;
                case R.id.lgEmail:
                    validarEmail();
                    break;
            }
        }
    }



}