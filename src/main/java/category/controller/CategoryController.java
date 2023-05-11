package category.controller;

import category.dto.CategoryDto;
import category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public List <CategoryDto>findAll(){
        return categoryService.findAll();
    }
    @GetMapping("/{categoryId}")
    public CategoryDto findById(@PathVariable Long categoryId){
        return categoryService.findById(categoryId);
    }
}
