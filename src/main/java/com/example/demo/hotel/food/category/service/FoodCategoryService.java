package com.example.demo.hotel.food.category.service;

import java.util.List;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;

public interface FoodCategoryService {
	
	/**
	 * Creates the category.
	 *
	 * @param foodCategory the food category
	 * @return the food category bean
	 */
	public FoodCategoryBean createCategory(FoodCategoryBean foodCategory);
	
	/**
	 * Checks if is categorypresent.
	 *
	 * @param long1 the categoryid
	 * @return true, if is categorypresent
	 */
	public boolean iscategorypresent(Long categoryId);
	
	/**
	 * Delete category.
	 *
	 * @param categoryId the category id
	 */
	public void deleteCategory(Long categoryId);
	
	/**
	 * Gets the all category.
	 *
	 * @return the all category
	 */
	public List<FoodCategoryEntity> getAllCategory();

}
