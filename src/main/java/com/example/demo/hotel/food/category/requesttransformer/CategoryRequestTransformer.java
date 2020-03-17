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

/**
 * The Class CategoryRequestTransformer.
 */
public class CategoryRequestTransformer {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(CategoryRequestTransformer.class);
//	@Autowired
//	static FoodCategoryRepository categoryRepository;

	/**
	 * Gets the food category entity.
	 *
	 * @param foodCategory the food category
	 * @return the food category entity
	 */
	public static FoodCategoryEntity getFoodCategoryEntity(FoodCategoryBean foodCategory) {
		log.info("Convert FoodCategiryBean to FoodCategoryEntity for create...");
		log.debug("Convert FoodCategiryBean to FoodCategoryEntity for create...");
		FoodCategoryEntity foodCategoryEntity = new FoodCategoryEntity(foodCategory.getCategoryName(),
				foodCategory.getCategoryDescription());
		log.info("Returns the FoodCategoryEntity...");
		log.debug("Returns the FoodCategoryEntity...");
		return foodCategoryEntity;

	}

	/**
	 * Gets the request transformer food category update.
	 *
	 * @param foodCategory the food category
	 * @return the request transformer food category update
	 */
	public static FoodCategoryEntity getRequestTransformerFoodCategoryUpdate(FoodCategoryBean foodCategory) {
		log.info("Convert FoodCategiryBean to FoodCategoryEntity for update...");
		log.debug("Convert FoodCategiryBean to FoodCategoryEntity for update...");
		FoodCategoryEntity foodCategoryEntity = new FoodCategoryEntity(foodCategory.getCategoryId(),
				foodCategory.getCategoryName(), foodCategory.getCategoryDescription());
		log.info("Returns the FoodCategoryEntity...");
		log.debug("Returns the FoodCategoryEntity...");
		return foodCategoryEntity;
	}

	/**
	 * Gets the food bean bean list.
	 *
	 * @param listOfCategoryEntities the list of category entities
	 * @return the food bean bean list
	 */
	public static List<FoodCategoryBean> getFoodBeanBeanList(List<FoodCategoryEntity> listOfCategoryEntities) {
		log.info("Getting all the category lists...");
		log.debug("Getting all the category lists...");
		List<FoodCategoryBean> categoryBeans = new ArrayList<FoodCategoryBean>();
		log.info("Adding all category lists to bean...");
		log.debug("Adding all category lists to bean...");
		for (FoodCategoryEntity categoryEntity : listOfCategoryEntities) {
			categoryBeans.add(new FoodCategoryBean(categoryEntity.getCategoryId(), categoryEntity.getCategoryName(),
					categoryEntity.getCategoryDescription()));

		}
		log.info("Returning all category lists as a bean...");
		log.debug("Returning all category lists as a bean...");
		return categoryBeans;
	}

}
