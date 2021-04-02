package util.enums;

/**
 *
 * @author elciotaira
 */
public enum PathEnums {
    PATH("C:\\Users\\LENOVO\\Desktop\\workspace\\estudos\\EventosWebApp\\EventosWebApp\\src\\img");    
    
    public String value;

    private PathEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
