package gym.com.br.mylocalgym.requesters;

import android.os.StrictMode;


import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import gym.com.br.mylocalgym.presenters.LoginPresenter;

/**
 * Created by Luciano on 08/10/2016.
 */

public class LoginRequester {


    private void ativarPolicy(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    public LoginPresenter autenticar(String email, String senha){

        this.ativarPolicy();

        final String url = "http://192.168.43.64:8080/mylocalgym/resources/login/autenticar/"+email+"/"+senha+"";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        try{
            LoginPresenter login = restTemplate.getForObject(url, LoginPresenter.class);

            return login;
        }catch (Exception e){

            return null;
        }


    }


}
