package com.orderProduct.orderproduct.mapper;

import com.orderProduct.orderproduct.dto.ProductDto;
import com.orderProduct.orderproduct.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ProductMapper {
    private ModelMapper modelMapper;
    private final SimpleDateFormat dateFormat
            = new SimpleDateFormat("MMM d, yyyy");

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

public ProductDto convertProductDto(Product product) {
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
    productDto.setUpdated(dateFormat.format(product.getUpdated()));
    return  productDto;
}

}
