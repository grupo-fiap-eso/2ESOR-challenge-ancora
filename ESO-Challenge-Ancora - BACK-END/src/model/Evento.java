package model;

import java.sql.Timestamp;

public class Evento {
    private Integer evento_id;
    private Integer empresa_id;
    private String titulo;
    private String descricao;
    private String tipo_evento;
    private Timestamp data_evento;
    private Integer duracao;
    private Integer vale_pontos;
    private String url_video;
    private Timestamp criado_em;
    
    public Evento() {
    }
    
    public Evento(Integer evento_id, Integer empresa_id, String titulo, String descricao, String tipo_evento,
            Timestamp data_evento, Integer duracao, Integer vale_pontos, String url_video, Timestamp criado_em) {
	  this.evento_id = evento_id;
	  this.empresa_id = empresa_id;
	  this.titulo = titulo;
	  this.descricao = descricao;
	  this.tipo_evento = tipo_evento;
	  this.data_evento = data_evento;
	  this.duracao = duracao;
	  this.vale_pontos = vale_pontos;
	  this.url_video = url_video;
	  this.criado_em = criado_em;
	}
    
    public Integer getEvento_id() {
        return evento_id;
    }
    
    public void setEvento_id(Integer evento_id) {
        this.evento_id = evento_id;
    }
    
    public Integer getEmpresa_id() {
        return empresa_id;
    }
    
    public void setEmpresa_id(Integer empresa_id) {
        this.empresa_id = empresa_id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getTipo_evento() {
        return tipo_evento;
    }
    
    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }
    
    public Timestamp getData_evento() {
        return data_evento;
    }
    
    public void setData_evento(Timestamp data_evento) {
        this.data_evento = data_evento;
    }
    
    public Integer getDuracao() {
        return duracao;
    }
    
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    
    public Integer getVale_pontos() {
        return vale_pontos;
    }
    
    public void setVale_pontos(Integer vale_pontos) {
        this.vale_pontos = vale_pontos;
    }
    
    public String getUrl_video() {
        return url_video;
    }
    
    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }
    
    public Timestamp getCriado_em() {
        return criado_em;
    }
    
    public void setCriado_em(Timestamp criado_em) {
        this.criado_em = criado_em;
    }
}
