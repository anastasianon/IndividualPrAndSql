package com.example.individualpr.Repos;

import com.example.individualpr.Models.Client;
import com.example.individualpr.Models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepos extends CrudRepository<Order,Long> {
    List<Order> findByData(Date data);
}
