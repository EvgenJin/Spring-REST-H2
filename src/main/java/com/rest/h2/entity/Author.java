package com.rest.h2.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Author")
public class Author implements Serializable {

    @Column(name = "Id", nullable = false, length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FirstName")
    @NotBlank(message = "Enter the author's first name")
//    @Getter @Setter
    public String firstName;

    @Column(name = "LastName")
    @NotBlank(message = "Enter the author's last name")
//    @Getter @Setter
    public String lastName;


    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
//    private Set<Book> books = new HashSet<>();
    private List<Book> books;

    public Author() {

    }

    public Long getId() {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    public void setBooks(Set<Book> books) {
//        this.books = books;
//    }

    @XmlTransient
    public List<Book> getBookList() {
        return books;
    }

    public void setOrderList(List<Book> books) {
        this.books = books;
    }

    public void setBooks(Set<Book> books) {

    }
}