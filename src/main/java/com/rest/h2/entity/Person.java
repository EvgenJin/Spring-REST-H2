package com.rest.h2.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PERSON")
//    @NamedQueries({
//        @NamedQuery(name = "Person.findById", query = "SELECT c FROM Person c WHERE c.id = :id")
//    })
public class Person implements Serializable {
 
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    @Getter @Setter
    private Integer id;

    @Column(name = "Full_Name", length = 64, nullable = false)
    @Getter @Setter
    private String fullName;
 
    @Temporal(TemporalType.DATE)
    @Column(name = "Date_Of_Birth", nullable = false)
    @Getter @Setter
    private Date dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Order> orderList;

    @XmlTransient
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}