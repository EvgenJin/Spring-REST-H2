package com.rest.h2.entity;
import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDERS")

public class Order implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Title" , length = 255)
    @Getter @Setter
    private String title;

    @Column(name = "price", length = 64)
    @Getter @Setter
    private Integer price;

    @JoinColumn(name = "person_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Person person;

}
