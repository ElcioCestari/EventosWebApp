package model.entidade;

/**
 *
 * @author elciotaira
 */
public class Imagem {

    private Integer id;
    private String path;
    private String nome;

    public Imagem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
