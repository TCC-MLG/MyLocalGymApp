package gym.com.br.mylocalgym.presenters;

import java.math.BigDecimal;

import gym.com.br.mylocalgym.models.SaldoCliente;

/**
 * Created by Matheus on 15/10/2016.
 */

public class SaldoClientePresenter {

    private BigDecimal saldo;
    private String validade;

    public SaldoCliente convert(){

        SaldoCliente cliente = new SaldoCliente();
        cliente.setSaldo(this.saldo);
        cliente.setValidade(this.validade);

        return cliente;
    }


    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
