package com.naus.stock_database.controller;

import com.naus.stock_database.model.Product;
import com.naus.stock_database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/product_list") //??? "/product"
public class ProductAPIController {
    @Autowired
    private ProductService productService;
    //    Product product;
    @GetMapping
    public List<Product> productList() {
        return productService.getProductList();
    }

    @GetMapping("/{id}")

    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> product = productService.getProduct(id);
        return ResponseEntity.of(product);
    }
    @PostMapping("/save")
    public Product saveProduct( @RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping("/update/{id}") // or productId ?
    public String updateProductDetails(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return (productService.updateProductDetails(product));
    }
    @DeleteMapping("/delete/{id}") // or id ?
    public String deleteProductDetails( @PathVariable Long id){       //???
        productService.deleteProductDetails(id);
        return "Product with Id" + id + " was Deleted Successfully" ;
    }
}
