package com.example.demo.hotel.food.item.responsetransformer;

import com.example.demo.hotel.food.item.bean.FoodItemBean;
import com.example.demo.hotel.food.item.entity.FoodItemEntity;

public class ItemResponseTransformer {

	public static FoodItemBean getFoodItemBean(FoodItemEntity foodItemEntity) {
		// TODO Auto-generated method stub
		return new FoodItemBean(foodItemEntity.getItemId(), foodItemEntity.getItemName(), foodItemEntity.getItemPrice(), foodItemEntity.getItemIngredients());
	}

}
