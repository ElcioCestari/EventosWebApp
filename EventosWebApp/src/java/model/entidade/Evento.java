/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

/**
 * Essa classe modela os metodos e atributos que um evento deve possuir
 *
 * @author Elcio CEstari Taira
 * @version 1.0
 * @since 25/mar/2017
 */
public class Evento {

    private static Integer incrementaId;
    private int id_evento;
    private String tipo;
    private String descricao;
    private double valor;
    private int faixaEtaria;
    private String nome;
    private int id_usuario;

    /**
     * Configura um objeto do tipo Evento com nenhum parametro apenas atribuindo a id_evento um inteiro positivo unico para cada instancia de um Evento
     */
    public Evento() {
        if(incrementaId == null){
            incrementaId = 1;
        }
        else{
            incrementaId++;
        }
        this.setId_evento(incrementaId);
    }

    /**
     * Configura um objeto do tipo Evento
     * @param tipo  String
     * @param descricao String
     * @param valor double
     */
    public Evento(String tipo, String descricao, double valor) {
        this();
        this.setTipo(tipo);
        this.setDescricao(descricao);
        this.setValor(valor);
    }

    /**
     * Configura um objeto Evento
     * @param tipo  String
     * @param descricao String
     * @param valor double
     * @param faixaEtaria   int
     */
    public Evento( String tipo, String descricao, double valor, int faixaEtaria) {
        this(tipo, descricao, valor);
        this.setFaixaEtaria(faixaEtaria);
    }

    /**
     * @param tipo  String
     * @param descricao String
     * @param valor double
     * @param faixaEtaria   int
     * @param nome  String
     */
    public Evento( String tipo, String descricao, double valor, int faixaEtaria, String nome) {
        this(tipo,descricao,valor,faixaEtaria);
        this.setNome(nome);
        
    }

    /**
     * Configura um objeto Evento
     * @param tipo  String
     * @param descricao String
     * @param valor double
     * @param faixaEtaria   int
     * @param nome  String
     * @param id_usuario    int
     */
    public Evento( String tipo, String descricao, double valor, int faixaEtaria, String nome, int id_usuario) {
        this(tipo,descricao,valor,faixaEtaria,nome);
        this.setId_usuario(id_usuario);
        
    }
    
    /**
     * Retorna a faixa etaria
     * @return faixaEtaria int
     */
    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    /**
     * Configura a faixa etaria
     * 
     * @param faixaEtaria   int
     * @throws IllegalArgumentException Caso a idade seja um valor invalido
     */
    public void setFaixaEtaria(int faixaEtaria) throws IllegalArgumentException{
        if(faixaEtaria < 0){
            throw new IllegalArgumentException("Faixa etaria tem que ser maior que zero");
        }
        this.faixaEtaria = faixaEtaria;
    }

    /**
     * Retorna o id do Evento
     * @return id_evento    int
     */
    public int getId_evento() {
        return id_evento;
    }

    /**
     * Configura o id do evento
     * 
     * @param id_evento int
     * @throws IllegalArgumentException caso o id seja menor do que 1
     */
    private void setId_evento(int id_evento) throws IllegalArgumentException{
        if(id_evento < 1){
            throw new IllegalArgumentException("O id do evento não pode ser um inteiro negativo");
        }
        this.id_evento = id_evento;
    }

    /**
     * Retorna o tipo do Evento.
     * 
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Configura o tipo de um evento
     * 
     * @param tipo
     * @throws IllegalArgumentException se o tipo for vazio ou nulo
     */
    public void setTipo(String tipo) throws IllegalArgumentException{
        if(tipo.equals("") || tipo == null){
            throw new IllegalArgumentException("O tipo não é valido");
        }
        this.tipo = tipo;
    }

    /**
     * Retorna a descrição do Evento
     * 
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Configura a descrição de um Evento
     * 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o valor de um evento
     * 
     * @return 
     */
    public double getValor() {
        return valor;
    }

    /**
     * Configura o valor de um evento.
     * 
     * @param valor double
     * @throws IllegalArgumentException caso o valor seja negativo.
     */
    public void setValor(double valor) throws IllegalArgumentException{
        if(valor < 0){
            throw new IllegalArgumentException("O valor de um evento não pode ser negativo");
        }
        this.valor = valor;
    }

    /**
     * retorna o nome do Evento
     * @return nome String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Configura o nome de um Evento
     * @param nome  String
     * @throws IllegalArgumentException Caso o parametro tenha um valor vazio ou nulo.
     */
    public void setNome(String nome) throws IllegalArgumentException{
        if(nome.equals("") || nome == null){
            throw new IllegalArgumentException("O nome do evento é inválido");
        }
        this.nome = nome;
    }

    /**
     * retorna o id de um usuario
     * 
     * @return id_usuario   um inteiro que representa a id do usuario
     */
    public int getId_usuario() {
        return this.id_usuario;
    }
    
    /**
     * Configura o id de um usuario
     * 
     * @param id_usuario    int
     * @throws IllegalArgumentException Lança essa exceção caso o parametro seja um numero menor do que 1
     */
    public void setId_usuario(int id_usuario) throws IllegalArgumentException{
        if(id_usuario < 1){
            throw new IllegalArgumentException("A id_usuario deve ser um inteiro positivo maior que zero");
        }
        this.id_usuario = id_usuario;
    }

}
