package com.example.demo.hotel.food.category.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;

public interface FoodCategoryRepository extends JpaRepository<FoodCategoryEntity, Long> {

}
