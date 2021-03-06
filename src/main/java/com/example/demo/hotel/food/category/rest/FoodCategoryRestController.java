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
@RequestMapping("/category")
public class FoodCategoryRestController {

	/** The category service. */
	@Autowired
	private FoodCategoryService categoryService;
	@Autowired
	private CategoryValidator categoryValidator;

	@GetMapping("getall")
	public ResponseEntity<List<FoodCategoryBean>> listAllProducts() {
		List<FoodCategoryBean> foodCategories = categoryService.getAllCategory();
		if (foodCategories.isEmpty()) {
			return new ResponseEntity<List<FoodCategoryBean>>(foodCategories, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FoodCategoryBean>>(foodCategories, HttpStatus.OK);
	}

	/**
	 * Adds the category.
	 *
	 * @param foodCategory the food category
	 * @return the status
	 */
	@PostMapping("create")
	public ResponseEntity<FoodCategoryBean> addCategory(@RequestBody FoodCategoryBean foodCategory) {
		System.out.println("Inputed Data Are: " + foodCategory);

		if (categoryValidator.validateCategoryForEmptyData(foodCategory)) {

			if (categoryValidator.isCategoryNamePresent(foodCategory.getCategoryName())) {
				return new ResponseEntity(new Status("Category Name already Present, Please try another one... "),
						HttpStatus.NOT_ACCEPTABLE);
			} else {
				FoodCategoryBean foodCategoryBean = categoryService.createCategory(foodCategory);
				System.out.println("Inputed Data Are: " + foodCategoryBean);
				return new ResponseEntity<>(foodCategoryBean, HttpStatus.CREATED);

			}

		} else {
			return new ResponseEntity(new Status("Unable to create. Some fields are missing "), HttpStatus.CONFLICT);

		}

	}

	/**
	 * Update category.
	 *
	 * @param foodCategory the food category
	 * @return the status
	 */
	@PutMapping("update")
	public ResponseEntity<FoodCategoryBean> updateCategory(@RequestBody FoodCategoryBean foodCategory) {
		if (categoryValidator.validateCategoryForEmptyData(foodCategory)) {

			if (categoryValidator.isIdPresent(foodCategory.getCategoryId())) {
				FoodCategoryBean bean = categoryService.updateCategory(foodCategory);
				return new ResponseEntity(bean, HttpStatus.ACCEPTED);

			} else {

				return new ResponseEntity(new Status("Unable to update, Category Id or Category Name not available "),
						HttpStatus.NOT_ACCEPTABLE);

			}
		} else {
			return new ResponseEntity(new Status("Unable to create. Some fields are missing "), HttpStatus.CONFLICT);

		}
	}

	/**
	 * Delete category.
	 *
	 * @param foodCategory the food category
	 * @return the status
	 */
	@DeleteMapping("delete")
	public ResponseEntity<FoodCategoryBean> deleteCategory(@RequestBody FoodCategoryBean foodCategory) {
		if (categoryService.iscategorypresent(foodCategory.getCategoryId())) {
			categoryService.deleteCategory(foodCategory.getCategoryId());

			return new ResponseEntity(new Status("Deleted Succesfully... "), HttpStatus.OK);
		} else {
			Status status = new Status("Category Not Availabale");

			return new ResponseEntity(new Status("This Category Id Is not available, Unable to delete... "),
					HttpStatus.CONFLICT);

		}
	}

}
