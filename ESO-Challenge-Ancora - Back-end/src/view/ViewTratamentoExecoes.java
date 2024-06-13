package view;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewTratamentoExecoes {
	public static void main(String[] args) {
		Double pedidos[] = new Double[3];
		Double totalConta = 0.0;
		Integer posicao = 0;
		Scanner leitor = new Scanner(System.in);
		try {
			for (int i = 0; i < pedidos.length; i++) {
				System.out.println("O custo do " + (i + 1) + " prato pedido!");
				pedidos[i] = leitor.nextDouble();
				totalConta += pedidos[i];
			}

			while (posicao != -1) {
				System.out.println(
						"Digite a posição de um prato para verificar seu custo, ou -1 para seguir o programa!");
				posicao = leitor.nextInt();
				System.out.println("O valor do prato é R$" + pedidos[posicao]);
			}

			System.out.println("O total da conta foi R$" + totalConta);

		} catch (InputMismatchException erro) {
			System.out.println("Foi digitado um valor inválido");
		} catch (ArrayIndexOutOfBoundsException erro) {
			System.out.println("O prato solicitado não foi informado anteriormente.");
		}finally{
			leitor.close();
		}
	}
}