package gym.com.br.mylocalgym.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.models.CadastrarCliente;
import gym.com.br.mylocalgym.services.ClienteService;

import static gym.com.br.mylocalgym.utils.ValidaCampos.*;

public class FormularioActivity extends AppCompatActivity implements View.OnClickListener {

    private ClienteService clienteService;

    TextInputLayout inputLayoutEmail, inputLayoutPassword, inputLayoutrPassword, inputLayoutrNamec;
    TextInputLayout inputLayoutrApe, inputLayoutTelefone, inputLayoutCpf, inputLayoutEstado, inputLayoutCidade, inputLayoutEnd;
    private boolean ValCampos;
    private EditText rNomec, rEmail, rApe, rTelefone, rCpf, rEstado, rCidade, rEnd, rPassword, rRPassword;
    private Button rCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputLayoutrNamec = (TextInputLayout) findViewById(R.id.input_layout_rnomec);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_remail);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_rpassword);
        inputLayoutrPassword = (TextInputLayout) findViewById(R.id.input_layout_rrpassword);
        inputLayoutrApe = (TextInputLayout) findViewById(R.id.input_layout_rapelido);
        inputLayoutTelefone = (TextInputLayout) findViewById(R.id.input_layout_rtelefone);
        inputLayoutCpf = (TextInputLayout) findViewById(R.id.input_layout_rcpf);
        inputLayoutEstado = (TextInputLayout) findViewById(R.id.input_layout_restado);
        inputLayoutCidade = (TextInputLayout) findViewById(R.id.input_layout_rcidade);
        inputLayoutEnd = (TextInputLayout) findViewById(R.id.input_layout_rendereco);

        rNomec = (EditText) findViewById(R.id.r_Nomec);
        rEmail = (EditText) findViewById(R.id.r_Email);
        rApe = (EditText) findViewById(R.id.r_Ape);
        rTelefone = (EditText) findViewById(R.id.r_Telefone);
        rCpf = (EditText) findViewById(R.id.r_Cpf);
        rEstado = (EditText) findViewById(R.id.r_Estado);
        rCidade = (EditText) findViewById(R.id.r_Cidade);
        rEnd = (EditText) findViewById(R.id.r_End);
        rPassword = (EditText) findViewById(R.id.r_Password);
        rRPassword = (EditText) findViewById(R.id.r_RPassword);
        rCadastrar = (Button) findViewById(R.id.r_Cadastrar);


        rCadastrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        errorFalse();
        checkInputLayout();
    }

    private void checkInputLayout() {

        if (!validateEmail(rEmail.getText().toString())) {
            inputLayoutEmail.setError(getString(R.string.erro_msg_email));
            requestFocus(rEmail);
        } else if (!validateField(inputLayoutrNamec)) {
            inputLayoutrNamec.setError(getString(R.string.erro_msg_nome));

        } else if (!validateField(inputLayoutrApe)) {
            inputLayoutrApe.setError(getString(R.string.erro_msg_ape));
        } else if (!validateField(inputLayoutTelefone)) {
            inputLayoutTelefone.setError(getString(R.string.erro_msg_telefone));
            requestFocus(rTelefone);
        } else if (!isValidCPF(rCpf.getText().toString())) {
            inputLayoutCpf.setError(getString(R.string.erro_msg_cpf));
            requestFocus(rCpf);
        } else if (!validateField(inputLayoutEstado)) {
            inputLayoutEstado.setError(getString(R.string.erro_msg_estado));
            requestFocus(rEstado);
        } else if (!validateField(inputLayoutCidade)) {
            inputLayoutCidade.setError(getString(R.string.erro_msg_cidade));
            requestFocus(rCidade);
        } else if (!validateField(inputLayoutEnd)) {
            inputLayoutEnd.setError(getString(R.string.erro_msg_end));
            requestFocus(rEnd);
        } else if (!validateField(inputLayoutPassword) || rPassword.getText().toString().length() < 8) {
            inputLayoutPassword.setError(getString(R.string.erro_msg_password));
            requestFocus(rPassword);
        } else if (!validateField(inputLayoutrPassword) || !comparaPassword(rPassword.getText().toString(), rRPassword.getText().toString())) {
            inputLayoutrPassword.setError(getString(R.string.erro_msg_compara_password));
            requestFocus(rRPassword);
        }
        //Todos validados
        else {

            CadastrarCliente cliente = new CadastrarCliente();
            cliente.setNome(this.rNomec.getText().toString());
            cliente.setEmail(this.rEmail.getText().toString());
            cliente.setApelido(this.rApe.getText().toString());
            cliente.setTelefone(this.rTelefone.getText().toString());
            cliente.setCpf(Long.valueOf(this.rCpf.getText().toString()));
            cliente.setEstado(this.rEstado.getText().toString());
            cliente.setCidade(this.rCidade.getText().toString());
            cliente.setEndereco(this.rEnd.getText().toString());
            cliente.setSenha(this.rPassword.getText().toString());

            this.clienteService = new ClienteService();

            boolean criado = this.clienteService.cadastrarCliente(cliente);

            if (criado){
                errorFalse();
                requestFocus(rCadastrar);
                Toast.makeText(this, "Usuário cadastrado", Toast.LENGTH_LONG).show();
                Intent userCadastrado = new Intent(FormularioActivity.this, SignInActivity.class);
                startActivity(userCadastrado);
                finish();
            }else{
                Toast.makeText(this, "Usuário não cadastrado, tente novamente", Toast.LENGTH_LONG).show();
            }


        }
    }

        // setar o foco de um determinado componente
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void errorFalse(){
        inputLayoutEmail.setErrorEnabled(false);
        inputLayoutrNamec.setErrorEnabled(false);
        inputLayoutEmail.setErrorEnabled(false);
        inputLayoutPassword.setErrorEnabled(false);
        inputLayoutrPassword.setErrorEnabled(false);
        inputLayoutrApe.setErrorEnabled(false);
        inputLayoutTelefone.setErrorEnabled(false);
        inputLayoutCpf.setErrorEnabled(false);
        inputLayoutEstado.setErrorEnabled(false);
        inputLayoutCidade.setErrorEnabled(false);
        inputLayoutEnd.setErrorEnabled(false);
    }

}

