package com.example.demo.hotel.food.item.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;
import com.example.demo.hotel.food.category.responsetransformer.CategoryRespnseTransformer;
import com.example.demo.hotel.food.category.service.FoodCategoryService;
import com.example.demo.hotel.food.item.bean.FoodItemBean;
import com.example.demo.hotel.food.item.entity.FoodItemEntity;
import com.example.demo.hotel.food.item.repo.FoodItemRepository;
import com.example.demo.hotel.food.item.requesttransformer.ItemrequestTransformer;
import com.example.demo.hotel.food.item.responsetransformer.ItemResponseTransformer;
import com.example.demo.hotel.food.item.service.FoodItemService;

/**
 * The Class FoodItemServiceImpl.
 */
@Service
public class FoodItemServiceImpl implements FoodItemService {
	private static final Logger log = LoggerFactory.getLogger(FoodItemServiceImpl.class);

	/** The food item repository. */
	@Autowired
	private FoodItemRepository foodItemRepository;

	/**
	 * Gets the all items.
	 *
	 * @return the all items
	 */
	@Override
	public List<FoodItemBean> getAllItems() {
		log.info("Inside getAll Item...");
		log.debug("Inside getAll Item...");
		List<FoodItemEntity> listOfItemEntity = foodItemRepository.findAll();
		log.info(" getAll Item...");
		log.debug(" getAll Item...");
		List<FoodItemBean> listOfBean = ItemrequestTransformer.getFoodItemBeanList(listOfItemEntity);
		log.info("Returning itemBean to Controller...");
		log.debug("Returning itemBean to Controller...");
		return listOfBean;
	}

	/**
	 * Creates the item.
	 *
	 * @param foodItemBean the food item bean
	 * @return the food item bean
	 */
	@Override
	public FoodItemBean createItem(FoodItemBean foodItemBean) {
		log.info("Entering CreateItem...");
		log.debug("Entering CreateItem...");
		FoodItemEntity foodItemEntity = ItemrequestTransformer.getFoodItemEntity(foodItemBean);
		log.info("Inserting new item to the DB...");
		log.debug("Inserting new item to the DB...");
		foodItemRepository.save(foodItemEntity);
		FoodItemBean itemBean = ItemResponseTransformer.getFoodItemBean(foodItemEntity);
		log.info("Returning newly created itemBean to Controller...");
		log.debug("Returning newly created itemBean to Controller...");
		return itemBean;
	}

	/**
	 * Checks if is item present.
	 *
	 * @param itemName the item name
	 * @return true, if is item present
	 */
	@Override
	public boolean isItemPresent(String itemName) {
		log.info("Checking if item name is present...");
		log.debug("Checking if item name is present...");
		return foodItemRepository.existsByItemName(itemName);
	}

	/**
	 * Delete item.
	 *
	 * @param itemName the item name
	 */
	@Override
	public void deleteItem(String itemName) {
		log.info("Deleting the Item...");
		log.debug("Deleting the Item...");
		foodItemRepository.deleteByItemName(itemName);

	}

	/**
	 * Update item.
	 *
	 * @param foodItemBean the food item bean
	 */
	@Override
	public FoodItemBean updateItem(FoodItemBean foodItemBean) {
		log.info(" Inside UpdateItem...");
		log.debug(" Inside UpdateItem...");
		FoodItemEntity foodItemEntity = foodItemRepository.findById(foodItemBean.getItemId()).get();
		if (foodItemEntity != null) {
			log.info("Adding all details of the existing item for update...");
			log.debug("Adding all details of the existing item for update...");
			foodItemEntity.setItemName(foodItemBean.getItemName());
			foodItemEntity.setItemPrice(foodItemBean.getItemPrice());
			foodItemEntity.setItemIngredients(foodItemBean.getItemIngredients());
		}
		log.info("Updating the item to the DB...");
		log.debug("Updating the item to the DB...");
		foodItemRepository.save(foodItemEntity);
		FoodItemBean itemBean = ItemResponseTransformer.getFoodItemBean(foodItemEntity);
		log.info("Returning updated itemBean to Controller...");
		log.debug("Returning updated itemBean to Controller...");
		return itemBean;
	}

	/**
	 * Checks if is item id present.
	 *
	 * @param itemId the item id
	 * @return true, if is item id present
	 */
	@Override
	public boolean isItemIdPresent(Long itemId) {
		log.info("Checking if item id is present...");
		log.debug("Checking if item id is present...");
		return foodItemRepository.findById(itemId).isPresent();
	}

}
