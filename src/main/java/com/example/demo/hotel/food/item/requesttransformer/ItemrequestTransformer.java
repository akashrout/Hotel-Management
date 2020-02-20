package com.example.demo.hotel.food.item.requesttransformer;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.hotel.food.item.bean.FoodItemBean;
import com.example.demo.hotel.food.item.entity.FoodItemEntity;

public class ItemrequestTransformer {

	public static FoodItemEntity getFoodItemEntity(FoodItemBean foodItemBean) {
		FoodItemEntity  foodItemEntity = new FoodItemEntity(foodItemBean.getItemName(), foodItemBean.getItemPrice(), foodItemBean.getItemIngredients());
		return foodItemEntity;
	}

	public static List<FoodItemBean> getFoodItemBeanList(List<FoodItemEntity> listOfItemEntity) {
		 
		List<FoodItemBean> listOfbean= new ArrayList<>();
		for(FoodItemEntity foodItemEntity:listOfItemEntity) {
			
			listOfbean.add(new FoodItemBean(foodItemEntity.getItemId(), foodItemEntity.getItemName(), foodItemEntity.getItemPrice(), foodItemEntity.getItemIngredients()));
		}
		
		return listOfbean;
	}

}
