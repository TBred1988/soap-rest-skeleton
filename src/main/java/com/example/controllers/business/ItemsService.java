package com.example.controllers.business;

import com.example.orm.entities.Items;
import com.example.orm.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public List<Items> getAllItems(){
        return itemsRepository.findAll();
    }

    @Transactional
    public Boolean createItem(String name, Double price, String shortName){
        Items newItem = new Items();
        newItem.setName(name);
        newItem.setPriceHu(price);
        newItem.setShortName(shortName);
        Items result = itemsRepository.save(newItem);
        return result != null;
    }
}
