package dao.util.enums;

public enum EventoColumnsNameEnum {
    TIPO_EVENTO ("tipo_evento"), 
    VALOR ("valor"),
    NOME ("nome"),
    ID_EVENTO ("id_evento"), 
    FAIXA_ETARIA ("faixaEtaria"),
    CURTIDAS ("curtidas"), 
    NAO_CURTIDAS ("naoCurtidas"), 
    DURACAO ("duracao"),
    DATA ("data"), 
    ID_LOCAL ("id_local"),
    ID_USUARIO ("id_usuario"),
    DESCRICAO ("descricao"),
    FK_IMG_EVENTO ("fkImgEvento");
    
    public String value;

    private EventoColumnsNameEnum(String value) {
        this.value = value;
    }
}
