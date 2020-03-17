package com.example.demo.hotel.food.category.responsetransformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;
import com.example.demo.hotel.food.category.serviceimpl.FoodCategoryServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CategoryRespnseTransformer.
 */
public class CategoryRespnseTransformer {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(CategoryRespnseTransformer.class);

	/**
	 * Gets the food category bean.
	 *
	 * @param foodCategoryEntity the food category entity
	 * @return the food category bean
	 */
	public static FoodCategoryBean getFoodCategoryBean(FoodCategoryEntity foodCategoryEntity) {
		log.info("Convering CategoryEntity to CategoryBean...");
		log.debug("Convering CategoryEntity to CategoryBean...");
		return new FoodCategoryBean(foodCategoryEntity.getCategoryId(), foodCategoryEntity.getCategoryName(),
				foodCategoryEntity.getCategoryDescription());
	}

}
