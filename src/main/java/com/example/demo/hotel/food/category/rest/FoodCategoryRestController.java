package com.example.demo.hotel.food.category.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hotel.food.category.pojo.FoodCategory;
import com.example.demo.hotel.food.category.pojo.Status;
import com.example.demo.hotel.food.category.service.FoodCategoryService;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodCategoryRestController.
 */
@RestController
@RequestMapping("/hotel")
public class FoodCategoryRestController {

	/** The category service. */
	@Autowired
	private FoodCategoryService categoryService;
	
	@GetMapping("allcategory")
	public ResponseEntity<List<FoodCategory>> listAllProducts(){
		List<FoodCategory> foodCategories = categoryService.getAllCategory();
		if (foodCategories.isEmpty()) {
			return new ResponseEntity<List<FoodCategory>>(foodCategories, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FoodCategory>>(foodCategories, HttpStatus.OK);
	}

	/**
	 * Adds the category.
	 *
	 * @param foodCategory the food category
	 * @return the status
	 */
	@PostMapping("addcategory")
	public ResponseEntity<?> addCategory(@RequestBody FoodCategory foodCategory) {

		if ((foodCategory.getCategory_id() == null) || (foodCategory.getCategory_name() == null)
				|| (foodCategory.getCategory_description() == null)) {

//			Status status = new Status("Please Provide all details");

			return new ResponseEntity<>(new Status("Unable to create. Some fields are missing "),HttpStatus.CONFLICT);	

		} else if (categoryService.iscategorypresent(foodCategory.getCategory_id())) {
			//Status status = new Status("This Category is already Present");

			return new ResponseEntity<>(new Status("Unable to create. A Category with id "+foodCategory.getCategory_id()+" is already present"),HttpStatus.CONFLICT);
		} else {
			categoryService.createCategory(foodCategory);
//			Status status = new Status("SUCCESS");

			return new ResponseEntity<>(foodCategory,HttpStatus.CREATED);

		}

	}

	/**
	 * Update category.
	 *
	 * @param foodCategory the food category
	 * @return the status
	 */
	@PutMapping("updatecategory")
	public Status updateCategory(@RequestBody FoodCategory foodCategory) {

		if (categoryService.iscategorypresent(foodCategory.getCategory_id())) {
			categoryService.createCategory(foodCategory);
			Status status = new Status("Updated Succesfully");

			return status;
		} else {
			Status status = new Status("Category Not Availabale");

			return status;

		}
	}

	/**
	 * Delete category.
	 *
	 * @param foodCategory the food category
	 * @return the status
	 */
	@DeleteMapping("deletecategory")
	public Status deleteCategory(@RequestBody FoodCategory foodCategory) {
		if (categoryService.iscategorypresent(foodCategory.getCategory_id())) {
			categoryService.deleteCategory(foodCategory.getCategory_id());
			Status status = new Status("Deleted Succesfully");

			return status;
		} else {
			Status status = new Status("Category Not Availabale");

			return status;

		}
	}

}
