package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.AcessoDadosDAO;
import model.Empresa;
import model.Funcionario;

public class ViewCadastro extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JLabel lblTipoCadastro;
    private JComboBox<String> cboTipoCadastro;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblCpfCnpj;
    private JTextField txtCpfCnpj;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblSenhaEndereco;
    private JTextField txtSenhaEndereco;

    private JButton btnInserir;

    private JPanel pnlFormulario;
    private JPanel pnlBotoes;

    private AcessoDadosDAO dao;

    public ViewCadastro() {
        super("Cadastrar Funcionário ou Empresa");
        this.setLayout(new BorderLayout());
        this.setSize(400, 300);

        pnlBotoes = new JPanel(new FlowLayout());
        pnlFormulario = new JPanel(new GridBagLayout());

        GridBagConstraints posicoes = new GridBagConstraints();
        posicoes.insets = new Insets(3, 3, 3, 3);
        posicoes.anchor = GridBagConstraints.LINE_START;

        lblTipoCadastro = new JLabel("Tipo de Cadastro:");
        posicoes.gridx = 0;
        posicoes.gridy = 0;
        pnlFormulario.add(lblTipoCadastro, posicoes);

        String[] tiposCadastro = {"Funcionário", "Empresa"};
        cboTipoCadastro = new JComboBox<>(tiposCadastro);
        cboTipoCadastro.addActionListener(this);
        posicoes.gridx = 1;
        pnlFormulario.add(cboTipoCadastro, posicoes);

        lblNome = new JLabel("Nome:");
        posicoes.gridx = 0;
        posicoes.gridy = 1;
        pnlFormulario.add(lblNome, posicoes);

        txtNome = new JTextField(15);
        posicoes.gridx = 1;
        pnlFormulario.add(txtNome, posicoes);

        lblCpfCnpj = new JLabel("CPF/CNPJ:");
        posicoes.gridx = 0;
        posicoes.gridy = 2;
        pnlFormulario.add(lblCpfCnpj, posicoes);

        txtCpfCnpj = new JTextField(15);
        posicoes.gridx = 1;
        pnlFormulario.add(txtCpfCnpj, posicoes);

        lblEmail = new JLabel("Email:");
        posicoes.gridx = 0;
        posicoes.gridy = 3;
        pnlFormulario.add(lblEmail, posicoes);

        txtEmail = new JTextField(15);
        posicoes.gridx = 1;
        pnlFormulario.add(txtEmail, posicoes);

        lblSenhaEndereco = new JLabel("Senha/Endereço:");
        posicoes.gridx = 0;
        posicoes.gridy = 4;
        pnlFormulario.add(lblSenhaEndereco, posicoes);

        txtSenhaEndereco = new JTextField(15);
        posicoes.gridx = 1;
        pnlFormulario.add(txtSenhaEndereco, posicoes);

        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(this);
        pnlBotoes.add(btnInserir);

        add(pnlFormulario, BorderLayout.CENTER);
        add(pnlBotoes, BorderLayout.SOUTH);

        dao = new AcessoDadosDAO();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == cboTipoCadastro) {
            String tipoCadastro = (String) cboTipoCadastro.getSelectedItem();
            if (tipoCadastro.equals("Funcionário")) {
                lblSenhaEndereco.setText("Senha:");
                lblEmail.setVisible(true); 
                txtEmail.setVisible(true);
            } else if (tipoCadastro.equals("Empresa")) {
                lblSenhaEndereco.setText("Endereço:");
                lblEmail.setVisible(false); 
                txtEmail.setVisible(false);
            }
        } else if (evento.getSource() == btnInserir) {
            try {
                String tipoCadastro = (String) cboTipoCadastro.getSelectedItem();
                if (tipoCadastro.equals("Funcionário")) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(txtNome.getText());
                    funcionario.setCpf(txtCpfCnpj.getText());
                    funcionario.setEmail(txtEmail.getText());
                    funcionario.setSenha(txtSenhaEndereco.getText());
                    // Aqui você precisa definir o empresa_id do funcionário
                    funcionario.setEmpresa_id(1); // Exemplo de empresa_id, substitua pelo valor correto

                    dao.inserirFuncionario(funcionario);
                } else if (tipoCadastro.equals("Empresa")) {
                    Empresa empresa = new Empresa();
                    empresa.setNome(txtNome.getText());
                    empresa.setCnpj(txtCpfCnpj.getText());
                    empresa.setEndereco(txtSenhaEndereco.getText());

                    dao.inserirEmpresa(empresa);
                }
                limparCampos();
            } catch (NumberFormatException e) {

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpfCnpj.setText("");
        txtEmail.setText("");
        txtSenhaEndereco.setText("");
    }

    public static void main(String[] args) {
        ViewCadastro janela = new ViewCadastro();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
