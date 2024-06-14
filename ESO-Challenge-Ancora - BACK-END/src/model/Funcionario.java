package model;

import exceptions.FuncionarioException;

public class Funcionario {
    private Integer funcionario_id;
    private Empresa empresa;
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public Funcionario(Integer funcionario_id, Empresa empresa, String nome, String cpf, String email, String senha) throws FuncionarioException {
        this.funcionario_id = funcionario_id;
        this.empresa = empresa;
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        this.senha = senha;
    }

    public Integer getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(Integer funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws FuncionarioException {
        if (nome == null || nome.isEmpty()) {
            throw new FuncionarioException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws FuncionarioException {
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new FuncionarioException("CPF inválido");
        }
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws FuncionarioException {
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new FuncionarioException("Email inválido");
        }
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
