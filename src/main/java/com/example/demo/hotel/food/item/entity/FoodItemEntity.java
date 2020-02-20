package com.example.demo.hotel.food.item.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodItemEntity.
 */
@Entity
@Table(name = "Food_Items")
public class FoodItemEntity implements Serializable {
	
	/** The item id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	
	/** The item name. */
	@Column(name = "item_name")
	private String itemName;
	
	/** The item price. */
	@Column(name = "price")
	private long itemPrice;
	
	/** The item ingredients. */
	@Column(name = "ingredients")
	private String itemIngredients;
	
	/**
	 * Instantiates a new food item entity.
	 */
	public FoodItemEntity() {
		super();
	}
	
	

	/**
	 * Instantiates a new food item entity.
	 *
	 * @param itemName the item name
	 * @param itemPrice the item price
	 * @param itemIngredients the item ingredients
	 */
	public FoodItemEntity(String itemName, long itemPrice, String itemIngredients) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemIngredients = itemIngredients;
	}



	/**
	 * Instantiates a new food item entity.
	 *
	 * @param itemId the item id
	 * @param itemName the item name
	 * @param itemPrice the item price
	 * @param itemIngredients the item ingredients
	 */
	public FoodItemEntity(long itemId, String itemName, long itemPrice, String itemIngredients) {
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
	public long getItemId() {
		return itemId;
	}

	/**
	 * Sets the item id.
	 *
	 * @param itemId the new item id
	 */
	public void setItemId(long itemId) {
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
	public long getItemPrice() {
		return itemPrice;
	}

	/**
	 * Sets the item price.
	 *
	 * @param itemPrice the new item price
	 */
	public void setItemPrice(long itemPrice) {
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
		return "FoodItemEntity [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemIngredients=" + itemIngredients + "]";
	}
	
	

}
