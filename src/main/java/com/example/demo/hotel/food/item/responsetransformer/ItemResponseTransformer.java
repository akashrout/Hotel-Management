package com.example.demo.hotel.food.item.responsetransformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.hotel.food.item.bean.FoodItemBean;
import com.example.demo.hotel.food.item.entity.FoodItemEntity;
import com.example.demo.hotel.food.item.serviceimpl.FoodItemServiceImpl;

public class ItemResponseTransformer {
	private static final Logger log = LoggerFactory.getLogger(ItemResponseTransformer.class);

	public static FoodItemBean getFoodItemBean(FoodItemEntity foodItemEntity) {
		log.info(" Converting itemEntity to itemBeam...");
		log.debug("Converting itemEntity to itemBeam...");
		log.info("Returning itemBean to Service...");
		log.debug("Returning itemBean to Service...");
		return new FoodItemBean(foodItemEntity.getItemId(), foodItemEntity.getItemName(), foodItemEntity.getItemPrice(),
				foodItemEntity.getItemIngredients());
	}

}
