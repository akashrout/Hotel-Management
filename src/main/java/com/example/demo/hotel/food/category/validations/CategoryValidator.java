package com.example.demo.hotel.food.category.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.service.FoodCategoryService;

/**
 * The Class CategoryValidator.
 */
@Service
public class CategoryValidator {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(CategoryValidator.class);

	/** The category service. */
	@Autowired
	private FoodCategoryService categoryService;

	/**
	 * Validate category for empty data.
	 *
	 * @param foodCategory the food category
	 * @return true, if successful
	 */
	public boolean validateCategoryForEmptyData(FoodCategoryBean foodCategory) {
		System.out.println("Inside validateCategoryForEmptyData: " + foodCategory);
		log.info("Inside validateCategoryForEmptyData....");
		if ((foodCategory.getCategoryName() == null) || (foodCategory.getCategoryDescription() == null)) {
			log.info("validateCategoryForEmptyData returns Empty data...");
			log.debug("validateCategoryForEmptyData returns Empty data...");
			return false;
		} else {
			log.info("All fields are present...");
			log.debug("All fields are present...");
			return true;
		}

	}

	/**
	 * Checks if is category name present.
	 *
	 * @param foodCategoryname the food categoryname
	 * @return true, if is category name present
	 */
	public boolean isCategoryNamePresent(String foodCategoryname) {
		System.out.println("Inside isCategoryNamePresent: " + foodCategoryname);
		log.info("Inside isCategoryNamePresent............");

		if (categoryService.isCategoryNamePresent(foodCategoryname)) {
			// System.out.println("Category Name is already available, Please add another
			// one....");
			log.info(" Category Name is already available, Please add another one....");
			log.debug(" Category Name is already available, Please add another one....");
			return true;

		} else {
			log.info(" Category Name is not  available...");
			log.debug(" Category Name is not available....");
			return false;

		}

	}

	/**
	 * Checks if is id present.
	 *
	 * @param categoryId the category id
	 * @return true, if is id present
	 */
	public boolean isIdPresent(Long categoryId) {
		// TODO Auto-generated method stub
		log.info("Checking if catefory is present...");
		log.debug("Checking if catefory is present....");
		return categoryService.iscategorypresent(categoryId);
	}

}
