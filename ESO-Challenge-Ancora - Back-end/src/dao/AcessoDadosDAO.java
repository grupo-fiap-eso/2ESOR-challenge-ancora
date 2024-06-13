package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Evento;
import model.Participacao;
import model.Funcionario;
import model.Empresa;

public class AcessoDadosDAO {

    private Connection conexao;

    public AcessoDadosDAO() {
        conexao = GerenciadorBD.obterConexao();
    }

    public ArrayList<Evento> localizarAll() {
        ArrayList<Evento> listaEventos = new ArrayList<>();

        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = conexao.prepareStatement("SELECT * FROM t_eventos");
            ResultSet resultados = comandoSQL.executeQuery();
            while (resultados.next()) {
                Evento evento = new Evento();
                evento.setEvento_id(resultados.getInt("evento_id"));
                evento.setEmpresa_id(resultados.getInt("empresa_id"));
                evento.setTitulo(resultados.getString("titulo"));
                evento.setDescricao(resultados.getString("descricao"));
                evento.setTipo_evento(resultados.getString("tipo_evento"));
                evento.setData_evento(resultados.getTimestamp("data_evento"));
                evento.setDuracao(resultados.getInt("duracao"));
                evento.setVale_pontos(resultados.getInt("vale_pontos"));
                evento.setUrl_video(resultados.getString("url_video"));
                evento.setCriado_em(resultados.getTimestamp("criado_em"));

                listaEventos.add(evento);
            }
            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEventos;
    }

    public Evento localizarEventoPorId(int eventoId) {
        Evento evento = null;

        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = conexao.prepareStatement("SELECT * FROM t_eventos WHERE evento_id = ?");
            comandoSQL.setInt(1, eventoId);
            ResultSet resultados = comandoSQL.executeQuery();
            if (resultados.next()) {
                evento = new Evento();
                evento.setEvento_id(resultados.getInt("evento_id"));
                evento.setEmpresa_id(resultados.getInt("empresa_id"));
                evento.setTitulo(resultados.getString("titulo"));
                evento.setDescricao(resultados.getString("descricao"));
                evento.setTipo_evento(resultados.getString("tipo_evento"));
                evento.setData_evento(resultados.getTimestamp("data_evento"));
                evento.setDuracao(resultados.getInt("duracao"));
                evento.setVale_pontos(resultados.getInt("vale_pontos"));
                evento.setUrl_video(resultados.getString("url_video"));
                evento.setCriado_em(resultados.getTimestamp("criado_em"));
            }
            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evento;
    }

    public List<Participacao> localizarParticipacoesPorFuncionarioId(int funcionarioId) {
        List<Participacao> listaParticipacoes = new ArrayList<>();

        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = conexao.prepareStatement("SELECT * FROM t_participacao WHERE funcionario_id = ?");
            comandoSQL.setInt(1, funcionarioId);
            ResultSet resultados = comandoSQL.executeQuery();
            while (resultados.next()) {
                Participacao participacao = new Participacao();
                participacao.setParticipacao_id(resultados.getInt("participacao_id"));
                participacao.setFuncionario_id(resultados.getInt("funcionario_id"));
                participacao.setEvento_id(resultados.getInt("evento_id"));
                participacao.setTempo_participacao(resultados.getInt("tempo_participacao"));
                participacao.setPontos(resultados.getInt("pontos"));
                participacao.setCriado_em(resultados.getTimestamp("criado_em"));

                listaParticipacoes.add(participacao);
            }
            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaParticipacoes;
    }

    public List<Funcionario> localizarTodosFuncionarios() {
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = conexao.prepareStatement("SELECT * FROM t_funcionarios");
            ResultSet resultados = comandoSQL.executeQuery();
            while (resultados.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionario_id(resultados.getInt("funcionario_id"));
                funcionario.setEmpresa_id(resultados.getInt("empresa_id"));
                funcionario.setNome(resultados.getString("nome"));
                funcionario.setCpf(resultados.getString("cpf"));
                funcionario.setEmail(resultados.getString("email"));
                funcionario.setSenha(resultados.getString("senha"));

                listaFuncionarios.add(funcionario);
            }
            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFuncionarios;
    }

    public void inserirPontos(int funcionarioId, int pontos) {
        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = conexao.prepareStatement(
                "INSERT INTO t_pontos (ponto_id, funcionario_id, total_pontos) VALUES (ponto_id.NEXTVAL, ?, ?)"
            );
            comandoSQL.setInt(1, funcionarioId);
            comandoSQL.setInt(2, pontos);

            comandoSQL.executeUpdate();
            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirFuncionario(Funcionario funcionario) {
        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = conexao.prepareStatement(
                "INSERT INTO t_funcionarios (funcionario_id, empresa_id, nome, cpf, email, senha) " +
                "VALUES (funcionario_id.NEXTVAL, ?, ?, ?, ?, ?)"
            );
            comandoSQL.setInt(1, funcionario.getEmpresa_id());
            comandoSQL.setString(2, funcionario.getNome());
            comandoSQL.setString(3, funcionario.getCpf());
            comandoSQL.setString(4, funcionario.getEmail());
            comandoSQL.setString(5, funcionario.getSenha());

            comandoSQL.executeUpdate();
            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirEmpresa(Empresa empresa) {
        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = conexao.prepareStatement(
                "INSERT INTO t_empresas (empresa_id, cnpj, nome, endereco) " +
                "VALUES (empresa_id.NEXTVAL, ?, ?, ?)"
            );
            comandoSQL.setString(1, empresa.getCnpj());
            comandoSQL.setString(2, empresa.getNome());
            comandoSQL.setString(3, empresa.getEndereco());

            comandoSQL.executeUpdate();
            comandoSQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
