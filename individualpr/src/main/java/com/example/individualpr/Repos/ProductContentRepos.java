package com.example.individualpr.Repos;

import com.example.individualpr.Models.ProductContent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductContentRepos extends CrudRepository<ProductContent,Long> {
    List<ProductContent> findByName(String name);
}
