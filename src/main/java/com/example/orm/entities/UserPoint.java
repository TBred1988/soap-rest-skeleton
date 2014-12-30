package com.example.orm.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "user_point",schema = "public")
@Entity(name = "user_point")
@XmlRootElement
public class UserPoint {

    @Id
    @SequenceGenerator(name="seq_user_point_sequence",
            sequenceName="seq_user_point_sequence",
            allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user_point_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "act_point")
    private Long actPoint;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActPoint() {
        return actPoint;
    }

    public void setActPoint(Long actPoint) {
        this.actPoint = actPoint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
