package com.example.demo.hotel.food.category.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.service.FoodCategoryService;

@Service
public class CategoryValidator {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryValidator.class);
	
	@Autowired
	private FoodCategoryService categoryService;

	public boolean validateCategoryForEmptyData(FoodCategoryBean foodCategory) {
		System.out.println("Inside validateCategoryForEmptyData: " + foodCategory);
		log.info("Inside validateCategoryForEmptyData....");
		if ((foodCategory.getCategoryName() == null) || (foodCategory.getCategoryDescription() == null)) {
			log.info("validateCategoryForEmptyData returns Empty...");
			log.debug("validateCategoryForEmptyData returns Empty...");
			return false;
		} else {
			return true;
		}

	}

	public boolean isCategoryNamePresent(String foodCategoryname) {
		System.out.println("Inside isCategoryNamePresent: " + foodCategoryname);
		log.info("Inside isCategoryNamePresent............");

		if (categoryService.isCategoryNamePresent(foodCategoryname)) {
			System.out.println("Category Name is already available, Please add another one....");
			log.info("Logger Category Name is already available, Please add another one....");
			return true;

		} else {
			return false;

		}

	}

	public boolean isIdPresent(Long categoryId) {
		// TODO Auto-generated method stub
		return categoryService.iscategorypresent(categoryId);
	}

	
}
