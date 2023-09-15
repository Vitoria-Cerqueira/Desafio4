package org.example.controller;

import org.example.model.ProductModel;
import org.example.repository.ProductRepository;

public class ProductController {
    ProductRepository productRepository = new ProductRepository();
    ProductModel productModel = new ProductModel();
    public boolean registerProduct(String name, double price){
        if (name == null || name.isEmpty() || price <= 0) {
            System.out.println("Nome e preço do produto são obrigatórios e o preço deve ser maior que zero.");
        }
        productModel.setProduct_name(name);
        productModel.setPrice(price);
        return productRepository.registerProduct(productModel.getProduct_name(), productModel.getPrice());
    }

}
