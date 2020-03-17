package com.example.demo.hotel.food.item.bean;

import java.io.Serializable;

/**
 * The Class FoodItemBean.
 */
public class FoodItemBean {

	/** The item id. */
	private long itemId;

	/** The item name. */
	private String itemName;

	/** The item price. */
	private Long itemPrice;

	/** The item ingredients. */
	private String itemIngredients;

	/**
	 * Instantiates a new food item bean.
	 */
	public FoodItemBean() {
	}

	/**
	 * Instantiates a new food item bean.
	 *
	 * @param itemName        the item name
	 * @param itemPrice       the item price
	 * @param itemIngredients the item ingredients
	 */
	public FoodItemBean(String itemName, Long itemPrice, String itemIngredients) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemIngredients = itemIngredients;
	}

	/**
	 * Instantiates a new food item bean.
	 *
	 * @param itemId          the item id
	 * @param itemName        the item name
	 * @param itemPrice       the item price
	 * @param itemIngredients the item ingredients
	 */
	public FoodItemBean(Long itemId, String itemName, Long itemPrice, String itemIngredients) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemIngredients = itemIngredients;
	}

	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the item price.
	 *
	 * @return the item price
	 */
	public Long getItemPrice() {
		return itemPrice;
	}

	/**
	 * Sets the item price.
	 *
	 * @param itemPrice the new item price
	 */
	public void setItemPrice(Long itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * Gets the item ingredients.
	 *
	 * @return the item ingredients
	 */
	public String getItemIngredients() {
		return itemIngredients;
	}

	/**
	 * Sets the item ingredients.
	 *
	 * @param itemIngredients the new item ingredients
	 */
	public void setItemIngredients(String itemIngredients) {
		this.itemIngredients = itemIngredients;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "FoodItemBean [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemIngredients=" + itemIngredients + "]";
	}

}
