package dao.util.enums;

/**
 *
 * @author elciotaira
 */
public enum NomeTabelaEnum {
    IMAGEM("img_evento"),
    EVENTO("evento");
    
    public String nome;

    private NomeTabelaEnum(String nome) {
        this.nome = nome;
    }    
}
