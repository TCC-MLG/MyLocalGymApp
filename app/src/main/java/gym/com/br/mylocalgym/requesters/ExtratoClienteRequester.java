package gym.com.br.mylocalgym.requesters;

import android.os.StrictMode;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import gym.com.br.mylocalgym.Parameters.CadastrarClienteParameter;
import gym.com.br.mylocalgym.models.CadastrarCliente;
import gym.com.br.mylocalgym.models.ExtratoCliente;
import gym.com.br.mylocalgym.presenters.ExtratoClientePresenter;
import gym.com.br.mylocalgym.presenters.LoginPresenter;

/**
 * Created by Matheus on 15/10/2016.
 */

public class ExtratoClienteRequester {

    private void ativarPolicy(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public List<ExtratoCliente> listarExtratoCliente(Integer id, Integer dias) {

        this.ativarPolicy();

        final String url = "http://192.168.43.48:8080/mylocalgym/resources/transacao/historico/cliente/"+2+"/"+20+"";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try {
            List<ExtratoClientePresenter> clientePresenters = (List<ExtratoClientePresenter>) restTemplate.getForObject(url, ExtratoClientePresenter.class);

            List<ExtratoCliente> clientes = new ArrayList<>();

            if (clientePresenters != null) {
                for (ExtratoClientePresenter cliente : clientePresenters) {
                    clientes.add(cliente.convert());
                }
            }
            return clientes;
        } catch (Exception e) {

            return null;
        }
    }






    }
