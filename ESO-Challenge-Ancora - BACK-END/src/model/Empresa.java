package model;

public class Empresa {
    private Integer empresa_id;
    private String cnpj;
    private String nome;
    private String endereco;

    public Empresa(Integer empresa_id, String cnpj, String nome, String endereco) {
        this.empresa_id = empresa_id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Integer getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
