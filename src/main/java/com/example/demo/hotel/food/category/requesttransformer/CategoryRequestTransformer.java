package com.example.demo.hotel.food.category.requesttransformer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;
import com.example.demo.hotel.food.category.repo.FoodCategoryRepository;
import com.example.demo.hotel.food.category.serviceimpl.FoodCategoryServiceImpl;

public class CategoryRequestTransformer {

	private static final Logger log = LoggerFactory.getLogger(CategoryRequestTransformer.class);
//	@Autowired
//	static FoodCategoryRepository categoryRepository;

	public static FoodCategoryEntity getFoodCategoryEntity(FoodCategoryBean foodCategory) {
		log.info("Convert FoodCategiryBean to FoodCategoryEntity...");
		log.debug("Convert FoodCategiryBean to FoodCategoryEntity...");
		FoodCategoryEntity foodCategoryEntity = new FoodCategoryEntity(foodCategory.getCategoryName(),
				foodCategory.getCategoryDescription());
		log.info("Returns the FoodCategoryEntity...");
		log.debug("Returns the FoodCategoryEntity...");
		return foodCategoryEntity;

	}

	public static FoodCategoryEntity getRequestTransformerFoodCategoryUpdate(FoodCategoryBean foodCategory) {
		FoodCategoryEntity foodCategoryEntity = new FoodCategoryEntity(foodCategory.getCategoryId(),
				foodCategory.getCategoryName(), foodCategory.getCategoryDescription());
		return foodCategoryEntity;
	}

	public static List<FoodCategoryBean> getFoodBeanBeanList(List<FoodCategoryEntity> listOfCategoryEntities) {
		List<FoodCategoryBean> categoryBeans = new ArrayList<FoodCategoryBean>();
		for (FoodCategoryEntity categoryEntity : listOfCategoryEntities) {
			categoryBeans.add(new FoodCategoryBean(categoryEntity.getCategoryId(), categoryEntity.getCategoryName(),
					categoryEntity.getCategoryDescription()));

		}

		return categoryBeans;
	}

//	public static List<FoodCategoryEntity> getAllCategoryEntity() {
//		// TODO Auto-generated method stub
//		return categoryRepository.findAll();
//	}

}
