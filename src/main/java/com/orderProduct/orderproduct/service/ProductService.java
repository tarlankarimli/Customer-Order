package com.orderProduct.orderproduct.service;

import com.orderProduct.orderproduct.dto.ProductDto;
import com.orderProduct.orderproduct.mapper.ProductMapper;
import com.orderProduct.orderproduct.model.Product;
import com.orderProduct.orderproduct.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getProductList() {
        return productRepository.findAll().stream().map(x -> productMapper.convertProductDto(x)).collect(Collectors.toList());
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
