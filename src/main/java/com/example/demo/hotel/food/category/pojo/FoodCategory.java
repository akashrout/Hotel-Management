package com.example.demo.hotel.food.category.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodCategory.
 */
@Entity
public class FoodCategory {

	/** The category id. */
	@Id
	private String category_id;
	
	/** The category name. */
	private String category_name;
	
	/** The category description. */
	private String category_description;

	/**
	 * Instantiates a new food category.
	 */
	public FoodCategory() {
		super();
	}

	public FoodCategory(String category_id, String category_name, String category_description) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.category_description = category_description;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getCategory_description() {
		return category_description;
	}

	public void setCategory_description(String category_description) {
		this.category_description = category_description;
	}

	@Override
	public String toString() {
		return "FoodCategory [category_id=" + category_id + ", category_name=" + category_name
				+ ", category_description=" + category_description + "]";
	}

	
}
