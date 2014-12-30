package com.example.orm.repositories;

import com.example.orm.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {
}
