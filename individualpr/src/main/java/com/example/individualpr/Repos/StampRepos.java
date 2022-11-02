package com.example.individualpr.Repos;

import com.example.individualpr.Models.ProductCategory;
import com.example.individualpr.Models.Stamp;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StampRepos extends CrudRepository<Stamp,Long> {
    List<Stamp> findByTitlestamp(String titlestamp);
}
