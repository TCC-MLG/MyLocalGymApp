package gym.com.br.mylocalgym.services;

import gym.com.br.mylocalgym.presenters.LoginPresenter;
import gym.com.br.mylocalgym.requesters.LoginRequester;

/**
 * Created by Luciano on 08/10/2016.
 */

public class LoginServices {

    private LoginRequester loginRequester;


    public LoginPresenter autenticar(String email, String senha){

        this.loginRequester = new LoginRequester();

        LoginPresenter cliente = this.loginRequester.autenticar(email, senha);

        return cliente;

    }


}
