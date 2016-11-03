package gym.com.br.mylocalgym.requesters;

import android.os.StrictMode;
import android.os.SystemClock;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

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

        final String url = "http://192.168.43.64:8080/mylocalgym/resources/transacao/historico/cliente/"+id+"/"+dias+"";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try {
            List<LinkedHashMap<String, Object>> clientePresenters = restTemplate.getForObject(url, List.class);

            List<ExtratoCliente> clientes = new ArrayList<>();
            if (clientePresenters != null){
                for (LinkedHashMap<String, Object> presenter : clientePresenters) {
                    clientes.add(this.convert(presenter));
                }

                return clientes;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private ExtratoCliente convert(LinkedHashMap<String, Object> presenter){

       ExtratoCliente cliente = new ExtratoCliente(presenter.get("dataTransacao"), presenter.get("idAcademia"), presenter.get("idTransacao"), presenter.get("razaoSocial"), presenter.get("valor"));

        return cliente;
    }




    }
