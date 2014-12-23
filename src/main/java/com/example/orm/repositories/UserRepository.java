package com.example.orm.repositories;

import com.example.orm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 2014.09.18..
 */
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //@Query("select u from User u where u.email = ?1 and u.password = ?2")
    //public List<User> findByEmailAndPassword( String email, String password);

}
