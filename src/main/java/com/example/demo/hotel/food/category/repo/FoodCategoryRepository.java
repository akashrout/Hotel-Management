package com.example.demo.hotel.food.category.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface FoodCategoryRepository.
 */
public interface FoodCategoryRepository extends JpaRepository<FoodCategoryEntity, Long> {

	/**
	 * Exists by category name.
	 *
	 * @param categoryName the category name
	 * @return true, if successful
	 */
	public boolean existsByCategoryName(String categoryName);

}
