package builder;

import model.entidade.Usuario;

/**
 *
 * @author elciotaira
 */
public class UsuarioBuilder {

    private String login;
    private String nome;
    private int idade;
    private String senha;

    public UsuarioBuilder() {
    }

    public UsuarioBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public UsuarioBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public UsuarioBuilder setIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public UsuarioBuilder setSenha(String senha) {
        this.senha = senha;
        return this;
    }
    
    public Usuario builder(){
        return new Usuario(login, nome, idade, senha);
    }
      
}
