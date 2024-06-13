package model;

public class Premios {
    private Integer premio_id;
    private String nome;
    private String descricao;
    private Integer pontos_necessarios;
    
    public Premios() {
    }
    
    public Integer getPremio_id() {
        return premio_id;
    }
    
    public void setPremio_id(Integer premio_id) {
        this.premio_id = premio_id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getPontos_necessarios() {
        return pontos_necessarios;
    }
    
    public void setPontos_necessarios(Integer pontos_necessarios) {
        this.pontos_necessarios = pontos_necessarios;
    }
}
