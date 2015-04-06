package com.example.controllers.business;

import com.example.orm.entities.Items;
import com.example.orm.entities.Purchase;
import com.example.orm.repositories.ItemsRepository;
import com.example.orm.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @Transactional
    public boolean purchase(List<Integer> itemIds){
        Purchase purchase = new Purchase();
        purchase.setPurchaseDate(new Date());
        List<Items> items = new ArrayList<Items>();
        Double price = new Double(0);
        for(Integer id : itemIds){
            Items item = itemsRepository.findOne(Long.valueOf(id.longValue()));
            items.add(item);
            price += item.getPriceHu();
        }
        purchase.setItems(items);
        purchase.setPrice(price.longValue());
        purchaseRepository.save(purchase);
        return true;
    }

    public List<Purchase> getAll(){
        return purchaseRepository.findAll();
    }

}
