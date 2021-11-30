package model;

public class Gerente {
    private String cpf;
    private String nome;
    private String telefone;
    private String data_nascimentog;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String nis;

    public Gerente() {
    }

    public Gerente(String cpf, String nome, String telefone, String data_nascimentog, String rua, String numero, String bairro, String cidade, String nis) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.data_nascimentog = data_nascimentog;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.nis = nis;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData_nascimentog() {
        return data_nascimentog;
    }

    public void setData_nascimentog(String data_nascimentog) {
        this.data_nascimentog = data_nascimentog;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", telefone=" + telefone +
                ", data_nascimentog='" + data_nascimentog + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", nis=" + nis +
                '}';
    }
}
