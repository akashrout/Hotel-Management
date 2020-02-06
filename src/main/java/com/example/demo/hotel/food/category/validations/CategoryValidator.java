package com.example.demo.hotel.food.category.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.service.FoodCategoryService;

@Service
public class CategoryValidator {
	@Autowired
	private FoodCategoryService categoryService;

	public boolean validateCategoryForEmptyData(FoodCategoryBean foodCategory) {
		System.out.println("Inside validateCategoryForEmptyData: " + foodCategory);
		if ((foodCategory.getCategoryName() == null) || (foodCategory.getCategoryDescription() == null)) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isCategoryNamePresent(FoodCategoryBean foodCategory) {
		System.out.println("Inside isCategoryNamePresent: " + foodCategory);

		if (categoryService.isCategoryNamePresent(foodCategory.getCategoryName())) {
			System.out.println("Category Name is already available, Please add another one....");
			return true;

		} else {
			return false;

		}

	}
}
