package com.example.demo.hotel.food.item.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.item.bean.FoodItemBean;
import com.example.demo.hotel.food.item.service.FoodItemService;

@Service
public class ItemValidator {
	@Autowired
	private FoodItemService foodItemService;

	public boolean iSAllItemFieldPresent(FoodItemBean foodItemBean) {
		if ((foodItemBean.getItemName() == null) || (foodItemBean.getItemPrice() == null)
				|| (foodItemBean.getItemIngredients() == null)) {
			return false;

		} else {

			return true;

		}
	}

	public boolean isItemPresent(String itemName) {
		return foodItemService.isItemPresent(itemName);
	}

	public boolean isItemIdPresent(Long itemId) {
		// TODO Auto-generated method stub
		return foodItemService.isItemIdPresent(itemId);
	}

}
