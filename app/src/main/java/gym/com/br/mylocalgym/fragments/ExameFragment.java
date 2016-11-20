package gym.com.br.mylocalgym.fragments;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

import gym.com.br.mylocalgym.R;
import gym.com.br.mylocalgym.services.ClienteService;
import gym.com.br.mylocalgym.utils.SessionManager;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExameFragment extends Fragment {

    public static final int IMAGEM_INTERNA = 12;

    private ImageView ex_Imagem;
    private EditText ex_BExame;
    private EditText ex_Status;
    private Button ex_pegar_exame;
    private Button ex_btnEnviar;
    private Integer clienteId;

    private byte[] imagem;
    private byte[] exame;

    private ClienteService clienteService;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_exame, container, false);

        ex_Imagem = (ImageView) rootview.findViewById(R.id.ex_Imagem);
        ex_BExame = (EditText) rootview.findViewById(R.id.ex_BExame);
        ex_Status = (EditText) rootview.findViewById(R.id.ex_Status);
        ex_pegar_exame = (Button) rootview.findViewById(R.id.ex_pegar_exame);
        ex_btnEnviar = (Button) rootview.findViewById(R.id.ex_btnEnviar);

        this.buscarSessao();

        this.clienteService = new ClienteService();

        //this.exame = this.clienteService.buscarExame(this.clienteId);

        ex_pegar_exame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pegarImagem();
            }
        });

        ex_btnEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (imagem != null) {
                    clienteService = new ClienteService();

                    boolean atualizado = clienteService.atualizarExame(clienteId, imagem);

                    if (atualizado) {
                        ex_Status.setText("Atualizado");
                    }else{
                        ex_Status.setText("Não atualizado");
                    }
                }else{
                    Toast.makeText(getContext(), "Por favor selecionar exame!", Toast.LENGTH_LONG).show();
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
            }
        }
    }

    private byte[] writeObject(Bitmap bitmap) {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        byte[] byteArray = stream.toByteArray();

        return byteArray;
    }

    private Bitmap readObject(byte[] byteArray) throws IOException {

        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        return bitmap;
    }


    private void buscarSessao() {

        SessionManager sessionManager = new SessionManager(getContext());
        HashMap<String, String> user = sessionManager.getUserDetails();
        clienteId = Integer.parseInt(user.get(sessionManager.KEY_ID));
    }
}
