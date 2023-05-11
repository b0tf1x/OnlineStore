package product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import product.dto.ProductDto;
import product.service.ProductService;

@RestController
@RequestMapping("/admin/product")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDto create(@RequestBody @Validated ProductDto productDto) {
        return productService.create(productDto);
    }

    @PatchMapping("/{productId}")
    public ProductDto update(@RequestBody @Validated ProductDto productDto, @PathVariable Long productId) {
        return productService.update(productDto, productId);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable Long productId) {
        productService.delete(productId);
    }
}
