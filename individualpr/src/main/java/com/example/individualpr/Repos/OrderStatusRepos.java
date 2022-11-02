package com.example.individualpr.Repos;

import com.example.individualpr.Models.Client;
import com.example.individualpr.Models.OrderStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderStatusRepos extends CrudRepository<OrderStatus,Long> {
    List<OrderStatus> findByName(String name);
}
