package com.example.demo.hotel.food.category.requesttransformer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;
import com.example.demo.hotel.food.category.repo.FoodCategoryRepository;

public class CategoryRequestTransformer {
//	@Autowired
//	static FoodCategoryRepository categoryRepository;

	public static FoodCategoryEntity getFoodCategoryEntity(FoodCategoryBean foodCategory) {
		FoodCategoryEntity foodCategoryEntity= new FoodCategoryEntity(foodCategory.getCategoryName(),foodCategory.getCategoryDescription());
		return foodCategoryEntity;
		
	}

	public static FoodCategoryEntity getRequestTransformerFoodCategoryUpdate(FoodCategoryBean foodCategory) {
		FoodCategoryEntity foodCategoryEntity= new FoodCategoryEntity(foodCategory.getCategoryId(),foodCategory.getCategoryName(),foodCategory.getCategoryDescription());
		return foodCategoryEntity;
	}

//	public static List<FoodCategoryEntity> getAllCategoryEntity() {
//		// TODO Auto-generated method stub
//		return categoryRepository.findAll();
//	}

}
