package category.service;

import category.dto.CategoryDto;
import category.mapper.CategoryMapper;
import category.model.Category;
import category.repository.CategoryRepository;
import exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public CategoryDto findById(Long categoryId){
        return CategoryMapper.toCategoryDto(checkCategory(categoryId));
    }
    @Override
    public List<CategoryDto>findAll(){
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }
    @Override
    public CategoryDto create(CategoryDto categoryDto){
        Category category = categoryRepository.save(CategoryMapper.toCategory(categoryDto));
        return CategoryMapper.toCategoryDto(category);
    }
    @Override
    public CategoryDto update(CategoryDto categoryDto, Long categoryId){
        Category category = checkCategory(categoryId);
        if (categoryDto.getDescription()!=null && !categoryDto.getDescription().isBlank()){
            category.setDescription(categoryDto.getDescription());
        }
        if (categoryDto.getName()!=null && !categoryDto.getName().isBlank()){
            category.setName(categoryDto.getName());
        }
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDto(category);
    }
    @Override
    public void delete(Long categoryId){
        checkCategory(categoryId);
        categoryRepository.deleteById(categoryId);
    }
    private Category checkCategory(Long categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(()->{
            throw new NotFoundException("Категория не найдена");
        });
    }
}
