package model;

public class Pontos {
    private Integer ponto_id;
    private Integer funcionario_id;
    private Integer total_pontos;
    
    public Pontos() {
    }
    
    public Integer getPonto_id() {
        return ponto_id;
    }
    
    public void setPonto_id(Integer ponto_id) {
        this.ponto_id = ponto_id;
    }
    
    public Integer getFuncionario_id() {
        return funcionario_id;
    }
    
    public void setFuncionario_id(Integer funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
    
    public Integer getTotal_pontos() {
        return total_pontos;
    }
    
    public void setTotal_pontos(Integer total_pontos) {
        this.total_pontos = total_pontos;
    }
}
