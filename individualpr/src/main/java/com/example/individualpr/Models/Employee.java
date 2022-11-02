package com.example.individualpr.Models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.awt.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 100, message = "От 1 до 100 символов")
    private String surname;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 100, message = "От 1 до 100 символов")
    private String name;

    @Size(min = 1, max = 100, message = "От 1 до 100 символов")
    private String middlename;

    @NotNull(message = "Поле не может быть пустым")
    private Long serialpassport;

    @NotNull(message = "Поле не может быть пустым")
    private Long numberpassport;

    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 250, message = "От 1 до 250 символов")
    private String address;

    @NotNull(message = "Поле не может быть пустым")
    private Long numberphone;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Post post;

    @OneToMany(mappedBy = "employees", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cheque> cheques;

    public Employee(Long id, String surname, String name, String middlename, Long serialpassport, Long numberpassport, String address, Long numberphone, User user, Post post, Set<Cheque> cheques) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.serialpassport = serialpassport;
        this.numberpassport = numberpassport;
        this.address = address;
        this.numberphone = numberphone;
        this.user = user;
        this.post = post;
        this.cheques = cheques;
    }

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Long getSerialpassport() {
        return serialpassport;
    }

    public void setSerialpassport(Long serialpassport) {
        this.serialpassport = serialpassport;
    }

    public Long getNumberpassport() {
        return numberpassport;
    }

    public void setNumberpassport(Long numberpassport) {
        this.numberpassport = numberpassport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(Long numberphone) {
        this.numberphone = numberphone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Set<Cheque> getCheques() {
        return cheques;
    }

    public void setCheques(Set<Cheque> cheques) {
        this.cheques = cheques;
    }
}
