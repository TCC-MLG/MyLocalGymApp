package gym.com.br.mylocalgym.fragments;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.models.DadosCliente;
import gym.com.br.mylocalgym.services.ClienteService;
import gym.com.br.mylocalgym.utils.Img;
import gym.com.br.mylocalgym.utils.SessionManager;

import static android.app.Activity.RESULT_OK;

public class DadosPessoaisFragment extends Fragment {

    public static final int IMAGEM_INTERNA = 12;

    private EditText dpNome;
    private EditText dpApe;
    private EditText dpTelefone;
    private EditText dpExame;
    private EditText dpTreino;
    private EditText estado;
    private EditText cidade;
    private EditText endereco;
    private EditText senha;
    private byte[] exame;
    private byte[] foto;

    private Button dpSalvar;
    private Button pegarImagem;
    private Button pegarExame;

    private Integer clienteId;
    private boolean foiFoto = false;

    private DadosCliente dadosCliente;

    private byte[] imagem;

    private ClienteService clienteService;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_dados_pessoais, container, false);

        SessionManager sessionManager = new SessionManager(getContext());
        // Pega da sessão as informações do usuário
        HashMap<String, String> user = sessionManager.getUserDetails();
        clienteId = Integer.parseInt(user.get(sessionManager.KEY_ID));

        clienteService = new ClienteService();

        dadosCliente = this.clienteService.buscarDadosCliente(clienteId);

        dpNome = (EditText) rootview.findViewById(R.id.dp_Nomec);
        dpApe = (EditText) rootview.findViewById(R.id.dp_Ape);
        dpTelefone = (EditText) rootview.findViewById(R.id.dp_Telefone);
        estado = (EditText) rootview.findViewById(R.id.dp_estado);
        cidade = (EditText) rootview.findViewById(R.id.dp_cidade);
        endereco = (EditText) rootview.findViewById(R.id.dp_endereco);
        senha = (EditText) rootview.findViewById(R.id.dp_senha);
        dpExame = (EditText) rootview.findViewById(R.id.dp_Exame);
        dpTreino = (EditText) rootview.findViewById(R.id.dp_Treinos);

        dpSalvar = (Button) rootview.findViewById(R.id.dp_Salvar);
        pegarImagem = (Button) rootview.findViewById(R.id.dp_pegar_imagem);
        pegarExame = (Button) rootview.findViewById(R.id.dp_pegar_examee);

        dpNome.setText(dadosCliente.getNome());
        dpApe.setText(dadosCliente.getApelido());
        dpTelefone.setText(dadosCliente.getTelefone());
        estado.setText(dadosCliente.getEstado());
        cidade.setText(dadosCliente.getCidade());
        endereco.setText(dadosCliente.getEndereco());
        senha.setText(dadosCliente.getSenha());

        dpExame.setText("Exame Arquivo");
        dpTreino.setText("selecionar imagem");

        pegarImagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                foiFoto = true;
                pegarImagem();

            }
        });

        pegarExame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foiFoto = false;
                pegarImagem();
            }
        });


        dpSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DadosCliente dadosCliente = new DadosCliente(
                        dpNome != null ? dpNome.getText().toString() : null
                        , dpApe != null ? dpApe.getText().toString() : null
                        , dpTelefone != null ? dpTelefone.getText().toString() : null
                        , estado != null ? estado.getText().toString() : null
                        , cidade != null ? cidade.getText().toString() : null
                        , endereco != null ? endereco.getText().toString() : null
                        , senha != null ? senha.getText().toString() : null
                        , exame
                        , foto);

                clienteService = new ClienteService();
                boolean alterado = clienteService.alterarCliente(clienteId, dadosCliente);

                if (alterado) {
                    Toast.makeText(getContext(), "Os alterações foram salvas com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Os alterações não foram salvas, tente novamente ", Toast.LENGTH_LONG).show();
                }
            }
        });

        return rootview;
    }

    private void pegarImagem() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGEM_INTERNA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == IMAGEM_INTERNA) {
            if (resultCode == RESULT_OK) {

                Uri imagemSelecionada = intent.getData();

                String[] colunas = {MediaStore.Images.Media.DATA};

                Cursor cursor = getActivity().getContentResolver().query(imagemSelecionada, colunas, null, null, null);
                cursor.moveToFirst();

                int indexColuna = cursor.getColumnIndex(colunas[0]);
                String pathImg = cursor.getString(indexColuna);
                cursor.close();

                Bitmap bitmap = BitmapFactory.decodeFile(pathImg);

                this.imagem = writeObject(bitmap);

                if (foiFoto) {
                    this.foto = writeObject(bitmap);
                } else {
                    this.exame = writeObject(bitmap);
                }

            }
        }
    }

    private byte[] writeObject(Bitmap bitmap) {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        byte[] byteArray = stream.toByteArray();

        System.out.println("");

        return byteArray;
    }

    private Bitmap readObject(byte[] byteArray) throws IOException {

        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        return bitmap;
    }

}