package gym.com.br.mylocalgym.services;

import gym.com.br.mylocalgym.models.CadastrarCliente;
import gym.com.br.mylocalgym.models.DadosCliente;
import gym.com.br.mylocalgym.requesters.ClienteRequester;

/**
 * Created by Luciano on 12/10/2016.
 */

public class ClienteService {

    private ClienteRequester clienteRequester;

    public boolean cadastrarCliente(CadastrarCliente cliente) {

        this.clienteRequester = new ClienteRequester();

        boolean criado = this.clienteRequester.cadastrarCliente(cliente);

        return criado;
    }

    public boolean alterarCliente(Integer id, DadosCliente cliente) {

        this.clienteRequester = new ClienteRequester();

        return this.clienteRequester.alterarCliente(id, cliente);
    }

    public DadosCliente buscarDadosCliente(Integer id) {

        this.clienteRequester = new ClienteRequester();

        return this.clienteRequester.buscarDadosCliente(id);
    }

    public boolean atualizarExame(Integer clienteId, byte[] exame) {

        this.clienteRequester = new ClienteRequester();

        return this.clienteRequester.atualizarExame(clienteId, exame);
    }

    public byte[] buscarExame(Integer clienteId) {

        this.clienteRequester = new ClienteRequester();

        return this.clienteRequester.buscarExame(clienteId);
    }
}
