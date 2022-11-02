package com.example.individualpr.Repos;

import com.example.individualpr.Models.Basket;
import com.example.individualpr.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepos extends JpaRepository<Client,Long> {
}