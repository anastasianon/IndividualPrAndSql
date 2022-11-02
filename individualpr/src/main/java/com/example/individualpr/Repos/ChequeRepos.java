package com.example.individualpr.Repos;

import com.example.individualpr.Models.Basket;
import com.example.individualpr.Models.Cheque;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChequeRepos extends CrudRepository<Cheque,Long> {
    List<Cheque> findByQuantity(Long quantity);

}