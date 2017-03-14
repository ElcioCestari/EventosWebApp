/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * <p>
 * Essa Classe faz a modelagem do usuario, que é a entidade que acessa o sistema
 * EventosWebApp e usufrui das suas funcionalides:
 * </p>
 * <ul>
 * <li>fazer login</li>
 * <li>divulgar evento</li>
 * <li>curtir evento</li>
 * <li>cancelar curtir evento</li>
 * <li>nao curtir evento</li>
 * <li>cancelar não curtir evento</li>
 * </ul>
 *
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 10/mar/2017
 */
public class Usuario {

    private String login;
    private String nome;
    private int idade;
    private int id_usuario;
    private String senha;

    public Usuario() {
    }

    public Usuario(String login, String nome, int idade, int id_usuario, String senha) {
        this(login, nome, idade, senha);
        this.setId_usuario(id_usuario);
    }

    public Usuario(String login, String nome, int idade, String senha) {
        this.setIdade(idade);
        this.setLogin(login);
        this.setNome(nome);
        this.setSenha(senha);
    }

    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Metodo privado pois deve ser utilizado somente pelos objetos Usuario e em
     * seu construtor.
     *
     * @param id_usuario
     *
     */
    private void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    /**
     * Configura o nome do usuario e caso o parametro passado seja uma String
     * vazia ele lançara uma IllegalArgumentException
     *
     * @param nome
     * @throws IllegalArgumentException
     */
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.equals("")) {
            throw new IllegalArgumentException("O nome do usuário não pode ser vazio");
        } else {
            this.nome = nome;
        }
    }

    public int getIdade() {
        return idade;
    }

    /**
     * Configura a idade de um usuário aceitando apenas numero inteiro e maior
     * que 0
     *
     * @param idade
     * @throws IllegalArgumentException
     */
    public void setIdade(int idade) throws IllegalArgumentException {
        if (idade < 1) {
            throw new IllegalArgumentException("Idade informada é invalida! Por favor, informe um numero! Exemplo: 20");
        } else {
            this.idade = idade;
        }
    }

    public String getSenha() {
        return senha;
    }

    /**
     * Configura a senha do usuário e caso seja preenchido o campo sem a senha
     * sera lançada a exceção IllegalArgumentException
     *
     * @param senha
     * @throws IllegalArgumentException
     */
    public void setSenha(String senha) throws IllegalArgumentException {
        if (senha.equals("")) {
            throw new IllegalArgumentException("Uma senha é obrigátoria!");
        } else {
            this.senha = senha;
        }
    }

    /**
     * retorna uma String contendo o nome o login e a idade de um usuario no
     * seguinte formato:
     * <strong>Nome: Fulano da Silva Idade: 30 Login:
     * meulogin@email.com</strong>
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome()
                + "Idade: " + this.getIdade()
                + "Login: " + this.getLogin();
    }

}
