package com.example.individualpr.Repos;

import com.example.individualpr.Models.ProductCategory;
import com.example.individualpr.Models.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductTypeRepos extends CrudRepository<ProductType,Long> {
    List<ProductType> findByName(String name);
}
