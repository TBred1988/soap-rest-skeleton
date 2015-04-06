package com.example.orm.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by user on 2014.09.18..
 */

@Table(name = "user",schema = "public")
@Entity(name = "user")
@XmlRootElement
public class User {


    @Id
    @SequenceGenerator(name="seq_user_sequence",
            sequenceName="seq_user_sequence",
            allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
