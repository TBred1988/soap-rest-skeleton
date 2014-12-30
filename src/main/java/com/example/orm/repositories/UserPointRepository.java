package com.example.orm.repositories;

import com.example.orm.entities.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserPointRepository  extends JpaRepository<UserPoint, Integer> {

    List<UserPoint> findByUserId(Long userId);
}
