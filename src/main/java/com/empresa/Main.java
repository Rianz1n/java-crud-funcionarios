package com.empresa;
import com.empresa.connection.ConnectionFactory;
import com.empresa.model.Funcionario;
import com.empresa.repository.FuncionarioRepository;
import com.empresa.service.FuncionarioService;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService();
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("1- Cadastrar funcionario");
            System.out.println("2- Listar funcionarios");
            System.out.println("3- Atualizar funcionario");
            System.out.println("4- Excluir funcionario");
            System.out.println("5-Sair");
            System.out.print("Escolha uma opcao:");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    Funcionario funcionario = new Funcionario();
                    service.cadastrarFuncionario(funcionario, input);
                    repository.salvar(funcionario);
                    break;
                case 2:
                    repository.listarTodos().forEach(f ->
                            System.out.println(
                                    "Nome: " + f.getNome() +
                                            " | Idade: " + f.getIdade() +
                                            " | Sexo: " + f.getSexo() +
                                            " | Email: " + f.getEmail()
                            )
                    );
                 break;

                case 3:
                    System.out.print("Digite o nome do funcionario :");
                    String selecao = input.nextLine();

                    Funcionario funcionarios = repository.listarUm(selecao);

                    if(funcionarios == null){
                        System.out.println("Funcionario nao encontrado!");
                    }else{
                        service.alterarFuncionario(funcionarios, input);
                        repository.atualizar(funcionarios);
                    }

                    break;

                case 4:
                    System.out.print("Digite o nome para excluir: ");
                    String nome = input.nextLine();

                    repository.deletar(nome);

                    break;
            }
        }
        input.close();
    }
}
