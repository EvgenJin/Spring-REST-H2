package com.rest.h2.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ORDERS")

public class Order implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Integer id;
    

    @Column(name = "Title" , length = 255)
    private String title;

    @Column(name = "price", length = 64)
    private Integer price;

    @JoinColumn(name = "person_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Person person;

    public Integer getId() {
        return id;
    }
    

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) { this.title = title; }

    public Integer getPrice() {return price;}

    public void setPrice(Integer price) {this.price = price;}

}
