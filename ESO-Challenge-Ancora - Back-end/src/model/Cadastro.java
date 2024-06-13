package model;

public class Cadastro {
    private String nro_documento;
    private String nome;
    private String tipo;
    private String email;
    private String telefone;
    private String estado;
    private String cidade;
    
    public Cadastro() {
    }
    
    public Cadastro(Integer id, String nro_documento, String nome, String tipo, String email, String telefone, String estado, String cidade) {
        this.nro_documento = nro_documento;
        this.nome = nome;
        this.tipo = tipo;
        this.tipo = email;
        this.tipo = telefone;
        this.tipo = estado;
        this.tipo = cidade;
    }
    

    public String getNro_documento() {
        return nro_documento;
    }
    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
}
