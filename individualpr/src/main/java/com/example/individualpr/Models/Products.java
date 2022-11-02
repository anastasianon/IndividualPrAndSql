package com.example.individualpr.Models;

import ch.qos.logback.core.pattern.color.BoldBlueCompositeConverter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 250, message = "От 1 до 250 символов")
    private String titleproducts;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 250, message = "От 1 до 250 символов")
    private String description;
    @NotNull(message = "Ввод обязателен")
    @DecimalMax(value = "200000.0", message = "Максимальное значение 200000.0 руб.")
    @DecimalMin(value = "0.0", message = "Стоимость не может быть меньше 0")
    private Double cost;

    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Stamp stamp;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "currentBalance_id")
    private CurrentBalance currentBalance;

    public ProductContent getProductContent() {
        return productContent;
    }

    public void setProductContent(ProductContent productContent) {
        this.productContent = productContent;
    }

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "productContent_id")
    private ProductContent productContent;

    @OneToMany(mappedBy = "products", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cheque> cheques;

    @OneToMany(mappedBy = "productss", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Basket> baskets;

    public Products(Long id, String titleproducts, String description, Double cost, Stamp stamp, CurrentBalance currentBalance, ProductContent productContent, Set<Cheque> cheques, Set<Basket> baskets) {
        this.id = id;
        this.titleproducts = titleproducts;
        this.description = description;
        this.cost = cost;
        this.stamp = stamp;
        this.currentBalance = currentBalance;
        this.productContent = productContent;
        this.cheques = cheques;
        this.baskets = baskets;
    }

    public Products() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleproducts() {
        return titleproducts;
    }

    public void setTitleproducts(String titleproducts) {
        this.titleproducts = titleproducts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Stamp getStamp() {
        return stamp;
    }

    public void setStamp(Stamp stamp) {
        this.stamp = stamp;
    }

    public CurrentBalance getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(CurrentBalance currentBalance) {
        this.currentBalance = currentBalance;
    }


    public Set<Cheque> getCheques() {
        return cheques;
    }

    public void setCheques(Set<Cheque> cheques) {
        this.cheques = cheques;
    }

    public Set<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }
}
