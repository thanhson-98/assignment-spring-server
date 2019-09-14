package com.example.repository;

import com.example.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketRepository extends JpaRepository<Market, Long> {
    List<Market> findAllByNameAndStatus(String name, int status);
}
