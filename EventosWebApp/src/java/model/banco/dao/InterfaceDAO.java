/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.banco.dao;

/**
 * Interface que serve como base para as outras classes que implementam os metodos para realizar as operações no banco de dados 
 * @author Elcio Cestari Taira
 */
interface InterfaceDAO<T> {
    /**
     * Deve ser utilizada para salvar um objeto
     * @param t um objeto do tipo da Classe
     * @throws Exception    Normalmente SQL exceptions
     */
    public void create(T t) throws Exception;
    
    /**
     * Deve ser utilizada para deletar um objeto 
     */
    public void delete();
    
    /**
     * Deve ser utilizado para fazer um update no banco
     */
    public void upDate();
    
    /**
     * Deve ser utilizado para econtrar um objeto que coincida com o id
     * @param id    inteiro salvo no banco
     * @return  o objeto que tenha a mesma id do parametro
     * @throws Exception SQLexception
     */
    public T findById(int id)throws Exception;
}
