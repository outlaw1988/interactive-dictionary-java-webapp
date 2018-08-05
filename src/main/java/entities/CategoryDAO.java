package entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryDAO {

	@Autowired
	CategoryRepository categoryRepository;
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findOne(Long categoryId) {
		return categoryRepository.findOne(categoryId);
	}
	
	public void delete(Category category) {
		categoryRepository.delete(category);
	}
	
}
