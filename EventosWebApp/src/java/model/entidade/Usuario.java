/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

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
    private int  id_usuario;
    private String senha;
    
    /**
     * Construtor padrão, onde será uma nova Instancia de Usuario será criado com um identificador unico
     */
    public Usuario(int id_usuario) {
        this.setId_usuario(id_usuario);
    }

    /**
     * @param id_usuario    int
     * @param login     String
     * @param nome      String
     * @param idade     int
     * @param senha     String
     */
    public Usuario(String login, String nome, int idade, int id_usuario, String senha) {
        this(id_usuario);
        this.login = login;
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
    }
    
    

    /**
     * @return int  A id do Usuario.
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * 
     * Metodo privado pois deve ser utilizado somente pelos objetos Usuario e em
     * seu construtor.
     *
     * @param id_usuario    int que sera usado como o id do usuario
     */
    private void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * 
     * @return login    String contendo o login do Usuario
     */
    public String getLogin() {
        return login;
    }

    /**
     * 
     * @param login String
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * 
     * @return nome String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Configura o nome do usuario e caso o parametro passado seja uma String
     * vazia ele lançara uma IllegalArgumentException
     *
     * @param nome - String que será utlizada para configurar o nome do Usuario
     * @throws IllegalArgumentException - caso o parametro seja uma string vazia
     */
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.equals("")) {
            throw new IllegalArgumentException("O nome do usuário não pode ser vazio");
        } else {
            this.nome = nome;
        }
    }

    /**
     * 
     * @return int  contendo a idade do usuario
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Configura a idade de um usuário aceitando apenas numero inteiro e maior
     * que 0
     *
     * @param idade - int
     * @throws IllegalArgumentException - caso a idade seja menor do que 1
     */
    public void setIdade(int idade) throws IllegalArgumentException {
        if (idade < 1) {
            throw new IllegalArgumentException("Idade informada é invalida! Por favor, informe um numero! Exemplo: 20");
        } else {
            this.idade = idade;
        }
    }

    /**
     * 
     * @return senha    String
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Configura a senha do usuário e caso seja preenchido o campo sem a senha
     * sera lançada a exceção IllegalArgumentException
     *
     * @param senha - String
     * @throws IllegalArgumentException - caso a senha seja uma String vazia
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
     * <strong>Nome:</strong> Fulano da Silva <br>
     * <strong>Idade:</strong> 30 <br>
     * <strong>Login:</strong> meulogin@email.com <br>
     *
     * @return String -  contendo os dados de um usuario
     */
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\t"
                + " Idade: " + this.getIdade() + "\t"
                + " Login: " + this.getLogin() + "\n" ;
    }

}
