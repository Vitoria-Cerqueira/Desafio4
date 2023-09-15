package org.example.view;

import org.example.controller.CustomerController;

import java.util.Scanner;

public class CustomerView {

        private CustomerController customerController;
        private Scanner scanner;


        public CustomerView() {
            customerController = new CustomerController();
            scanner = new Scanner(System.in);
        }

        public void displayMenu() {
            int choice;

            do {
                System.out.println("\nMenu do Cliente:");
                System.out.println("1. Registrar Cliente");
                System.out.println("2. Excluir Cliente");
                System.out.println("3. Ver Histórico de Compras");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        registerCustomer();
                        break;
                    case 2:
                        deleteCustomer();
                        break;
                    case 3:
                        viewPurchaseHistory();
                        break;
                    case 4:
                        System.out.println("Saindo do menu do Cliente.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (choice != 4);
        }

    private void registerCustomer() {
        System.out.print("Nome do Cliente: ");
        String name = scanner.nextLine();  // Use nextLine para ler toda a linha.

        System.out.print("Email do Cliente: ");
        String email = scanner.nextLine();  // Use nextLine para ler toda a linha.

        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();  // Use nextLine para ler toda a linha.

        System.out.print("Endereço do Cliente: ");
        String address = scanner.nextLine();  // Use nextLine para ler toda a linha.

        boolean success = customerController.registerCustomer(name, email, cpf, address);

        if (success) {
            System.out.println("Cliente registrado com sucesso.");
        } else {
            System.out.println("Erro ao registrar o cliente.");
        }
    }

        private void deleteCustomer() {
            System.out.print("Digite o CPF do cliente a ser excluído: ");
            String cpf = scanner.next();

            boolean success = customerController.deleteCustomer(cpf);

            if (success) {
                System.out.println("Cliente excluído com sucesso.");
            } else {
                System.out.println("Erro ao excluir o cliente.");
            }
        }

        private void viewPurchaseHistory() {
            System.out.print("Digite o CPF do cliente para ver o histórico de compras: ");
            String cpf = scanner.next();

            boolean success = customerController.showPurchaseHistory(cpf);

            if (!success) {
                System.out.println("Erro ao visualizar o histórico de compras.");
            }
        }
    }


