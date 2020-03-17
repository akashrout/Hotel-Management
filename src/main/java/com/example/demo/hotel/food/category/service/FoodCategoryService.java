/*
 * 
 */
package com.example.demo.hotel.food.category.service;

import java.util.List;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface FoodCategoryService.
 */
public interface FoodCategoryService {

	/**
	 * Creates the category.
	 *
	 * @param foodCategory the food category
	 * @return the food category bean
	 */
	public FoodCategoryBean createCategory(FoodCategoryBean foodCategory);

	public FoodCategoryBean updateCategory(FoodCategoryBean foodCategory);

	/**
	 * Checks if is categorypresent.
	 *
	 * @param categoryId the category id
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
	public List<FoodCategoryBean> getAllCategory();

	/**
	 * Checks if is category name present.
	 *
	 * @param categoryName the category name
	 * @return true, if is category name present
	 */
	public boolean isCategoryNamePresent(String categoryName);

}
