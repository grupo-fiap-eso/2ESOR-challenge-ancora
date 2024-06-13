package model;

public class Funcionario {
    private Integer funcionario_id;
    private Integer empresa_id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    
    public Funcionario() {
    }
    
    public Integer getFuncionario_id() {
        return funcionario_id;
    }
    
    public void setFuncionario_id(Integer funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
    
    public Integer getEmpresa_id() {
        return empresa_id;
    }
    
    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
