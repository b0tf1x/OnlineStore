package product.mapper;

import category.model.Category;
import producer.model.Producer;
import product.dto.ProductDto;
import product.dto.ProductFullDto;
import product.model.Product;

public class ProductMapper {
    public static ProductDto toCreateProductDto(Product product) {
        return new ProductDto(product.getId(),
                product.getPrice(),
                product.getName(),
                product.getDescription(),
                product.getApplication(),
                product.getAmount(),
                product.getCategory().getId(),
                product.getProducer().getId(),
                product.getOnSale(),
                product.getSalePrice());
    }

    public static Product toProduct(ProductDto productDto, Category category, Producer producer) {
        return new Product(productDto.getId(),
                productDto.getPrice(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getApplication(),
                productDto.getAmount(),
                category,
                producer,
                productDto.getOnSale(),
                productDto.getSalePrice());
    }

    public static ProductFullDto toProductFullDto(Product product) {
        return new ProductFullDto(product.getId(),
                product.getPrice(),
                product.getName(),
                product.getDescription(),
                product.getApplication(),
                product.getAmount(),
                product.getCategory(),
                product.getProducer(),
                product.getOnSale(),
                product.getSalePrice());
    }
}
