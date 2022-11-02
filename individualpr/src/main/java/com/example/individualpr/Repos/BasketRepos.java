package com.example.individualpr.Repos;

import com.example.individualpr.Models.Basket;
import com.example.individualpr.Models.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BasketRepos extends CrudRepository<Basket,Long> {
    List<Basket> findByQuantity(Long quantity);

}
