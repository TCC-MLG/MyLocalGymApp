package gym.com.br.mylocalgym.services;

import gym.com.br.mylocalgym.models.CadastrarCliente;
import gym.com.br.mylocalgym.requesters.ClienteRequester;

/**
 * Created by Luciano on 12/10/2016.
 */

public class ClienteService {

    private ClienteRequester clienteRequester;

    public boolean cadastrarCliente(CadastrarCliente cliente){

        this.clienteRequester = new ClienteRequester();

        boolean criado = this.clienteRequester.cadastrarCliente(cliente);

        return criado;
    }

}
