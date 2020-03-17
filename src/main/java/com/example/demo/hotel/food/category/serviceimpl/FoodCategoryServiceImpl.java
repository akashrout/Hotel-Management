package com.example.demo.hotel.food.category.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;
import com.example.demo.hotel.food.category.repo.FoodCategoryRepository;
import com.example.demo.hotel.food.category.requesttransformer.CategoryRequestTransformer;
import com.example.demo.hotel.food.category.responsetransformer.CategoryRespnseTransformer;
import com.example.demo.hotel.food.category.service.FoodCategoryService;
import com.example.demo.hotel.food.category.validations.CategoryValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodCategoryServiceImpl.
 */
@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {
	
	private static final Logger log = LoggerFactory.getLogger(FoodCategoryServiceImpl.class);
	
	/** The categoryrepository. */
	@Autowired
	private FoodCategoryRepository categoryrepository;

	/**
	 * Creates the category.
	 *
	 * @param foodCategory the food category
	 * @return the food category bean
	 */
	@Override
	public FoodCategoryBean createCategory(FoodCategoryBean foodCategory) {
		log.info("Entering Create Category...");
		log.debug("Entering Create category...");
		FoodCategoryEntity foodCategoryEntity = CategoryRequestTransformer.getFoodCategoryEntity(foodCategory);
		categoryrepository.save(foodCategoryEntity);
		FoodCategoryBean foodCategoryBean = CategoryRespnseTransformer.getFoodCategoryBean(foodCategoryEntity);
		return foodCategoryBean;
	}

	/**
	 * Update category.
	 *
	 * @param foodCategory the food category
	 * @return the food category bean
	 */
	public FoodCategoryBean updateCategory(FoodCategoryBean foodCategory) {
		
		FoodCategoryEntity foodCategoryEntity =categoryrepository.getOne(foodCategory.getCategoryId());
		if(null!=foodCategoryEntity)
		{
		 foodCategoryEntity = CategoryRequestTransformer.getRequestTransformerFoodCategoryUpdate(foodCategory);
		}
		categoryrepository.save(foodCategoryEntity);
		FoodCategoryBean foodCategoryBean = CategoryRespnseTransformer.getFoodCategoryBean(foodCategoryEntity);
		return foodCategoryBean;
	}


	/**
	 * Delete category.
	 *
	 * @param Category_id the category id
	 */
	@Override
	public void deleteCategory(Long Category_id) {
		// TODO Auto-generated method stub
		categoryrepository.deleteById(Category_id);
		
	}

	/**
	 * Gets the all category.
	 *
	 * @return the all category
	 */
	@Override
	public List<FoodCategoryBean> getAllCategory() {
		
		List<FoodCategoryEntity> categoryEntities = categoryrepository.findAll();
		List<FoodCategoryBean> categoryBeans = CategoryRequestTransformer.getFoodBeanBeanList(categoryEntities);
		
		
		
		
		return  categoryBeans;
		//return null;
	}



	/**
	 * Checks if is categorypresent.
	 *
	 * @param categoryid the categoryid
	 * @return true, if is categorypresent
	 */
	public boolean iscategorypresent(Long categoryid) {
		// TODO Auto-generated method stub
		return categoryrepository.findById(categoryid).isPresent();
	}



	/**
	 * Checks if is category name present.
	 *
	 * @param categoryName the category name
	 * @return true, if is category name present
	 */
	@Override
	public boolean isCategoryNamePresent(String categoryName) {
		// TODO Auto-generated method stub
		return categoryrepository.existsByCategoryName(categoryName);
	}

}
