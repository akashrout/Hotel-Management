package com.example.demo.hotel.food.item.requesttransformer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.hotel.food.item.bean.FoodItemBean;
import com.example.demo.hotel.food.item.entity.FoodItemEntity;
import com.example.demo.hotel.food.item.serviceimpl.FoodItemServiceImpl;

public class ItemrequestTransformer {
	private static final Logger log = LoggerFactory.getLogger(ItemrequestTransformer.class);

	public static FoodItemEntity getFoodItemEntity(FoodItemBean foodItemBean) {
		log.info(" Converting itemBean to itemEntity...");
		log.debug("Converting itemBean to itemEntity...");
		FoodItemEntity foodItemEntity = new FoodItemEntity(foodItemBean.getItemName(), foodItemBean.getItemPrice(),
				foodItemBean.getItemIngredients());
		log.info("Returning itemEntity to Service...");
		log.debug("Returning itemEntity to Service...");
		return foodItemEntity;
	}

	public static List<FoodItemBean> getFoodItemBeanList(List<FoodItemEntity> listOfItemEntity) {
		log.info(" Converting listOfitemEntity to itemBean...");
		log.debug("Converting listOfitemEntity to itemBean...");
		List<FoodItemBean> listOfbean = new ArrayList<>();
		log.info("Adding  itemEntity to itemBean...");
		log.debug("Adding itemEntity to itemBean...");
		for (FoodItemEntity foodItemEntity : listOfItemEntity) {

			listOfbean.add(new FoodItemBean(foodItemEntity.getItemId(), foodItemEntity.getItemName(),
					foodItemEntity.getItemPrice(), foodItemEntity.getItemIngredients()));
		}
		log.info("Returning itemBean to Service...");
		log.debug("Returning itemBean to Service...");
		return listOfbean;
	}

}
