package me.soomin.eurekaproductserver.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.soomin.eurekaproductserver.domain.Product;
import me.soomin.eurekaproductserver.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    @NonNull
    private ProductRepository productRepository;

    @Override
    public Product register(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> selectedProduct_opt = productRepository.findById(id);
        return selectedProduct_opt.orElseThrow(() -> new RuntimeException("Not Exist Product"));
    }
}
