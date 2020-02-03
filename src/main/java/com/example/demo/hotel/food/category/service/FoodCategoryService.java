package com.example.demo.hotel.food.category.service;

import java.util.List;

import com.example.demo.hotel.food.category.pojo.FoodCategory;

public interface FoodCategoryService {
	public void createCategory(FoodCategory foodCategory);
	public boolean iscategorypresent(String categoryid);
	public void deleteCategory(String Category_id);
	public List<FoodCategory> getAllCategory();

}
