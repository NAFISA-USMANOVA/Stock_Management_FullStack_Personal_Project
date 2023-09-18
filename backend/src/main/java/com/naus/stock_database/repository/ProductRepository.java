package com.naus.stock_database.repository;

import com.naus.stock_database.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
ProductRepository extends JpaRepository<Product, Long>{
}

