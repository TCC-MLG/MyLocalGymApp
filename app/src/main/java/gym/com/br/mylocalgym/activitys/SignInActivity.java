package gym.com.br.mylocalgym.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import gym.com.br.mylocalgym.MainActivity;
import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.utils.SessionManager;

public class SignInActivity extends AppCompatActivity {

    //text
    private TextInputLayout inputLayoutEmail, inputLayoutPassword;

    //botões
    private EditText lgEmail, lgPassword;
    private Button lgLogin;
    private TextView lgRegisterlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinactivity);

        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);

        lgEmail = (EditText) findViewById(R.id.lg_Email);
        lgPassword = (EditText) findViewById(R.id.lg_Password);
        lgLogin = (Button) findViewById(R.id.lg_Login);
        lgRegisterlink = (TextView) findViewById(R.id.lg_RegisterLink);

        //Define em qual TextImput será informado a msg de erro
        lgPassword.addTextChangedListener(new MyTextWatcher(lgPassword));
        lgEmail.addTextChangedListener(new MyTextWatcher(lgEmail));

        // Quando o botão for clicado
        lgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputLayoutEmail.setErrorEnabled(false);
                inputLayoutPassword.setErrorEnabled(false);
                hideKeyboard();
                submitForm();
//                String vEmail = inputLayoutEmail.getEditText().getText().toString();
//                String vpassword = inputLayoutPassword.getEditText().getText().toString();
            }
        });

        lgRegisterlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Register = new Intent(SignInActivity.this, FormularioActivity.class);
                SignInActivity.this.startActivity(Register);
            }
        });
    }

    //Valida os campos, se ok chama doLogin
    private void submitForm(){

        if (!validarEmail()) {
            return;
        }
        if (!validarPassword()) {
            return;
        }
        doLogin();
    }

    //Utilizado quando o login for validado
    public void doLogin() {
        boolean resultado=true;

        //*****************************************************************************************
        // Resultado está sendo tratado como um select no banco - Colocar as validações com o banco de dados

        if (resultado){
            //Cria uma sessão para o login do usuário
            SessionManager sessionManager = new SessionManager(getApplicationContext());
            sessionManager.createLoginSession("Jorge", lgEmail.getText().toString());

            Toast.makeText(getApplicationContext(), getString(R.string.login_ok), Toast.LENGTH_SHORT).show();

            //Chama activity com login realizado
            Intent appLogado = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(appLogado);
            finish();
        }else{
            Toast.makeText(getApplicationContext(), getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
        }
    }

    //Utilizado para esconder o teclado na hora que o usuário clicar em login
    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    //Utilizado para validar se o campo está vazio ou se o email está no padrão
    public boolean validarEmail() {
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

    //Utilizado para validar se o email está no padrão
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    //Utilizado para validar a senha do usuário
    public boolean validarPassword() {
        if (lgPassword.getText().toString().trim().length() < 8 ) {
            inputLayoutPassword.setError(getString(R.string.erro_msg_password));
            requestFocus(lgPassword);
        return false;
    }else {
            inputLayoutPassword.setErrorEnabled(false);
        }
        return true;
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
                case R.id.lg_Password:
                    validarPassword();
                    break;
                case R.id.lg_Email:
                    validarEmail();
                    break;
            }
        }
    }

    // setar o foco de um determinado componente
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}