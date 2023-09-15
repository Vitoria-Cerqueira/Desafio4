package org.example.view;

import java.util.Scanner;

public class MainMenuView {
    private CustomerView customerView;
    private SellerView sellerView;
    private ManagerView managerView;
    private Scanner scanner;

    public MainMenuView() {
        this.customerView = new CustomerView();
        this.sellerView = new SellerView();
        this.managerView = new ManagerView();
        this.scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        int choice;

        do {
            System.out.println("Menu Principal:");
            System.out.println("1. Menu do Cliente");
            System.out.println("2. Menu do Vendedor");
            System.out.println("3. Menu do Gerente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customerView.displayMenu();
                    break;
                case 2:
                    sellerView.displayMenu();
                    break;
                case 3:
                    managerView.displayMenu();
                    break;
                case 4:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (choice != 4);
    }
}
