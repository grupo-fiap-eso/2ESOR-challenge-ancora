package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cadastro;

public class CadastroDAO {

    private Connection conexao;

    public void inserir(Cadastro cadastro) {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQL = null;

        try {
            String sql = "INSERT INTO t_cadastro (ID_SEQ, NRO_DOCUMENTO, NOME, TIPO, EMAIL, TELEFONE, ESTADO, CIDADE) VALUES (id_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, cadastro.getNro_documento());
            comandoSQL.setString(2, cadastro.getNome());
            comandoSQL.setString(3, cadastro.getTipo());
            comandoSQL.setString(4, cadastro.getEmail());
            comandoSQL.setString(5, cadastro.getTelefone());
            comandoSQL.setString(6, cadastro.getEstado());
            comandoSQL.setString(7, cadastro.getCidade());
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (comandoSQL != null) comandoSQL.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void alterar(Cadastro cadastro) {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQL = null;

        try {
            String sql = "UPDATE t_cadastro SET NOME = ?, TIPO = ?, EMAIL = ?, TELEFONE = ?, ESTADO = ?, CIDADE = ? WHERE NRO_DOCUMENTO = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, cadastro.getNome());
            comandoSQL.setString(2, cadastro.getTipo());
            comandoSQL.setString(3, cadastro.getEmail());
            comandoSQL.setString(4, cadastro.getTelefone());
            comandoSQL.setString(5, cadastro.getEstado());
            comandoSQL.setString(6, cadastro.getCidade());
            comandoSQL.setString(7, cadastro.getNro_documento());
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (comandoSQL != null) comandoSQL.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void remover(Cadastro cadastro) {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQL = null;

        try {
            String sql = "DELETE FROM t_cadastro WHERE NRO_DOCUMENTO = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, cadastro.getNro_documento());
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (comandoSQL != null) comandoSQL.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Cadastro localizar(Cadastro cadastro) {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT NRO_DOCUMENTO, NOME, TIPO, EMAIL, TELEFONE, ESTADO, CIDADE FROM t_cadastro WHERE NRO_DOCUMENTO = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, cadastro.getNro_documento());
            rs = comandoSQL.executeQuery();

            if (rs.next()) {
                cadastro.setNro_documento(rs.getString("NRO_DOCUMENTO"));
                cadastro.setNome(rs.getString("NOME"));
                cadastro.setTipo(rs.getString("TIPO"));
                cadastro.setEmail(rs.getString("EMAIL"));
                cadastro.setTelefone(rs.getString("TELEFONE"));
                cadastro.setEstado(rs.getString("ESTADO"));
                cadastro.setCidade(rs.getString("CIDADE"));
            } else {
                cadastro = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (comandoSQL != null) comandoSQL.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return cadastro;
    }
}
