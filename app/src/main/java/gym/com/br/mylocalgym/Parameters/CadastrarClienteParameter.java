package gym.com.br.mylocalgym.Parameters;

import gym.com.br.mylocalgym.models.CadastrarCliente;

/**
 * Created by Luciano on 12/10/2016.
 */

public class CadastrarClienteParameter {

    private String nome;
    private String email;
    private String apelido;
    private String telefone;
    private Long cpf;
    private String estado;
    private String cidade;
    private String endereco;
    private String senha;

    public void createParameter(CadastrarCliente cliente){

        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.apelido = cliente.getApelido();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.estado = cliente.getEstado();
        this.cidade = cliente.getCidade();
        this.endereco = cliente.getEndereco();
        this.senha = cliente.getSenha();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
