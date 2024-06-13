package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class GerenciadorBD {
	public static Connection obterConexao() {
		Connection conexao = null;
		try {
		conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM96736", "260302");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;
	}
}