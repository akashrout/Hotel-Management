package com.example.demo.hotel.food.category.responsetransformer;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;

public class CategoryRespnseTransformer {

	public static FoodCategoryBean getFoodCategoryBean(FoodCategoryEntity foodCategoryEntity) {
		 
		return new FoodCategoryBean(foodCategoryEntity.getCategoryId(),foodCategoryEntity.getCategoryName(),foodCategoryEntity.getCategoryDescription());
	}

}
