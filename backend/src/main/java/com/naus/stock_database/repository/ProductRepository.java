package com.naus.stock_database.repository;

import com.naus.stock_database.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface
ProductRepository extends JpaRepository<Product, Long>{
    // ================== Custom query
    List<Product> findByProductNameContaining(String query);
    // =================
}

