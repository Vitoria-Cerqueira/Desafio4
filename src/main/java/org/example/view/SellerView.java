package org.example.view;

import org.example.controller.ProductController;
import org.example.controller.SaleController;

import java.util.Scanner;

public class SellerView {
    private ProductController productController;
    private SaleController saleController;
    private Scanner scanner;

    public SellerView(){
        productController = new ProductController();
        saleController = new SaleController();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice;

        do {
            System.out.println("Menu do Vendedor:");
            System.out.println("1- Registrar um produto ");
            System.out.println("2- Exibir Itens Vendidos por Mais de R$10");
            System.out.println("3- Atualizar Total de Vendas Nulas para 0");
            System.out.println("4- Registrar Venda");
            System.out.println("5- Exibir todas as vendas");
            System.out.println("6- Sair");
            System.out.print("Escolha uma opção: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerProduct();
                    break;
                case 2:
                    saleController.displayItemsThatHaveBeenSoldForMoreThanTen();
                    break;
                case 3:
                    saleController.changeTotalValueOfSalesThatAreNullTo0();
                    break;
                case 4:
                    registerSale();
                    break;
                case 5:
                    saleController.showAllSales();
                    break;
                case 6:
                    System.out.println("Saindo do menu do Vendedor.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (choice != 6);
    }

    private void registerSale() {
        System.out.print("Quantidade de Produtos Vendidos: ");
        int amount = scanner.nextInt();

        System.out.print("Total da Venda: ");
        Double total = scanner.nextDouble();

        System.out.print("ID do Vendedor: ");
        int idSeller = scanner.nextInt();

        System.out.print("ID do Cliente: ");
        int idCustomer = scanner.nextInt();

        System.out.print("ID do Produto: ");
        int idProduct = scanner.nextInt();

        saleController.registerSale(amount, total, idSeller, idCustomer, idProduct);
    }
    private void registerProduct() {
        System.out.print("Nome do Produto: ");
        String name = scanner.nextLine();

        System.out.print("Preço do Produto: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        boolean success = productController.registerProduct(name, price);

        if (success) {
            System.out.println("Produto registrado com sucesso.");
        } else {
            System.out.println("Erro ao registrar o produto.");
        }
    }


}
