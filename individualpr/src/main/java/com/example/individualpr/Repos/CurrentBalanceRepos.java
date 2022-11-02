package com.example.individualpr.Repos;

import com.example.individualpr.Models.Client;
import com.example.individualpr.Models.CurrentBalance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrentBalanceRepos extends CrudRepository<CurrentBalance,Long> {
    List<CurrentBalance> findByQuantity(Long quantity);
}
