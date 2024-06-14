package teste;

import model.Empresa;
import model.Funcionario;
import exceptions.FuncionarioException;

public class FuncionarioTest {
    public static void main(String[] args) {
        try {
            Empresa empresaA = new Empresa(1, "12345678901234", "Empresa A", "Rua da Empresa A, 123");
            
            Funcionario funcionario1 = new Funcionario(1, empresaA, "João", "123.456.789-00", "joao@example.com", "senha123");
            System.out.println("Funcionário 1 criado com sucesso: " + funcionario1);

            try {
                Funcionario funcionario2 = new Funcionario(2, empresaA, "", "987.654.321-00", "ana@example.com", "senha321");
                System.out.println("Funcionário 2 criado com sucesso: " + funcionario2);
            } catch (FuncionarioException e) {
                System.out.println("Erro ao criar funcionário 2: " + e.getMessage());
            }
            try {
                Funcionario funcionario3 = new Funcionario(3, empresaA, "Ana", "98765432100", "ana@example.com", "senha321");
                System.out.println("Funcionário 3 criado com sucesso: " + funcionario3);
            } catch (FuncionarioException e) {
                System.out.println("Erro ao criar funcionário 3: " + e.getMessage());
            }
            try {
                Funcionario funcionario4 = new Funcionario(4, empresaA, "Ana", "987.654.321-00", "anaexamplecom", "senha321");
                System.out.println("Funcionário 4 criado com sucesso: " + funcionario4);
            } catch (FuncionarioException e) {
                System.out.println("Erro ao criar funcionário 4: " + e.getMessage());
            }
            try {
                funcionario1.setNome(""); 
            } catch (FuncionarioException e) {
                System.out.println("Teste passou: " + e.getMessage());
            }

            try {
                funcionario1.setCpf("12345678900"); 
            } catch (FuncionarioException e) {
                System.out.println("Teste passou: " + e.getMessage());
            }
            try {
                funcionario1.setEmail("joaoexample.com");  
            } catch (FuncionarioException e) {
                System.out.println("Teste passou: " + e.getMessage());
            }

        } catch (FuncionarioException e) {
            System.out.println("Erro durante o teste: " + e.getMessage());
        }
    }
}
