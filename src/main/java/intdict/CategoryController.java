package intdict;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import entities.Category;
import entities.CategoryDAO;

@RestController
@RequestMapping("/intdict")
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@PostMapping("/categories")
	public Category createCategory(@Valid @RequestBody Category category) {
		return categoryDAO.save(category);
	}
	
	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryDAO.findAll();
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable(value="id") Long categoryId) {
		
		Category category = categoryDAO.findOne(categoryId);
		
//		if (category == null) {
//			return ResponseEntity.notFound().build();
//		}
		
		return ResponseEntity.ok().body(category);
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable(value="id") Long categoryId, @Valid @RequestBody Category categoryDetails) {
		
		Category category = categoryDAO.findOne(categoryId);
		
		category.setName(categoryDetails.getName());
		
		Category updateCategory = categoryDAO.save(category);
		return ResponseEntity.ok().body(updateCategory);
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable(value="id") Long categoryId) {
		
		Category category = categoryDAO.findOne(categoryId);
		categoryDAO.delete(category);
		
		return ResponseEntity.ok().build();
	}
	
}
