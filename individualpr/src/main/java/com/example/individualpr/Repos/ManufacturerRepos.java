package com.example.individualpr.Repos;

import com.example.individualpr.Models.Client;
import com.example.individualpr.Models.Manufacturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManufacturerRepos extends CrudRepository<Manufacturer,Long> {
    List<Manufacturer> findByName(String name);
}
