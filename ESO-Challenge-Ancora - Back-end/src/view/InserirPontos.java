package view;
import dao.AcessoDadosDAO;
import services.CalculadoraPontos;


public class InserirPontos {
	    public static void main(String[] args) {
	        AcessoDadosDAO acessoDadosDAO = new AcessoDadosDAO();
	        CalculadoraPontos pontosCalculator = new CalculadoraPontos(acessoDadosDAO);

	        pontosCalculator.calcularPontosParaTodosFuncionarios();

	        System.out.println("Pontos calculados e inseridos para todos os funcionários com sucesso.");
	    }
	}

