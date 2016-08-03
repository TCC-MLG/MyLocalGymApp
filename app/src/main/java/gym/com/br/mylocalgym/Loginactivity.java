package gym.com.br.mylocalgym;

import android.content.*;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;

public class Loginactivity extends AppCompatActivity {

    private EditText lgUsername;
    private EditText lgPassword;
    private Button lgLogin;
    private TextView lgRegisterlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        lgUsername = (EditText)findViewById(R.id.mEnd);
        lgPassword = (EditText)findViewById(R.id.lgPassword);
        lgLogin = (Button)findViewById(R.id.mOk);
        lgRegisterlink = (TextView)findViewById(R.id.lgRegisterLink);

        lgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder btn = new AlertDialog.Builder(Loginactivity.this);
                btn.setMessage(lgUsername.getText().toString() +' '+ lgPassword.getText().toString());
                btn.setNeutralButton("OK", null);
                btn.show();
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
}