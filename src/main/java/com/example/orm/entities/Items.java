package com.example.orm.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "items",schema = "public")
@Entity(name = "items")
@XmlRootElement
public class Items {

    @Id
    @SequenceGenerator(name="seq_items_sequence",
            sequenceName="seq_items_sequence",
            allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_items_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "name")
    private String name;

    @Column(name = "price_hu")
    private Double priceHu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceHu() {
        return priceHu;
    }

    public void setPriceHu(Double priceHu) {
        this.priceHu = priceHu;
    }

}
