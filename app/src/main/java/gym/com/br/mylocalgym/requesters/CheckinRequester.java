package gym.com.br.mylocalgym.requesters;

import android.os.StrictMode;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import gym.com.br.mylocalgym.Parameters.SolicitarCheckinParameter;
import gym.com.br.mylocalgym.models.DadosAcademia;
import gym.com.br.mylocalgym.presenters.DadosAcademiaPresenter;

/**
 * Created by Matheus on 23/10/2016.
 */

public class CheckinRequester {

    private void ativarPolicy(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public Integer solicitarCheckin(Integer clienteId, Integer academiaId) {

        this.ativarPolicy();

        if (clienteId == null && academiaId == null){
            return null;
        }

        final String url = "http://192.168.43.220:8080/mylocalgym/resources/checkin/solicitar";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        SolicitarCheckinParameter parameter = new SolicitarCheckinParameter();
        parameter.setClienteId(clienteId);
        parameter.setAcademiaId(academiaId);

        try {

            Integer saldo = restTemplate.postForObject(url, parameter, Integer.class);

            return saldo;
        } catch (Exception e) {


        }
        return null;
    }

    public boolean verificarSolicitacao(Integer clienteId,  Integer checkinId){

        this.ativarPolicy();

        final String url = "http://192.168.43.220:8080/mylocalgym/resources/checkin/solicitar/status/"+clienteId+"/"+checkinId+"";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{

            boolean saldo = restTemplate.getForObject(url, Boolean.class);

            return saldo;
        }catch (Exception e){

        }
        return false;
    }

    public DadosAcademia buscarAcademiaPorId(String nome){

        this.ativarPolicy();

        final String url = "http://192.168.43.220:8080/mylocalgym/resources/academia/"+nome+"";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{

            DadosAcademiaPresenter dadosAcademia = restTemplate.getForObject(url, DadosAcademiaPresenter.class);

            return dadosAcademia != null ? dadosAcademia.convert() : new DadosAcademia();
        }catch (Exception e){

        }
        return new DadosAcademia();
    }

}