package com.empresa.service;
import com.empresa.model.Funcionario;
import com.empresa.repository.FuncionarioRepository;

import java.util.Scanner;

public class FuncionarioService {

    public void cadastrarFuncionario(Funcionario funcionario, Scanner input) {
        System.out.print("1. Digite o nome do funcionario :");
        funcionario.setNome(input.nextLine());

        System.out.print("2. Digite o idade do funcionario :");
        funcionario.setIdade(input.nextInt());

        System.out.print("3. Sexo do funcionario :");
        funcionario.setSexo(input.next().charAt(0));

        input.nextLine();

        System.out.print("4. E-mail do funcionario :");
        funcionario.setEmail(input.nextLine());
    }

    public void alterarFuncionario(Funcionario funcionario, Scanner input) {
        int op = 0;
        while(op != 5){
            System.out.println("**ALTERAÇÃO FUNCIONARIO**");
            System.out.println("1- Alterar nome");
            System.out.println("2- Alterar idade");
            System.out.println("3- Alterar sexo");
            System.out.println("4- Alterar email");
            System.out.println("5- Sair");
            System.out.print("Escolha uma opcao:");
            op = input.nextInt();
            input.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Novo nome: ");
                    funcionario.setNome(input.nextLine());
                    break;
                case 2:
                    System.out.print("Nova idade: ");
                    funcionario.setIdade(input.nextInt());
                    break;
                case 3:
                    System.out.print("Alterar sexo: ");
                    funcionario.setSexo(input.next().charAt(0));
                    break;
                case 4:
                    System.out.print("Novo email: ");
                    funcionario.setEmail(input.nextLine());
                    break;

                case 5:
                    System.out.print("Saindo...");
                    break;
                default:
                    System.out.println("Digite uma opcao valida!!");
            }
        }
    }
}
