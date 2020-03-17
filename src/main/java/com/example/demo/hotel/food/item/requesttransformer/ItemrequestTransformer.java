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
		log.info(" Converting itemBeam to itemEntity...");
		log.debug("Converting itemBeam to itemEntity...");
		FoodItemEntity foodItemEntity = new FoodItemEntity(foodItemBean.getItemName(), foodItemBean.getItemPrice(),
				foodItemBean.getItemIngredients());
		return foodItemEntity;
	}

	public static List<FoodItemBean> getFoodItemBeanList(List<FoodItemEntity> listOfItemEntity) {
		log.info(" Converting listOfitemEntity to itemBeam...");
		log.debug("Converting listOfitemEntity to itemBeam...");
		List<FoodItemBean> listOfbean = new ArrayList<>();
		log.info("Adding  itemEntity to itemBeam...");
		log.debug("Adding itemEntity to itemBeam...");
		for (FoodItemEntity foodItemEntity : listOfItemEntity) {

			listOfbean.add(new FoodItemBean(foodItemEntity.getItemId(), foodItemEntity.getItemName(),
					foodItemEntity.getItemPrice(), foodItemEntity.getItemIngredients()));
		}
		log.info("Returning itemBean to Service...");
		log.debug("Returning itemBean to Service...");
		return listOfbean;
	}

}
