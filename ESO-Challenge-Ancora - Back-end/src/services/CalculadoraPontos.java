package services;

import dao.AcessoDadosDAO;
import model.Evento;
import model.Funcionario;
import model.Participacao;
import java.util.List;

public class CalculadoraPontos {

    private AcessoDadosDAO acessoDadosDAO;

    public CalculadoraPontos(AcessoDadosDAO acessoDadosDAO) {
        this.acessoDadosDAO = acessoDadosDAO;
    }

    public void calcularPontosParaFuncionario(int funcionarioId) {
        List<Participacao> participacoes = acessoDadosDAO.localizarParticipacoesPorFuncionarioId(funcionarioId);

        for (Participacao participacao : participacoes) {
            Evento evento = acessoDadosDAO.localizarEventoPorId(participacao.getEvento_id());
            int pontos = calcularPontosParticipacao(participacao.getTempo_participacao(), evento.getDuracao(), evento.getVale_pontos());
            participacao.setPontos(pontos);
            acessoDadosDAO.inserirPontos(funcionarioId, pontos);
        }
    }

    public void calcularPontosParaTodosFuncionarios() {
        List<Funcionario> funcionarios = acessoDadosDAO.localizarTodosFuncionarios();

        for (Funcionario funcionario : funcionarios) {
            calcularPontosParaFuncionario(funcionario.getFuncionario_id());
        }
    }

    private int calcularPontosParticipacao(int tempoParticipacao, int duracaoEvento, int valePontos) {
        if (tempoParticipacao >= duracaoEvento) {
            return valePontos;
        } else {
            return (int) ((double) tempoParticipacao / duracaoEvento * valePontos);
        }
    }
}
