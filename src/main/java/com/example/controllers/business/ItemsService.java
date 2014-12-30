package com.example.controllers.business;

import com.example.orm.entities.Items;
import com.example.orm.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    public List<Items> getAllItems(){
        return itemsRepository.findAll();
    }
}
