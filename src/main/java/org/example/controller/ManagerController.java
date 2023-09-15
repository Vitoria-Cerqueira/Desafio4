package org.example.controller;

import org.example.model.ManagerModel;
import org.example.repository.ManagerRepository;

public class ManagerController {
    ManagerRepository menagerRepository = new ManagerRepository();
    ManagerModel menagerModel = new ManagerModel();

    public boolean login(String email, String password) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Email e senha são obrigatórios.");
        }
        menagerModel.setEmail(email);
        menagerModel.setPassword(password);
        return menagerRepository.login(menagerModel.getEmail(), menagerModel.getPassword());
    }
    public boolean ShowEmailOfPeople() {
        return menagerRepository.ShowEmailOfPeople();
    }


}
