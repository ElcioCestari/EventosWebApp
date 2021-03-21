package entidade;

/**
 *
 * @author elciotaira
 */
public class Imagem {

    private Integer id;
    private String path;
    private String nome;
    private Integer fk_evento;

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

    public Integer getFk_evento() {
        return fk_evento;
    }

    public void setFk_evento(Integer fk_evento) {
        this.fk_evento = fk_evento;
    }
       
}
