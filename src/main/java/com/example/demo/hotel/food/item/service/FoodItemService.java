package com.example.demo.hotel.food.item.service;

import java.util.List;

import com.example.demo.hotel.food.item.bean.FoodItemBean;

public interface FoodItemService {
	
	public List<FoodItemBean> getAllItems();
	
	//public List<FoodItemBean> getAllItems();
	public FoodItemBean createItem(FoodItemBean foodItemBean);
	public boolean isItemPresent(String itemName);
	public void deleteItem(String itemName);
	public FoodItemBean updateItem(FoodItemBean foodItemBean);
	

}
