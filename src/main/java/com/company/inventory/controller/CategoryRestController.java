package com.company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	@Autowired
	private ICategoryService service;
	
	/**
	 * Method to search all categories
	 * 
	 * @return ResponseEntity<CategoryResponseRest>
	 */
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest> searchCategories() {
		
		ResponseEntity<CategoryResponseRest> response = service.search();
		return response;
	}
	
	/**
	 * Method to search a category by id
	 * 
	 * @param id
	 * @return ResponseEntity<CategoryResponseRest>
	 */
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryResponseRest> searchCategoryById(@PathVariable Long id) {

		ResponseEntity<CategoryResponseRest> response = service.searchById(id);
		return response;
	}
	
	/**
	 * Method to save a category
	 * 
	 * @param Category
	 * @return ResponseEntity<CategoryResponseRest>
	 */
	@PostMapping("/categories")
	public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category) {

		ResponseEntity<CategoryResponseRest> response = service.save(category);
		return response;
	}
	
	/**
	 * Method to update a category
	 * @param id
	 * @param category
	 * @return ResponseEntity<CategoryResponseRest>
	 */
	@PutMapping("/categories/{id}")
	public ResponseEntity<CategoryResponseRest> update(@PathVariable Long id, @RequestBody Category category) {

		ResponseEntity<CategoryResponseRest> response = service.update(id, category);
		return response;
	}
}
