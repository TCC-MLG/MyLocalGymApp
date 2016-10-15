package gym.com.br.mylocalgym.models;

import java.math.BigDecimal;

/**
 * Created by Matheus on 15/10/2016.
 */

public class SaldoCliente {

    private BigDecimal saldo;
    private String validade;

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
