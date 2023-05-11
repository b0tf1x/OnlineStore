package product.service;

import category.model.Category;
import category.repository.CategoryRepository;
import exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producer.model.Producer;
import producer.repository.ProducerRepository;
import product.dto.ProductDto;
import product.dto.ProductFullDto;
import product.mapper.ProductMapper;
import product.model.Product;
import product.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProducerRepository producerRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ProductFullDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toProductFullDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductFullDto findById(Long productId) {
        return ProductMapper.toProductFullDto(checkProduct((productId)));
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        Category category = checkCategory(productDto.getCategory());
        Producer producer = checkProducer(productDto.getProducer());
        Product product = productRepository.save(ProductMapper.toProduct(productDto, category, producer));
        return ProductMapper.toCreateProductDto(product);
    }

    @Override
    public ProductDto update(ProductDto productDto, Long productId) {
        Product product = checkProduct(productId);
        if (productDto.getOnSale() != null) {
            product.setOnSale(productDto.getOnSale());
        }
        if (productDto.getProducer() != null) {
            Producer producer = checkProducer(productDto.getProducer());
            product.setProducer(producer);
        }
        if (productDto.getCategory() != null) {
            Category category = checkCategory(productDto.getCategory());
            product.setCategory(category);
        }
        if (productDto.getAmount() != null) {
            product.setAmount(productDto.getAmount());
        }
        if (productDto.getName() != null) {
            product.setName(productDto.getName());
        }
        if (productDto.getApplication() != null) {
            product.setAmount(productDto.getAmount());
        }
        if (productDto.getDescription() != null) {
            product.setDescription(productDto.getDescription());
        }
        if (productDto.getPrice() != null) {
            product.setPrice(productDto.getPrice());
        }
        if (productDto.getSalePrice() != null) {
            product.setSalePrice(productDto.getSalePrice());
        }
        product = productRepository.save(product);
        return ProductMapper.toCreateProductDto(product);
    }

    @Override
    public void delete(Long productId) {
        checkProduct(productId);
        producerRepository.deleteById(productId);
    }
    @Override
    public List<ProductFullDto>findByCategory(String category){
        return productRepository.findByCategory(category);
    }

    private Product checkProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> {
            throw new NotFoundException("Продукт не найден");
        });
    }

    private Category checkCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> {
            throw new NotFoundException("Категория не найдена");
        });
    }

    private Producer checkProducer(Long producerId) {
        return producerRepository.findById(producerId).orElseThrow(() -> {
            throw new NotFoundException("Производитель не найден");
        });
    }
}
