package com.orderProduct.orderproduct.dto;

import com.orderProduct.orderproduct.model.OrderItem;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;

public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private double price;
    private String created;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", created='" + created + '\'' +
                '}';
    }
}
