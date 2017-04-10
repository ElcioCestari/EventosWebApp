/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

/**
 * Modela um Endereco com seus atributos e métodos
 *
 * @author Elcio Cestari Taira
 */
public class Endereco {

    private static int id_endereco;//representa a chave primary do BD, portanto deve ser unica
    private int numero;//numero de um endereço
    private String rua;//nome da rua
    private String bairro;//nome do bairro
    private String cidade;// nome da cidade
    private String estado;//nome do estado. Ex.: 'MS'

    public Endereco() {
        setId_endereco();
    }
    
    public Endereco(int numero, String rua, String bairro, String cidade, String estado) {
        this();
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    /**
     * 
     * @return int contendo o id_endereo
     */
    public int getId_endereço() {
        return id_endereco;
    }

    /**
     * configura o id_endereco. deve ser privado pois somente a classe deve acessá-lo
     */
    private void setId_endereco() {
        if (Endereco.id_endereco == 0) {
            Endereco.id_endereco = 1;
        }
        Endereco.id_endereco++;
    }

    /**
     * 
     * @return int contendo o numero
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * 
     * @param numero  int utilizado para configurar o numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua.equals("")) {
            throw new IllegalArgumentException("O nome da rua não pode ser vazio");
        } else {
            this.rua = rua;
        }
    }

    /**
     *
     * @return String contendo o nome do bairro
     */
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairro.equals("")) {
            throw new IllegalArgumentException("O nome do bairro não pode ser vazio");
        } else {
            this.bairro = bairro;
        }
    }

    /**
     *
     * @return String contendo o nome da cidade.
     */
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws IllegalArgumentException {
        if (cidade.equals("")) {
            throw new IllegalArgumentException("O nome da cidade não pode ser vazio");
        } else {
            this.cidade = cidade;
        }
    }

    /**
     *
     * @return String contendo a sigla do estado
     */
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) throws IllegalArgumentException {
        if (estado.length() > 2) {
            throw new IllegalArgumentException("O estado deve conter somente a sigla");
        } else {
            this.estado = estado;
        }
    }

    @Override
    public String toString() {
        return "Endereço: \n" + "rua: " + this.getRua() + "\t numero: " + this.getNumero()
                + "\n Bairro: " + this.getBairro()
                + "\n Cidade: " + this.getCidade() + "\t Estado: " + this.getEstado();
    }

}
