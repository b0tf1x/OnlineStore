package product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import product.dto.ProductFullDto;
import product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public List<ProductFullDto> findAll() {
    return productService.findAll();
    }
    @GetMapping("/{productId}")
    public ProductFullDto findById(@PathVariable Long productId){
        return productService.findById(productId);
    }
    @GetMapping("/category")
    public List<ProductFullDto> findByCategory(@RequestParam String category){
        return productService.findByCategory(category);
    }
}
