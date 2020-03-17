package com.example.demo.hotel.food.category.enitity;

import java.io.Serializable;

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
@Table(name = "Food_Category")
public class FoodCategoryEntity implements Serializable {

	/** The category id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private Long categoryId;

	/** The category name. */
	@Column(unique = true)
	private String categoryName;

	/** The category description. */
	private String categoryDescription;

	/**
	 * Instantiates a new food category.
	 */
	public FoodCategoryEntity() {
	}

	/**
	 * Instantiates a new food category entity.
	 *
	 * @param categoryName        the category name
	 * @param categoryDescription the category description
	 */
	public FoodCategoryEntity(String categoryName, String categoryDescription) {
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	/**
	 * Instantiates a new food category entity.
	 *
	 * @param categoryId          the category id
	 * @param categoryName        the category name
	 * @param categoryDescription the category description
	 */
	public FoodCategoryEntity(Long categoryId, String categoryName, String categoryDescription) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	/**
	 * Gets the category id.
	 *
	 * @return the category id
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * Sets the category id.
	 *
	 * @param categoryId the new category id
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	// @NotNull(message="Email Address is compulsory")
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Gets the category description.
	 *
	 * @return the category description
	 */
	public String getCategoryDescription() {
		return categoryDescription;
	}

	/**
	 * Sets the category description.
	 *
	 * @param categoryDescription the new category description
	 */
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodCategoryEntity other = (FoodCategoryEntity) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		return true;
	}

}
