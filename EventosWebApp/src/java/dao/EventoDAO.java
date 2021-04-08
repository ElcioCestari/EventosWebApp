package dao;

import builder.EventoBuilder;
import connections.ConnectionFactory;
import dao.util.enums.EventoColumnsNameEnum;
import dao.util.enums.NomeTabelaEnum;
import entidade.Evento;
import entidade.Imagem;
import exceptions.EntityNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Essa classe implementa os metodos de consultas e inserções no Banco de Dados
 *
 * @author Elcio Cestari Taira
 * @version 1.0
 * @since 26/mar/2017
 */
public class EventoDAO extends ConnectionFactory implements InterfaceDAO<Evento> {

    private ImagemEventoDAO imagemEventoDAO;

    public EventoDAO(ImagemEventoDAO imagemEventoDAO) {
        this.imagemEventoDAO = imagemEventoDAO;
    }

    /**
     * Metodo que recebe um evento para criar e salvar no banco
     *
     * @param evento
     * @throws SQLException Caso haja algum erro ao tentar acessar ou salvar no
     * banco
     * @throws ClassNotFoundException Caso haja algum erro em instanciar a o
     * tipo da classe
     */
    @Override
    public Evento create(Evento evento) {
        try {
            String sql = "INSERT INTO evento(tipo_evento,valor,nome,faixaEtaria,descricao)Values(?,?,?,?,?);";
            PreparedStatement statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, evento.getTipo());
            statement.setDouble(2, evento.getValor());
            statement.setString(3, evento.getNome());
            statement.setInt(4, evento.getFaixaEtaria());
            statement.setString(5, evento.getDescricao());
            statement.execute();//executando a instrução SQL.
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                return this.findById(id);
            }
        } catch (Exception sqle) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, sqle);
            throw new RuntimeException("erro ao salvar evento");
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM evento WHERE id=?;";
        try {
            Evento evento = this.findById(id);
            if (evento == null) {
                throw new ClassNotFoundException("nao foi possivel deletar o evento");
            }
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setInt(1, id);
            int delete = statement.executeUpdate();
            if(delete < 1) throw new ClassNotFoundException("nao foi relaizado a exclusão do evento");
        } catch (Exception ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Evento upDate(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evento findById(int id) throws Exception {
        String sql = "SELECT * FROM " + NomeTabelaEnum.EVENTO + " WHERE " + EventoColumnsNameEnum.ID_EVENTO.value + "  = ? ;";
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet == null) {
            throw new EntityNotFoundException(Integer.valueOf(id).toString());
        }
        return this.parseResultSetToEvento(resultSet).get(0);
    }

    public List<Evento> selectAll() {
        String sql = "SELECT * FROM evento;";
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            return this.parseResultSetToEvento(resultSet);//adicionando Evento recem criado à list
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao buscar a lista de eventos: " + e.getMessage());
        }
    }

    /**
     * Seleciona todos os Eventos que estão no banco e os adiciona à list
     *
     * @deprecated - Este metodo foi depreciado pois, apos analise,
     * identificou-se que nao fazia sentido um selectall passando uma list como
     * atributo.
     * @see - <code>selectAll()</code>
     * @param list um ArrayList que será utlizado para armazenar todos os
     * Eventos salvos no banco
     */
    public ArrayList<Evento> selectAll(ArrayList<Evento> list) {
        String tipo;
        String descricao;
        double valor;
        String nome;
        int id_evento;
        int faixaEtaria;

        if (list == null) {
            list = new ArrayList<Evento>();//se o arrayList estiver null ele será inicializado aqui.
        }

        try {
            String sql = "SELECT * FROM evento;";//String para a instrução que selecionará todos os atributos de um evento no banco
            PreparedStatement statement = getConnection().prepareStatement(sql);//estabelece a conecxão com o banco e prepara a instrução sql que será executada
            ResultSet resultSet = statement.executeQuery();// executa a  query
            while (resultSet.next()) {//enquanto houver linhas sendo retornadas da consulta sql...
                boolean eventoEstaNaLista = false;//sera configurada com true se houver um evento na lista
                for (int i = 0; i < list.size(); i++) {//percorre a toda a lista 
                    if (list.get(i).getId_evento() == resultSet.getInt("id_evento")) {//Se um Evento da 'list' tiver o mesmo id que uma tupla do banco...
                        eventoEstaNaLista = true;//... O evento esta na lista, portanto configura a variavél como true.
                        break;//interrompe o for e volta para o loop while
                    }
                }
                if (eventoEstaNaLista == false) {//se não tiver no arrayList 'list' um evento com o mesmo id_evento que esta no banco... 
                    tipo = resultSet.getString("tipo_evento");
                    descricao = resultSet.getString("descricao");
                    valor = resultSet.getDouble("valor");
                    nome = resultSet.getString("nome");
                    id_evento = resultSet.getInt("id_evento");
                    faixaEtaria = resultSet.getInt("faixaEtaria");
                    Evento e = new Evento(tipo, descricao, valor, faixaEtaria, nome, id_evento);//criando um novo evento pois não existia na list o evento que esta no banco
                    list.add(e);//adicionando Evento recem criado à list
                }
            }//fim do while
        } catch (Exception e) {
            throw new RuntimeException("Ocorreu um erro ao buscar a lista de eventos: " + e.getMessage());
        }
        return list;
    }//fim do método 

    /**
     * Busca no banco na tabela evento uma tupla com o id passaado como
     * paramettro
     *
     * @param id o id que será utilizado na query.
     * @return um Evento
     * @throws RuntimeException caso ocorra algum tipo de sqlException
     */
    public Evento getById(int id) throws RuntimeException {
        Evento evento = null;
        String sql = "SELECT * FROM evento WHERE id_evento = " + id + ";";
        ResultSet resultSet = conectsAndExecutes(sql);
        try {
            evento = parseResultSetToEvento(resultSet).get(0);
        } catch (RuntimeException ex) {
            throw new RuntimeException("Ocorreu um erro ao buscar o evento: " + ex.getMessage());
        }
        return evento;
    }

    /**
     * Conecta e executa a query repassada como parametro
     *
     * @param sql a instrução sql que será executada no banco
     * @throws RuntimeException caso ocorra um erro no banco
     */
    private ResultSet conectsAndExecutes(String sql) throws RuntimeException {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao realizar a pesquisa no banco: " + ex.getMessage());
        }
        return resultSet;
    }

    /**
     * Finaliza a conexão com o banco
     *
     * @deprecated - este metodo foi depreciado pois não estou mais utilizando.
     * Estou revendo esta funcionalidade do código TODO
     */
    private void endConnection() {

//        //TODO
//        try {
////            statement.close();
////            resultSet.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private List<Evento> parseResultSetToEvento(ResultSet resultSet) {
        List<Evento> eventos = new ArrayList<>();
        Evento evento = null;
        try {
            while (resultSet.next()) {
                List<Imagem> imagem = this.imagemEventoDAO.findByFkEvento(resultSet.getInt(EventoColumnsNameEnum.ID_EVENTO.value));
                evento = new EventoBuilder()
                        .setDescricao(resultSet.getString(EventoColumnsNameEnum.DESCRICAO.value))
                        .setFaixaEtaria(resultSet.getInt(EventoColumnsNameEnum.FAIXA_ETARIA.value))
                        .setId_evento(resultSet.getInt(EventoColumnsNameEnum.ID_EVENTO.value))
                        .setId_usuario(resultSet.getInt(EventoColumnsNameEnum.ID_USUARIO.value))
                        .setNome(resultSet.getString(EventoColumnsNameEnum.NOME.value))
                        .setTipo(resultSet.getString(EventoColumnsNameEnum.TIPO_EVENTO.value))
                        .setValor(resultSet.getDouble(EventoColumnsNameEnum.VALOR.value))
                        .setImagemList(imagem)
                        .build();
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao converter os dados do banco em um evento. Entre em contato com o suporte");
        }
        return eventos;
    }
}
