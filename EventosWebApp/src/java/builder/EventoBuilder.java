package builder;

import entidade.Evento;

/**
 *
 * @author elciotaira
 * @since 26/01/2021
 */
public class EventoBuilder{

    private static Integer incrementaId;
    private int id_evento;
    private String tipo;
    private String descricao;
    private double valor;
    private int faixaEtaria;
    private String nome;
    private int id_usuario;

    public EventoBuilder setIncrementaId(Integer incrementaId) {
        EventoBuilder.incrementaId = incrementaId;
        return this;
    }
    public EventoBuilder setId_evento(int id_evento) {
        this.id_evento = id_evento;
        return this;
    }
    public EventoBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }
    public EventoBuilder setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
    public EventoBuilder setValor(double valor) {
        this.valor = valor;
        return this;
    }
    public EventoBuilder setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
        return this;
    }
    public EventoBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }
    public EventoBuilder setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
        return this;
    }
    public Evento build(){
        return new Evento(tipo, descricao, valor, faixaEtaria, nome, id_usuario);
    }
    
}
