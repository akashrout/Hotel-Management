package com.example.demo.hotel.food.item.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;
import com.example.demo.hotel.food.category.service.FoodCategoryService;
import com.example.demo.hotel.food.item.bean.FoodItemBean;
import com.example.demo.hotel.food.item.entity.FoodItemEntity;
import com.example.demo.hotel.food.item.repo.FoodItemRepository;
import com.example.demo.hotel.food.item.requesttransformer.ItemrequestTransformer;
import com.example.demo.hotel.food.item.responsetransformer.ItemResponseTransformer;
import com.example.demo.hotel.food.item.service.FoodItemService;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodItemServiceImpl.
 */
@Service
public class FoodItemServiceImpl implements FoodItemService {

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
		List<FoodItemEntity> listOfItemEntity = foodItemRepository.findAll();
		List<FoodItemBean> listOfBean = ItemrequestTransformer.getFoodItemBeanList(listOfItemEntity);
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
		FoodItemEntity foodItemEntity = ItemrequestTransformer.getFoodItemEntity(foodItemBean);
		foodItemRepository.save(foodItemEntity);
		FoodItemBean itemBean = ItemResponseTransformer.getFoodItemBeam(foodItemEntity);
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
		System.out.println("item for delete: " + itemName);
		return foodItemRepository.existsByItemName(itemName);
	}

	/**
	 * Delete item.
	 *
	 * @param itemName the item name
	 */
	@Override
	public void deleteItem(String itemName) {
		foodItemRepository.deleteByItemName(itemName);

	}

	/**
	 * Update item.
	 *
	 * @param foodItemBean the food item bean
	 */
	@Override
	public FoodItemBean updateItem(FoodItemBean foodItemBean) {
		// TODO Auto-generated method stub
		//first we get data using id
		//2nd we are doing the set data of bean into entity
		//3r saveing the entity to db
		FoodItemEntity foodItemEntity = foodItemRepository.findById(foodItemBean.getItemId()).get();
		if(foodItemEntity!=null)
		{
			foodItemEntity.setItemName(foodItemBean.getItemName());
			foodItemEntity.setItemPrice(foodItemBean.getItemPrice());
			foodItemEntity.setItemIngredients(foodItemBean.getItemIngredients());
		}
		foodItemRepository.save(foodItemEntity);
		FoodItemBean itemBean = ItemResponseTransformer.getFoodItemBeam(foodItemEntity);
		//it will have it also while returing the updated data
		return itemBean;
	}

}
