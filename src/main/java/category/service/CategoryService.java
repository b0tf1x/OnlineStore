package category.service;

import category.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto findById(Long categoryId);

    List<CategoryDto> findAll();

    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto, Long categoryId);

    void delete(Long categoryId);

}
