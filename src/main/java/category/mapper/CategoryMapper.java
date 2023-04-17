package category.mapper;

import category.dto.CategoryDto;
import category.model.Category;

public class CategoryMapper {
    public static Category toCategory(CategoryDto categoryDto){
        return new Category(categoryDto.getId(),
                categoryDto.getName(),
                categoryDto.getDescription());
    }
    public static CategoryDto toCategoryDto(Category category){
        return new CategoryDto(category.getId(),
                category.getName(),
                category.getDescription());
    }
}
