package gym.com.br.mylocalgym.requesters;

import android.os.StrictMode;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;

import gym.com.br.mylocalgym.models.Greeting;

/**
 * Created by Luciano on 08/10/2016.
 */

public class LoginRequester {


    private void ativarPolicy(){

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);


    }


    public Object autenticar(String email, String senha){

        this.ativarPolicy();



        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://rest-service.guides.spring.io/greeting");

        HttpResponse response;
        try {

            response = client.execute(request);

            //Greeting greeting = objectMapper.readValue(response.getEntity().getContent(), MyObject.class);

            Log.d("Response of GET request", response.toString());

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.print("opa");


        return new Object();
    }


}
