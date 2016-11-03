package gym.com.br.mylocalgym.services;

import java.math.BigDecimal;

import gym.com.br.mylocalgym.models.SaldoCliente;
import gym.com.br.mylocalgym.requesters.CarteiraClienteRequester;

/**
 * Created by Matheus on 15/10/2016.
 */

public class CarteiraClienteService {

    private CarteiraClienteRequester requester;

    public SaldoCliente buscarSaldoPorId(Long id){

        this.requester = new CarteiraClienteRequester();

        return this.requester.buscarSaldoPorId(id);

    }

    public void inserirSaldo(Integer clienteId, BigDecimal valor) {

        this.requester = new CarteiraClienteRequester();
        this.requester.inserirSlado(clienteId, valor);
    }
}
