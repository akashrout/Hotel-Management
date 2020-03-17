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

/**
 * The Class FoodCategoryServiceImpl.
 */
@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {

	/** The Constant log. */
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
		log.info("Saving Category to DB...");
		log.debug("Saving category to DB...");
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
		log.info("Entering Update Category...");
		log.debug("Entering Update category...");

		FoodCategoryEntity foodCategoryEntity = categoryrepository.getOne(foodCategory.getCategoryId());
		if (null != foodCategoryEntity) {
			foodCategoryEntity = CategoryRequestTransformer.getRequestTransformerFoodCategoryUpdate(foodCategory);
		}
		log.info("Saving the Update Category...");
		log.debug("Saving the Update category...");
		categoryrepository.save(foodCategoryEntity);
		FoodCategoryBean foodCategoryBean = CategoryRespnseTransformer.getFoodCategoryBean(foodCategoryEntity);
		log.info("Returning  Updated Category...");
		log.debug("Returning Updated category...");
		return foodCategoryBean;
	}

	/**
	 * Delete category.
	 *
	 * @param Category_id the category id
	 */
	@Override
	public void deleteCategory(Long Category_id) {
		log.info("Deleting Category...");
		log.debug("Deleting category...");
		categoryrepository.deleteById(Category_id);

	}

	/**
	 * Gets the all category.
	 *
	 * @return the all category
	 */
	@Override
	public List<FoodCategoryBean> getAllCategory() {
		log.info("Inside Getting all Category...");
		log.debug("Inside getting all category...");
		List<FoodCategoryEntity> categoryEntities = categoryrepository.findAll();
		List<FoodCategoryBean> categoryBeans = CategoryRequestTransformer.getFoodBeanBeanList(categoryEntities);

		log.info("Returning all Category...");
		log.debug("Deleting category...");

		return categoryBeans;
	}

	/**
	 * Checks if is categorypresent.
	 *
	 * @param categoryid the categoryid
	 * @return true, if is categorypresent
	 */
	public boolean iscategorypresent(Long categoryid) {
		log.info("Checking if Category is already there or not...");
		log.debug("Checking if Category is already there or not...");
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
		log.info("Checking if Category name is already there or not...");
		log.debug("Checking if Category name is already there or not...");
		return categoryrepository.existsByCategoryName(categoryName);
	}

}
