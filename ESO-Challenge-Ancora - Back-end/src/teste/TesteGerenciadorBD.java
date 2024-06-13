package teste;
import dao.GerenciadorBD;
import javax.swing.JOptionPane;
public class TesteGerenciadorBD {
	public static void main(String[] args) {
		if(GerenciadorBD.obterConexao()==null) {
			JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão");
		}else {
			JOptionPane.showMessageDialog(null, "Conexão estabelecida com sucesso!");
		}
	}
}