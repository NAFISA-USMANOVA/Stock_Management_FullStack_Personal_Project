package com.naus.stock_database.service;

import com.naus.stock_database.model.Product;

import java.util.List;
import java.util.Optional;



import com.naus.stock_database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getProductList() {
        return productRepository.findAll();
    }
    public Optional<Product> getProduct(Long id) {

        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    public String updateProductDetails( Product updateProductDetails) {
        try
        {
            if(productRepository.existsById((Long) updateProductDetails.getId())){
                productRepository.save(updateProductDetails);
                return ("Product Updated:  " + updateProductDetails.getProductName());
            } else {
                return ("Product with ID " + updateProductDetails.getId() + " doesn't exists");
            }
        } catch (Exception error) {
            throw new RuntimeException("Product details are not updated. " + error.getMessage());
        }
    }

    public void deleteProductDetails(Long id) {
        boolean exists = productRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Product with id " + id + "does not exists");
        }
        productRepository.deleteById(id);
    }
}
