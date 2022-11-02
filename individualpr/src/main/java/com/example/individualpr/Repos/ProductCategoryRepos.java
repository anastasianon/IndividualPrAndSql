package com.example.individualpr.Repos;

import com.example.individualpr.Models.Client;
import com.example.individualpr.Models.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepos extends CrudRepository<ProductCategory,Long> {
    List<ProductCategory> findByName(String name);
}
