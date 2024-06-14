package services;
import model.Evento;
import model.Participacao;

public class CalculadoraPontos {
    public static int calcularPontosParticipacao(Participacao participacao, Evento evento) {
        int tempoParticipacao = participacao.getTempo_participacao();
        int duracaoEvento = evento.getDuracao();
        int valePontos = evento.getVale_pontos();

        if (tempoParticipacao >= duracaoEvento) {
            return valePontos;
        } else {
            return (int) ((double) tempoParticipacao / duracaoEvento * valePontos);
        }
    }
}
