package com.example.demo.hotel.food.item.validations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.item.bean.FoodItemBean;
import com.example.demo.hotel.food.item.requesttransformer.ItemrequestTransformer;
import com.example.demo.hotel.food.item.service.FoodItemService;

@Service
public class ItemValidator {
	private static final Logger log = LoggerFactory.getLogger(ItemValidator.class);
	@Autowired
	private FoodItemService foodItemService;

	public boolean iSAllItemFieldPresent(FoodItemBean foodItemBean) {
		log.info("Checking all required fields are there or not...");
		log.debug("Checking all required fields are there or not...");
		if ((foodItemBean.getItemName() == null) || (foodItemBean.getItemPrice() == null)
				|| (foodItemBean.getItemIngredients() == null)) {
			log.info("All required fields are not present...");
			log.debug("All required fields are not present...");
			return false;

		} else {
			log.info("All required fields are present...");
			log.debug("All required fields are present...");

			return true;

		}
	}

	public boolean isItemPresent(String itemName) {
		log.info("Checking if item name is present...");
		log.debug("Checking if item name is present...");
		return foodItemService.isItemPresent(itemName);
	}

	public boolean isItemIdPresent(Long itemId) {
		log.info("Checking if item id is present...");
		log.debug("Checking if item id is present...");
		return foodItemService.isItemIdPresent(itemId);
	}

}
