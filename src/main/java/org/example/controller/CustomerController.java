package org.example.controller;

import org.example.repository.CustomerRepository;

public class CustomerController {
   private CustomerRepository customerRepository = new CustomerRepository();

    public boolean registerCustomer(String name, String email, String cpf, String address){
        if (name == null || name.isEmpty() || email == null || email.isEmpty() || cpf == null || cpf.isEmpty() || address == null || address.isEmpty()) {
            System.out.println("Todos os campos são obrigatórios.");
        }
        return customerRepository.registerCustomer(name, email, cpf, address);
    }

    public boolean deleteCustomer(String cpf){
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("O CPF é obrigatório.");
        }
        return customerRepository.deleteCustomer(cpf);
    }
    public boolean showPurchaseHistory(String cpf){
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("O CPF é obrigatório.");
        }
        return customerRepository.showPurchaseHistory(cpf);
    }
}

