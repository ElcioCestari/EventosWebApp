/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

/**
 * Essa classe é responsável por modelar os comentários de um usuario em um evento
 * @author Elcio Cestari Taira
 */
public class Comentario {
    private String id_comentario;
    private String descricao;

    public Comentario(String id_comentario, String descricao) {
        this.id_comentario = id_comentario;
        this.descricao = descricao;
    }
    
    
    public String getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(String id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
