package com.example.orm.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Entity(name = "purchase")
@Table(name = "purchase",schema = "public")
@XmlRootElement
public class Purchase {

    @Id
    @SequenceGenerator(name="seq_purchase_sequence",
            sequenceName="seq_purchase_sequence",
            allocationSize=1,initialValue = 1)
    @GeneratedValue(generator="seq_purchase_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "price")
    private Long price;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "items_purchase",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Items> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

}
