/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 * Classe que impemlementa a modelagem de um Local de um Evento
 *
 * @author Elcio Cestari Taira
 */
public class Local {

    private String nome;
    private static int id_local;
    private int capacidade;
    private int id_endereco;
    
    

    public Local() throws IllegalArgumentException{
        if(id_local == 0)  setId_local(1);
        else setId_local(id_local);
    }

    /**
     * 
     * @param nome                          <code>String</code> que representa o nome do Local. Exemplo: Centro de convenções
     * @param capacidade                    <code>int</code> que representa a quantidade de pessoas que o local suporta
     * @throws IllegalArgumentException     se a <code>capacidade</code> &lt;  0.
     */
    public Local(String nome, int capacidade)throws IllegalArgumentException{
        this();
        this.nome = nome;
        this.capacidade = capacidade;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_local() {
        return id_local;
    }

    /**
     * Método private utilizado SOMENTE NA INSTANCIAÇÃO DE UM OBJETO DO TIPO LOCAL
     * </p>
     * Ele configura o id_local que deve ser identico ao do banco
     * @param id_local  um inteiro positivo que sera salvo no banco como chave-primaria
     * @throws IllegalArgumentException caso o <code>id_local<code> repassado seja menor do que o nummero 1
     */
    private void setId_local(int id_local) throws IllegalArgumentException{
        if(id_local < 1){
            throw new IllegalArgumentException("Não é possivel salvar um Local com identificador menor que 1");
        }
        Local.id_local = id_local;//na primeira instancia da classe o paremetro id_local conterá o numero 1 (veja Local()), na segunda instancia tera 2 e nas proximas n terá n 
        Local.id_local++;//incrementa para ser utilizado pela proxima instancia da classe
    }

    /**
     * 
     * @return int  contendo a capacidade do Local do Evento
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Configura o atributo 'capacidade' que representa a quantidade de pessoas que cabem em um Local
     * @param   capacidade  <code>int</code> que representa a quantidade de pessoas 
     * @throws  IllegalArgumentException    caso <code>capacidade</code> seja um inteiro negativo
     */
    public void setCapacidade(int capacidade) throws IllegalArgumentException {
        if (capacidade < 0) {
            throw new IllegalArgumentException("A capacidade não pode ser um numero negativo");
        }
        this.capacidade = capacidade;
    }

}
