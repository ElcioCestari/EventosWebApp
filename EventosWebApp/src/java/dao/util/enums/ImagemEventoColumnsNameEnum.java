package dao.util.enums;

/**
 *
 * @author elciotaira
 */
public enum ImagemEventoColumnsNameEnum {
    ID("id"),
    PATH("path"),
    NOME("nome"),
    FK_EVENTO("fk_evento");
    
    public String value; 

    private ImagemEventoColumnsNameEnum(String value) {
        this.value = value;
    }
}
