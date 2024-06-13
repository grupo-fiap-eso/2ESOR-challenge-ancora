package model;

import java.sql.Timestamp;

public class Participacao {
    private Integer participacao_id;
    private Integer funcionario_id;
    private Integer evento_id;
    private Integer tempo_participacao;
    private Integer pontos;
    private Timestamp criado_em;
    
    public Participacao() {
    }
    
    public Integer getParticipacao_id() {
        return participacao_id;
    }
    
    public void setParticipacao_id(Integer participacao_id) {
        this.participacao_id = participacao_id;
    }
    
    public Integer getFuncionario_id() {
        return funcionario_id;
    }
    
    public void setFuncionario_id(Integer funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
    
    public Integer getEvento_id() {
        return evento_id;
    }
    
    public void setEvento_id(Integer evento_id) {
        this.evento_id = evento_id;
    }
    
    public Integer getTempo_participacao() {
        return tempo_participacao;
    }
    
    public void setTempo_participacao(Integer tempo_participacao) {
        this.tempo_participacao = tempo_participacao;
    }
    
    public Integer getPontos() {
        return pontos;
    }
    
    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }
    
    public Timestamp getCriado_em() {
        return criado_em;
    }
    
    public void setCriado_em(Timestamp criado_em) {
        this.criado_em = criado_em;
    }
}
