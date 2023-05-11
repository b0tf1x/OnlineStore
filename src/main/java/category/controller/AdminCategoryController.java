package category.controller;

import category.dto.CategoryDto;
import category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category")
@RequiredArgsConstructor
public class AdminCategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public CategoryDto create(@RequestBody @Validated CategoryDto categoryDto){
        return categoryService.create(categoryDto);
    }
    @PatchMapping("/{categoryId}")
    public CategoryDto update(@RequestBody @Validated CategoryDto categoryDto, @PathVariable Long categoryId){
        return categoryService.update(categoryDto, categoryId);
    }
    @DeleteMapping("/{categoryId}")
    public void delete(@PathVariable Long categoryId){
        categoryService.delete(categoryId);
    }

}
