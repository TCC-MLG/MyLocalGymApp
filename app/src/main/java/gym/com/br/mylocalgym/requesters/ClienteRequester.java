package gym.com.br.mylocalgym.requesters;

import android.os.StrictMode;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import gym.com.br.mylocalgym.Parameters.CadastrarClienteParameter;
import gym.com.br.mylocalgym.models.CadastrarCliente;

/**
 * Created by Luciano on 12/10/2016.
 */

public class ClienteRequester {

    private void ativarPolicy(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public boolean cadastrarCliente(CadastrarCliente cliente) {

        this.ativarPolicy();
        final String url = "http://192.168.43.64:8080/mylocalgym/resources/cliente/cadastrar";
        CadastrarClienteParameter parameter = new CadastrarClienteParameter();
        parameter.createParameter(cliente);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try {
            restTemplate.postForObject(url, parameter, CadastrarClienteParameter.class);

            System.out.println("opa");

        }catch (Exception e){

            return false;

        }

        return true;
    }
}
