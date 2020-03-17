package com.example.demo.hotel.food.item.service;

import java.util.List;

import com.example.demo.hotel.food.item.bean.FoodItemBean;

// TODO: Auto-generated Javadoc
/**
 * The Interface FoodItemService.
 */
public interface FoodItemService {

	/**
	 * Gets the all items.
	 *
	 * @return the all items
	 */
	public List<FoodItemBean> getAllItems();

	/**
	 * Creates the item.
	 *
	 * @param foodItemBean the food item bean
	 * @return the food item bean
	 */
	// public List<FoodItemBean> getAllItems();
	public FoodItemBean createItem(FoodItemBean foodItemBean);

	/**
	 * Checks if is item present.
	 *
	 * @param itemName the item name
	 * @return true, if is item present
	 */
	public boolean isItemPresent(String itemName);

	/**
	 * Delete item.
	 *
	 * @param itemName the item name
	 */
	public void deleteItem(String itemName);

	/**
	 * Update item.
	 *
	 * @param foodItemBean the food item bean
	 * @return the food item bean
	 */
	public FoodItemBean updateItem(FoodItemBean foodItemBean);

	/**
	 * Checks if is item id present.
	 *
	 * @param itemId the item id
	 * @return true, if is item id present
	 */
	public boolean isItemIdPresent(Long itemId);

}
