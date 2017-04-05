/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

/**
 * Modela um Endereco com  seus atributos e métodos
 * @author Elcio Cestari Taira
 */
public class Endereco {
    private int id_endereço;
    private int numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco() {
    }

    
    public int getId_endereço() {
        return id_endereço;
    }

    public void setId_endereço(int id_endereço) {
        this.id_endereço = id_endereço;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
