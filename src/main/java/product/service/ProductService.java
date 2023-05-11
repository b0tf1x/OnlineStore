package product.service;

import product.dto.ProductDto;
import product.dto.ProductFullDto;

import java.util.List;

public interface ProductService {
    List<ProductFullDto>findAll();
    ProductFullDto findById(Long productId);
    ProductDto create(ProductDto productDto);

    ProductDto update(ProductDto productDto, Long productId);

    void delete(Long productId);
    List<ProductFullDto>findByCategory(String category);
}
