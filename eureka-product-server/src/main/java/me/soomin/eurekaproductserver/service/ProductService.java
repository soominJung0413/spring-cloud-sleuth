package me.soomin.eurekaproductserver.service;

import me.soomin.eurekaproductserver.domain.Product;

public interface ProductService {

    Product register(Product product);

    Product findById(Long id);
}
