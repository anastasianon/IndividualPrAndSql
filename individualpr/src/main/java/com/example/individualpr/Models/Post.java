package com.example.individualpr.Models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Поле не может быть пустым")
    @Size(min = 1, max = 255, message = "От 1 до 255 символов")
    private String titlepost;

    @NotNull(message = "Не может быть пустым")
    @DecimalMax(value = "300000.0", message = "Оклад не может быть больше 300000 рублей")
    @DecimalMin(value = "0.0", message = "Оклад не может быть меньше 0 рублей")
    private Double salary;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Employee> employees;

    public Post(Long id, String titlepost, Double salary, Collection<Employee> employees) {
        this.id = id;
        this.titlepost = titlepost;
        this.salary = salary;
        this.employees = employees;
    }

    public Post() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitlepost() {
        return titlepost;
    }

    public void setTitlepost(String titlepost) {
        this.titlepost = titlepost;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
