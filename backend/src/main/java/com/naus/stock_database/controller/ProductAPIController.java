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
@RequestMapping("/product_list")
public class ProductAPIController {
    @Autowired
    private ProductService productService;
    //   Product product;
    @GetMapping("/all") //Endpoint for listing all prod.s
    public List<Product> productList() {

        return productService.getProductList();
    }
    @GetMapping("/search")   // "/search" for searching products
    public List<Product> foundProductList(@RequestParam String query) {

        return productService.searchProducts(query);
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
    @PutMapping("/update/{id}")
    public String updateProductDetails(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return (productService.updateProductDetails(product));
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProductDetails( @PathVariable Long id){
        productService.deleteProductDetails(id);
        return "Product with Id" + id + " was Deleted Successfully" ;
    }
}
