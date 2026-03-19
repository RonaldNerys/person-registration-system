import model.Person;
import service.PersonService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PersonService service = new PersonService();

        int option;

        do {
            System.out.println("\n===== SISTEMA DE CADASTRO =====");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Remover pessoa");
            System.out.println("4 - Editar pessoa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine();

            // CADASTRAR
            if (option == 1) {
                Person person = new Person();

                System.out.print("Digite o nome: ");
                person.setName(scanner.nextLine());

                System.out.print("Digite a idade: ");
                person.setAge(scanner.nextInt());
                scanner.nextLine();

                service.addPerson(person);
                System.out.println("Pessoa cadastrada com sucesso!");
            }

            // LISTAR
            if (option == 2) {
                System.out.println("Total: " + service.getPeople().size());

                if (service.getPeople().isEmpty()) {
                    System.out.println("Nenhuma pessoa cadastrada.");
                } else {
                    for (int i = 0; i < service.getPeople().size(); i++) {
                        Person p = service.getPeople().get(i);
                        System.out.println(i + " - " + p.getName() + " (" + p.getAge() + ")");
                    }
                }
            }

            // REMOVER
            if (option == 3) {
                System.out.print("Digite o número da pessoa para remover: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                service.removePerson(index);
                System.out.println("Pessoa removida!");
            }

            // EDITAR
            if (option == 4) {

                if (service.getPeople().isEmpty()) {
                    System.out.println("Nenhuma pessoa cadastrada.");
                } else {

                    for (int i = 0; i < service.getPeople().size(); i++) {
                        Person p = service.getPeople().get(i);
                        System.out.println(i + " - " + p.getName() + " (" + p.getAge() + ")");
                    }

                    System.out.print("Digite o número da pessoa que deseja editar: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    if (index >= 0 && index < service.getPeople().size()) {

                        Person person = service.getPeople().get(index);

                        System.out.print("Novo nome: ");
                        person.setName(scanner.nextLine());

                        System.out.print("Nova idade: ");
                        person.setAge(scanner.nextInt());
                        scanner.nextLine();

                        System.out.println("Pessoa atualizada com sucesso!");

                    } else {
                        System.out.println("Índice inválido.");
                    }
                }
            }

        } while (option != 5);

        System.out.println("Sistema encerrado.");
        scanner.close();
    }
}