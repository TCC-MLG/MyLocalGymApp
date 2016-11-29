package gym.com.br.mylocalgym.requesters;

import android.os.StrictMode;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import gym.com.br.mylocalgym.Parameters.AlterarExameParameter;
import gym.com.br.mylocalgym.Parameters.CadastrarClienteParameter;
import gym.com.br.mylocalgym.models.CadastrarCliente;
import gym.com.br.mylocalgym.models.DadosCliente;
import gym.com.br.mylocalgym.presenters.DadosClientePresenter;
import gym.com.br.mylocalgym.presenters.ExamePresenter;

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
        final String url = "http://192.168.43.220:8080/mylocalgym/resources/cliente/cadastrar";
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

    public boolean alterarCliente(Integer id, DadosCliente dadosCliente){

        this.ativarPolicy();
        final String url = "http://192.168.43.220:8080/mylocalgym/resources/cliente/"+id+"/alterar";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        try {

            Boolean alterado = restTemplate.postForObject(url, dadosCliente, Boolean.class);

            return alterado;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public DadosCliente buscarDadosCliente(Integer id){

        this.ativarPolicy();

        final String url = "http://192.168.43.220:8080/mylocalgym/resources/cliente/"+id+"";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{
            DadosClientePresenter clientePresenter = restTemplate.getForObject(url, DadosClientePresenter.class);

            return clientePresenter != null ?  clientePresenter.convert() : null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean atualizarExame(Integer clienteId, byte[] exame) {

        this.ativarPolicy();

        final String url = "http://192.168.43.220:8080/mylocalgym/resources/cliente/"+clienteId+"/alterar/exame";

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        boolean alterado =false;
        try {

            AlterarExameParameter parameter = new AlterarExameParameter();
            parameter.setExame(exame);

            alterado = restTemplate.postForObject(url,parameter, Boolean.class);

        }catch (Exception e){
            e.printStackTrace();
        }
        return alterado;
    }

    public byte[] buscarExame(Integer clienteId) {

        this.ativarPolicy();

        final String url = "http://192.168.43.220:8080/mylocalgym/resources/cliente/"+clienteId+"/exame";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{
            ExamePresenter examePresenter = restTemplate.getForObject(url, ExamePresenter.class);

            return examePresenter != null ?  examePresenter.getExame() : null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}
