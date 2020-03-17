package com.example.demo.hotel.food.item.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.hotel.food.item.entity.FoodItemEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface FoodItemRepository.
 */
public interface FoodItemRepository extends JpaRepository<FoodItemEntity, Long> {

	/**
	 * Exists by item name.
	 *
	 * @param itemName the item name
	 * @return true, if successful
	 */
	public boolean existsByItemName(String itemName);

	/**
	 * Delete by item name.
	 *
	 * @param itemName the item name
	 */
	// @Query("delete from FoodItemEntity where ItemName = ?1")
	@Transactional
	void deleteByItemName(String itemName);

}
