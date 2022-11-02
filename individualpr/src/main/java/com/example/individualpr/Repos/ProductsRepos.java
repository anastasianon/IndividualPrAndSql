package com.example.individualpr.Repos;

import com.example.individualpr.Models.ProductCategory;
import com.example.individualpr.Models.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepos extends CrudRepository<Products,Long> {
    List<Products> findByTitleproducts(String titleproducts);
    List<Products> findByTitleproductsContains(String titleproducts);
}