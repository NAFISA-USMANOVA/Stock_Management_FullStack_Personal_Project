package com.naus.stock_database.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "products")
@Getter
@Setter

public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productName", nullable = false, length = 30)
    private String productName;

    @Column(name = "productDescription", nullable = false, length = 150)
    private String productDescription;

    @Column(name = "dateDeliveredInStock") //, nullable = false
    private String date;

    @Column(name = "startQuantity", nullable = false, length = 10)
    private int startQuantity;

    @Column(name = "soldQuantity", nullable = false, length = 10)
    private int soldQuantity;

    @Column(name = "rawPrice", nullable = false, length =10)
    private int rawPrice;

    @Column(name = "marketPrice", nullable = false, length =10)
    private int marketPrice;

    @Column(name = "benefits", nullable = false, length =10)
    private int benefits;

    @Column(name = "availableQuantity", nullable = false, length =10)
    private int availableQuantity;

}
