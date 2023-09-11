package com.naus.stock_database.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;


import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@AllArgsConstructor  //?
@NoArgsConstructor //?
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

    @Column(name = "dateDeliveredInStock", nullable = false)
    private Date date;

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

    // ????
//    public String getProductId() {
//        return productId;
//    }
//
//    public void setProductId(String productId) {
//        this.productId = productId;
//    }


//{
//    private String productId;
//    private String productName;
//    private String productDescription;
//    private String dateDeliveredInStock;
//    private int startQuantity;
//    private int soldQuantity;
//    private int rowPrice;
//    private int marketPrice;
//    private int benefits;
//    private int unitsAvailable;
//    public Product() {
//    }
//
//    public Product(String productId, String productName, String productDescription,
//                    String dateDeliveredInStock,
//                    int startQuantity, int soldQuantity,
//                    int rowPrice, int marketPrice, int benefits, int unitsAvailable) {
//        this.productId = productId;
//        this.productName = productName;
//        this.productDescription = productDescription;
//        this.dateDeliveredInStock = dateDeliveredInStock;
//        this.startQuantity = startQuantity;
//        this.soldQuantity = soldQuantity;
//        this.rowPrice = rowPrice;
//        this.marketPrice = marketPrice;
//        this.benefits = benefits;
//        this.unitsAvailable = unitsAvailable;
//    }
//    public String getProductId() {
//        return productId;
//    }
//
//    public void setProductId(String productId) {
//        this.productId = productId;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public String getProductDescription() {
//        return productDescription;
//    }
//
//    public void setProductDescription(String productDescription) {
//        this.productDescription = productDescription;
//    }
//
//    public String getDateDeliveredInStock() {
//        return dateDeliveredInStock;
//    }
//
//    public void setDateDeliveredInStock(String dateDeliveredInStock) {
//        this.dateDeliveredInStock = dateDeliveredInStock;
//    }
//
//    public int getStartQuantity() {
//        return startQuantity;
//    }
//
//    public void setStartQuantity(int startQuantity) {
//        this.startQuantity = startQuantity;
//    }
//
//    public int getSoldQuantity() {
//        return soldQuantity;
//    }
//
//    public void setSoldQuantity(int soldQuantity) {
//        this.soldQuantity = soldQuantity;
//    }
//
//    public int getRowPrice() {
//        return rowPrice;
//    }
//
//    public void setRowPrice(int rowPrice) {
//        this.rowPrice = rowPrice;
//    }
//
//    public int getMarketPrice() {
//        return marketPrice;
//    }
//
//    public void setMarketPrice(int marketPrice) {
//        this.marketPrice = marketPrice;
//    }
//
//    public int getBenefits() {
//        return benefits;
//    }
//
//    public void setBenefits(int benefits) {
//        this.benefits = benefits;
//    }
//
//    public int getUnitsAvailable() {
//        return unitsAvailable;
//    }
//
//    public void setUnitsAvailable(int unitsAvailable) {
//        this.unitsAvailable = unitsAvailable;
//    }
//
//    public void setId(String productId) {
//    }
}
