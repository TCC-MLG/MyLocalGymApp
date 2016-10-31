package gym.com.br.mylocalgym.models;

/**
 * Created by Luciano on 30/10/2016.
 */

public class DadosCliente {

    private String nome;
    private String apelido;
    private String telefone;
    private String estado;
    private String cidade;
    private String endereco;
    private String senha;
    private byte[] exame;
    private byte[] foto;
    String vamos;

    public DadosCliente(){}

    public DadosCliente(String nome, String apelido, String telefone, String estado, String cidade, String endereco, String senha, byte[] exame, byte[] foto) {

        this.nome = nome.toString();
        this.apelido = apelido;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.senha = senha;
        this.exame = exame;
        this.foto = foto;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public byte[] getExame() {
        return exame;
    }

    public void setExame(byte[] exame) {
        this.exame = exame;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
