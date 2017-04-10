/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

/**
 * Essa classe é responsável por modelar os comentários de um usuario em um
 * evento
 *
 * @author Elcio Cestari Taira
 */
public class Comentario {

    private int id_comentario;//identificador unico que é inclusive utilizado como chave primaria no BD
    private String descricao;//o comentário de fato de um evento. Ex.: "Essa festa vai ser muito boa!" 

    /**
     * Configura os atributos basicos de um comentario: id e descrição
     * @throws IllegalArgumentException caso o id_seja negativo
     * @see #Comentario(java.lang.String) 
     * @see #setId_comentario(int) 
     */
    public Comentario() throws IllegalArgumentException {
        this.setId_comentario(getId_comentario());
    }

    /**
     * Configura a descrição de um comentário através do método setDescricao(String descrição) 
     * @param descricao parametro que será utilizado para configurar a descrição de um Comentário
     * @throws IllegalArgumentException caso o parametro seja uma string vazia ou se o id_comentario seja um inteiro negativo
     * @see #setDescricao(java.lang.String) 
     */
    public Comentario(String descricao) throws IllegalArgumentException {
        this();
        this.setDescricao(descricao);
    }

    /**
     * Devolve um inteiro contendo o id do comentário
     * @return  int que representa o id do comentario.
     */
    public int getId_comentario() {
        return id_comentario;
    }

    /**
     * Configura o id do comentário com o paremetro 'id_comentário' mais 1
     * @param id_comentario int contendo o id do comentário
     * @throws IllegalArgumentException Caso o inteiro seja negativo
     */
    public void setId_comentario(int id_comentario) throws IllegalArgumentException {
        if (id_comentario < 0) {
            throw new IllegalArgumentException("O id de um comentário não pode ser menor do que 0");
        }else{
            this.id_comentario = id_comentario + 1;
        }
    }

    /**
     * Devolve uma String contendo a o texto em si de um comentário
     * @return String: um texto contendo o comentário
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Configura o conteúdo de um comentário
     *
     * @param descricao o conteúdo de um Comentario
     * @throws IllegalArgumentException caso o comentário seja nullo ou vazio
     */
    public void setDescricao(String descricao) throws IllegalArgumentException {
        if (descricao.equals("")) {
            throw new IllegalArgumentException("Não é possivel criar um comentario sem nenhuma descrição ");
        } else {
            this.descricao = descricao;
        }
    }

}
