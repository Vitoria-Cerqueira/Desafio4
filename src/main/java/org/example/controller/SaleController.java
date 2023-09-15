package org.example.controller;

import org.example.model.SaleModel;
import org.example.repository.SaleRepository;

public class SaleController {
    SaleRepository saleRepository = new SaleRepository();
    SaleModel saleModel = new SaleModel();
    public boolean registerSale(int amount,Double total,int id_seller, int id_customer, int id_product){
        if (amount <= 0 ){
            System.out.println("A quantidade deve ser valore positivo");
        }
        saleModel.setAmount(amount);
        saleModel.setTotal(total);
        saleModel.setFk_idseller(id_seller);
        saleModel.setFk_idcustomer(id_customer);
        saleModel.setFk_idproduct(id_product);
        return saleRepository.registerSale(saleModel.getAmount(), saleModel.getTotal(), saleModel.getFk_idseller(), saleModel.getFk_idcustomer(), saleModel.getFk_idproduct());
    }
    public boolean displayItemsThatHaveBeenSoldForMoreThanTen(){
        return saleRepository.displayItemsThatHaveBeenSoldForMoreThanTen();
    }
    public boolean changeTotalValueOfSalesThatAreNullTo0(){
        return saleRepository.changeTotalValueOfSalesThatAreNullTo0();
    }
    public boolean showAllSales(){
        return saleRepository.showAllSales();
    }

}
