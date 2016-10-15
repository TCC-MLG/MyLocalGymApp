package gym.com.br.mylocalgym.requesters;

import android.os.StrictMode;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import gym.com.br.mylocalgym.models.SaldoCliente;
import gym.com.br.mylocalgym.presenters.SaldoClientePresenter;

/**
 * Created by Matheus on 15/10/2016.
 */

public class CarteiraClienteRequester {

    private void ativarPolicy(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    public SaldoCliente buscarSaldoPorId(Long id){

        this.ativarPolicy();

        final String url = "http://192.168.43.48:8080/mylocalgym/resources/carteira/cliente/saldo/"+id+"";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{
            SaldoClientePresenter saldo = restTemplate.getForObject(url, SaldoClientePresenter.class);

            return saldo != null ? saldo.convert() : null ;
        }catch (Exception e){

            return null;
        }
    }

}
