package dao;

/**
 * Interface que serve como base para as outras classes que implementam os metodos para realizar as operações no banco de dados 
 * @author Elcio Cestari Taira
 */
interface InterfaceDAO<T> {
    
    /**
     * Deve ser utilizada para salvar um objeto
     * @param t um objeto do tipo da Classe
     * @throws Exception    Normalmente SQL exceptions
     * @return T uma instancia que acabou de ser salva no banco
     */
    public T create(T t) throws Exception;
    
    /**
     * Deve ser utilizada para deletar um objeto 
     */
    public void delete(Integer id);
    
    /**
     * Deve ser utilizado para fazer um update no banco
     * @param - t uma instancia da entidade para ser salva no banco
     * @return - T a instancia que acabou de ser salva.
     */
    public T upDate(T t);
    
    /**
     * Deve ser utilizado para econtrar um objeto que coincida com o id
     * @param id    inteiro salvo no banco
     * @return  o objeto que tenha a mesma id do parametro
     * @throws Exception SQLexception
     */
    public T findById(int id)throws Exception;
}
