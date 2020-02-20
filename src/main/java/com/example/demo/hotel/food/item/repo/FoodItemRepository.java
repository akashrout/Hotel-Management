package com.example.demo.hotel.food.item.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.hotel.food.item.entity.FoodItemEntity;

public interface FoodItemRepository extends JpaRepository<FoodItemEntity, Long> {
	
	public boolean existsByItemName(String itemName);
	//@Query("delete from FoodItemEntity  where ItemName = ?1")
	@Transactional
	void deleteByItemName(String itemName);

}
