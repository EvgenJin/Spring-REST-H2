package com.rest.h2.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "PERSON")
//    @NamedQueries({
//        @NamedQuery(name = "Person.findById", query = "SELECT c FROM Person c WHERE c.id = :id")
//    })
public class Person implements Serializable {
 
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Full_Name", length = 64, nullable = false)
    private String fullName;
 
    @Temporal(TemporalType.DATE)
    @Column(name = "Date_Of_Birth", nullable = false)
    private Date dateOfBirth;

    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getFullName() {
        return fullName;
    }
 
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
 
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
 
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}