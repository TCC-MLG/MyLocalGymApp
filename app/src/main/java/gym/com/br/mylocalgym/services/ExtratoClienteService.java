package gym.com.br.mylocalgym.services;

import java.util.List;

import gym.com.br.mylocalgym.models.ExtratoCliente;
import gym.com.br.mylocalgym.requesters.ExtratoClienteRequester;

/**
 * Created by Matheus on 15/10/2016.
 */

public class ExtratoClienteService {

    private ExtratoClienteRequester requester;

    public List<ExtratoCliente> listarExtratoCliente(Integer id, Integer dias) {

        this.requester = new ExtratoClienteRequester();

        return this.requester.listarExtratoCliente(id, dias);

    }

}
