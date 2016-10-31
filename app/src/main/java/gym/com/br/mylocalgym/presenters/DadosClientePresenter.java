package gym.com.br.mylocalgym.presenters;

import gym.com.br.mylocalgym.models.DadosCliente;

/**
 * Created by Luciano on 30/10/2016.
 */

public class DadosClientePresenter {

    private String nome;
    private String apelido;
    private String telefone;
    private String estado;
    private String cidade;
    private String endereco;
    private String senha;

    public DadosCliente convert(){

        DadosCliente dadosCliente = new DadosCliente();
        dadosCliente.setNome(this.nome);
        dadosCliente.setApelido(this.apelido);
        dadosCliente.setTelefone(this.telefone);
        dadosCliente.setEstado(this.estado);
        dadosCliente.setCidade(this.cidade);
        dadosCliente.setEndereco(this.endereco);
        dadosCliente.setSenha(this.senha);

        return dadosCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSenha() {
        return senha;
    }
}
