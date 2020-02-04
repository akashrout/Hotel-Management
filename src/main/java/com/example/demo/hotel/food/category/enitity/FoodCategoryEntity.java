package com.example.demo.hotel.food.category.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodCategory.
 */
@Entity
@Table(name="Food_Category")
public class FoodCategoryEntity {

	/** The category id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "category_id")
	private Long categoryId;
	
	/** The category name. */
	private String categoryName;
	
	/** The category description. */
	private String categoryDescription;

	/**
	 * Instantiates a new food category.
	 */
	public FoodCategoryEntity() {
	}

	public FoodCategoryEntity( String categoryName, String categoryDescription) {
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public FoodCategoryEntity(Long categoryId, String categoryName, String categoryDescription) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	
	
}
