/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author Elcio Cestari Taira
 */
interface BaseDAO<T> {
    public void create(T t) throws Exception;
    public void delete();
    public void upDate();
    public T findById(int id)throws Exception;
}
