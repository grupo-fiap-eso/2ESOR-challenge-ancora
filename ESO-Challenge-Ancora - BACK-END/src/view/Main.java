package view;

import model.Empresa;
import model.Evento;
import model.Funcionario;
import model.Participacao;
import model.Pontos;
import model.Premios;
import exceptions.FuncionarioException;
import services.CalculadoraPontos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Evento> eventos = new ArrayList<>();
    private static List<Participacao> participacoes = new ArrayList<>();
    private static List<Pontos> registrosPontos = new ArrayList<>();
    private static List<Premios> premiosDisponiveis = new ArrayList<>();

    public static void main(String[] args) {

        inicializarDados();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criarEExibirInterfaceGrafica();
            }
        });
    }

    private static void criarEExibirInterfaceGrafica() {
        JFrame frame = new JFrame("Rede ANCORA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton btnRelatorio = new JButton("Ver Relatório de Participação");
        btnRelatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirRelatorioDeParticipacao();
            }
        });

        JButton btnConferirPontos = new JButton("Conferir Pontos");
        btnConferirPontos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirPontosAcumulados();
            }
        });

        JButton btnTrocarPremios = new JButton("Trocar Prêmios");
        btnTrocarPremios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTrocaDePremios();
            }
        });

        panel.add(btnRelatorio);
        panel.add(btnConferirPontos);
        panel.add(btnTrocarPremios);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void exibirRelatorioDeParticipacao() {
        StringBuilder relatorio = new StringBuilder();
        for (Participacao participacao : participacoes) {
            relatorio.append("Funcionário ").append(participacao.getFuncionario_id())
                    .append(" participou por ").append(participacao.getTempo_participacao()).append(" minutos\n");
        }
        JOptionPane.showMessageDialog(null, "Relatório de Participação:\n" + relatorio.toString());
    }

    private static void exibirPontosAcumulados() {
        StringBuilder pontos = new StringBuilder();
        for (Pontos registro : registrosPontos) {
            pontos.append("Funcionário ").append(registro.getFuncionario_id())
                    .append(" possui ").append(registro.getTotal_pontos()).append(" pontos\n");
        }
        JOptionPane.showMessageDialog(null, "Pontos Acumulados:\n" + pontos.toString());
    }

    private static void exibirTrocaDePremios() {
        String input = JOptionPane.showInputDialog(null, "Informe o ID do funcionário:");
        int funcionarioId = Integer.parseInt(input);
        String mensagem = trocarPontosPorPremios(funcionarioId);
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static String trocarPontosPorPremios(int funcionarioId) {
        Pontos pontosFuncionario = registrosPontos.stream()
                .filter(p -> p.getFuncionario_id() == funcionarioId)
                .findFirst()
                .orElse(null);
        if (pontosFuncionario != null) {
            Premios premio = premiosDisponiveis.stream()
                    .filter(p -> p.getPontos_necessarios() <= pontosFuncionario.getTotal_pontos())
                    .findFirst()
                    .orElse(null);
            if (premio != null) {
                pontosFuncionario.setTotal_pontos(pontosFuncionario.getTotal_pontos() - premio.getPontos_necessarios());
                return "Funcionário " + funcionarioId + " trocou seus pontos por " + premio.getNome() + ": " + premio.getDescricao();
            } else {
                return "Funcionário " + funcionarioId + " não possui pontos suficientes para trocar por prêmios.";
            }
        } else {
            return "Funcionário não encontrado.";
        }
    }

    private static void inicializarDados() {
        try {
            Empresa empresaA = new Empresa(1, "12345678901234", "Empresa A", "São Paulo");
            Funcionario funcionario1 = new Funcionario(1, empresaA, "João Matheus", "123.456.789-00", "joao@example.com", "senha123");
            Funcionario funcionario2 = new Funcionario(2, empresaA, "Maria Vitória", "987.654.321-00", "maria@example.com", "senha456");

            eventos.add(new Evento(1, 1, "Integração", "Normas da empresa.", "Live",
                    Timestamp.valueOf("2023-06-01 10:00:00"), 120, 50, "http://videoA.com",
                    Timestamp.valueOf("2023-05-01 10:00:00")));
            participacoes.add(new Participacao(1, funcionario1.getFuncionario_id(), eventos.get(0).getEvento_id(), 90)); 
            participacoes.add(new Participacao(2, funcionario2.getFuncionario_id(), eventos.get(0).getEvento_id(), 150)); 
            for (Participacao participacao : participacoes) {
                int pontosParticipacao = CalculadoraPontos.calcularPontosParticipacao(participacao, eventos.get(0));
                salvarPontos(participacao.getFuncionario_id(), pontosParticipacao);
            }
            premiosDisponiveis.add(new Premios(1, "Mochila", "Bônus especial para o Natal", 100));
            premiosDisponiveis.add(new Premios(2, "Vale-compras App de Comida", "Vale-compras no valor de R$ 50", 150));
            premiosDisponiveis.add(new Premios(2, "Recarga Celular", "Recarga no valor de 10 reais", 50));

        } catch (FuncionarioException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void salvarPontos(int funcionarioId, int pontos) {

        Pontos registroExistente = registrosPontos.stream()
                .filter(p -> p.getFuncionario_id() == funcionarioId)
                .findFirst()
                .orElse(null);

        if (registroExistente != null) {
            registroExistente.setTotal_pontos(registroExistente.getTotal_pontos() + pontos);
        } else {
            registrosPontos.add(new Pontos(registrosPontos.size() + 1, funcionarioId, pontos));
        }
    }
}
