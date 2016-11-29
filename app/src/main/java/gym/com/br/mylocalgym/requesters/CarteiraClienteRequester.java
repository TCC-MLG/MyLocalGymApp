package gym.com.br.mylocalgym.requesters;

import android.os.StrictMode;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

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

        final String url = "http://192.168.43.220:8080/mylocalgym/resources/carteira/cliente/saldo/"+id+"";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{
            SaldoClientePresenter saldo = restTemplate.getForObject(url, SaldoClientePresenter.class);

            return saldo != null ? saldo.convert() : null ;
        }catch (Exception e){

            return null;
        }
    }

    public void inserirSlado(Integer clienteId, BigDecimal valor) {

        this.ativarPolicy();

        if (clienteId != null){

            final String url = "http://192.168.43.220:8080/mylocalgym/resources/carteira/cliente/"+clienteId+"/inserir/"+valor+"";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            try {

                Boolean saldo = restTemplate.getForObject(url, Boolean.class);

            } catch (Exception e) {

                e.printStackTrace();

            }
        }

    }
}
