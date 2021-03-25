package exceptions;

public class EntityNotFoundException extends RuntimeException{

    static final String MESSAGE = "O recurso solicitado não foi encontado!";
    
    /**
     * 
     * @param id - o id do recurso que tentou localizar
     */
    public EntityNotFoundException(String id) {
        super(MESSAGE + " id: " + id);
    }
}

