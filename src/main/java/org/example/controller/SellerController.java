package org.example.controller;

import org.example.repository.SellerRepository;
public class SellerController {
    SellerRepository sellerRepository = new SellerRepository();
    public boolean showSellerSalariesOfInDescendingOrder() {
        return sellerRepository.showSellerSalariesOfInDescendingOrder();
    }

}
