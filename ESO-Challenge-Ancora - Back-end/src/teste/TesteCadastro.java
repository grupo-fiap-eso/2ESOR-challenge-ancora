package teste;
import javax.swing.JOptionPane;
import dao.CadastroDAO;
import model.Cadastro;
public class TesteCadastro {
	public static void main(String[] args) {
		Cadastro banda = new Cadastro();
		CadastroDAO dao = new CadastroDAO();
		banda.setNome(JOptionPane.showInputDialog("Digite o nome: "));
		dao.inserir(banda);
	}
}