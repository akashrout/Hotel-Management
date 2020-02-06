package com.example.demo.hotel.food.category.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;
import com.example.demo.hotel.food.category.pojo.Status;
import com.example.demo.hotel.food.category.service.FoodCategoryService;
import com.example.demo.hotel.food.category.validations.CategoryValidator;

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
	@Autowired
	private CategoryValidator categoryValidator;

	@GetMapping("allcategory")
	public ResponseEntity<List<FoodCategoryEntity>> listAllProducts() {
		List<FoodCategoryEntity> foodCategories = categoryService.getAllCategory();
		if (foodCategories.isEmpty()) {
			return new ResponseEntity<List<FoodCategoryEntity>>(foodCategories, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FoodCategoryEntity>>(foodCategories, HttpStatus.OK);
	}

	/**
	 * Adds the category.
	 *
	 * @param foodCategory the food category
	 * @return the status
	 */
	@PostMapping("addcategory")

	public ResponseEntity<FoodCategoryBean> addCategory(@RequestBody FoodCategoryBean foodCategory) {
		System.out.println("Inputed Data Are: " + foodCategory);

		boolean isvalue = categoryValidator.validateCategoryForEmptyData(foodCategory);
		if (isvalue) {

			if (categoryValidator.isCategoryNamePresent(foodCategory)) {
				return new ResponseEntity(new Status("Category Name already Present, Please try another one... "),
						HttpStatus.CONFLICT);
			} else {
				FoodCategoryBean foodCategoryBean = categoryService.createCategory(foodCategory);
				System.out.println("Inputed Data Are: " + foodCategoryBean);
				return new ResponseEntity<>(foodCategoryBean, HttpStatus.CREATED);

			}

		} else {
			return new ResponseEntity(new Status("Unable to create. Some fields are missing "), HttpStatus.CONFLICT);

		}

// 
//		if ((foodCategory.getCategoryId()d() == null) || (foodCategory.getCategory_name() == null)
//				|| (foodCategory.getCategory_description() == null)) { 
//
////			Status status = new Status("Please Provide all details");
//
//			return new ResponseEntity<FoodCategoryBean>(new Status("Unable to create. Some fields are missing "),HttpStatus.CONFLICT);	
//
//		} else if (categoryService.iscategorypresent(foodCategory.getCategory_id())) {
//			//Status status = new Status("This Category is already Present");
//
//			return new ResponseEntity<>(new Status("Unable to create. A Category with id "+foodCategory.getCategory_id()+" is already present"),HttpStatus.CONFLICT);
//		} else {
//			FoodCategoryBean FoodCategoryBean =categoryService.createCategory(foodCategory);
////			Status status = new Status("SUCCESS");
//
//			return new ResponseEntity<>(foodCategory,HttpStatus.CREATED);
//
//		}

	}

	/**
	 * Update category.
	 *
	 * @param foodCategory the food category
	 * @return the status
	 */
	@PutMapping("updatecategory")
	public Status updateCategory(@RequestBody FoodCategoryBean foodCategory) {

		if (categoryService.iscategorypresent(foodCategory.getCategoryId())) {
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
	public Status deleteCategory(@RequestBody FoodCategoryBean foodCategory) {
		if (categoryService.iscategorypresent(foodCategory.getCategoryId())) {
			categoryService.deleteCategory(foodCategory.getCategoryId());
			Status status = new Status("Deleted Succesfully");

			return status;
		} else {
			Status status = new Status("Category Not Availabale");

			return status;

		}
	}

}
