package org.example.view;

import org.example.controller.ManagerController;
import org.example.controller.SellerController;

import java.util.Scanner;

public class ManagerView {
        private ManagerController managerController;
        private SellerController sellerController;
        private Scanner scanner;

        public ManagerView() {
            managerController = new ManagerController();
            sellerController = new SellerController();
            scanner = new Scanner(System.in);
        }

        public void displayMenu() {
            int choice;

            do {
                System.out.println("\nMenu do Gerente:");
                System.out.println("1. Login");
                System.out.println("2. Visualizar E-mails das Pessoas");
                System.out.println("3. Visualizar Salários dos Vendedores (em ordem decrescente)");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        viewEmailsOfPeople();
                        break;
                    case 3:
                        viewSellerSalariesDescending();
                        break;
                    case 4:
                        System.out.println("Saindo do menu do Gerente.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (choice != 4);
        }

        private void login() {
            System.out.print("Email: ");
            String email = scanner.next();

            System.out.print("Senha: ");
            String password = scanner.next();

            boolean success = managerController.login(email, password);

            if (success) {
                System.out.println("Login bem-sucedido.");
            } else {
                System.out.println("Erro no login. Verifique suas credenciais.");
            }
        }

        private void viewEmailsOfPeople() {
            boolean success = managerController.ShowEmailOfPeople();

            if (success) {
                System.out.println("E-mails das pessoas exibidos com sucesso.");
            } else {
                System.out.println("Erro ao exibir os e-mails das pessoas.");
            }
        }

        private void viewSellerSalariesDescending() {
            boolean success = sellerController.showSellerSalariesOfInDescendingOrder();

            if (success) {
                System.out.println("Salários dos vendedores exibidos em ordem decrescente com sucesso.");
            } else {
                System.out.println("Erro ao exibir os salários dos vendedores.");
            }
        }
    }

