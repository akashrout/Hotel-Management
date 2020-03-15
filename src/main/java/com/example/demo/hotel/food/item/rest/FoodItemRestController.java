package com.example.demo.hotel.food.item.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hotel.food.category.pojo.Status;
import com.example.demo.hotel.food.item.bean.FoodItemBean;
import com.example.demo.hotel.food.item.entity.FoodItemEntity;
import com.example.demo.hotel.food.item.service.FoodItemService;
import com.example.demo.hotel.food.item.validations.ItemValidator;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodItemRestController.
 */
@RestController
@RequestMapping("items")
public class FoodItemRestController {

	/** The food item service. */
	@Autowired
	private FoodItemService foodItemService;

	/** The item validator. */
	@Autowired
	private ItemValidator itemValidator;

	/**
	 * Gets the all items.
	 *
	 * @return the all items
	 */
	@GetMapping("getall")
	public ResponseEntity<List<FoodItemBean>> getAllItems() {
		List<FoodItemBean> foodItemBeans = foodItemService.getAllItems();
		if (foodItemBeans.isEmpty()) {
			return new ResponseEntity<List<FoodItemBean>>(foodItemBeans, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FoodItemBean>>(foodItemBeans, HttpStatus.OK);
	}

	/**
	 * Adds the item.
	 *
	 * @param foodItemBean the food item bean
	 * @return the response entity
	 */
	@PostMapping("create")
	public ResponseEntity<FoodItemBean> addItem(@RequestBody FoodItemBean foodItemBean) {

		System.out.println("Items Are: " + foodItemBean);
		if (itemValidator.iSAllItemFieldPresent(foodItemBean)) {
			if (itemValidator.isItemPresent(foodItemBean.getItemName())) {
				System.out.println("Item: " + foodItemBean.getItemName() + " is already present");
				return new ResponseEntity(new Status("This item is already present, Please add a new item"),
						HttpStatus.NOT_ACCEPTABLE);

			} else {
				FoodItemBean itemBean = foodItemService.createItem(foodItemBean);
				System.out.println(itemBean);
				return new ResponseEntity<FoodItemBean>(itemBean, HttpStatus.CREATED);

			}

		} else {
			return new ResponseEntity(new Status("Some Item Details are missing..."), HttpStatus.CONFLICT);

		}

	}

	/**
	 * Update item.
	 *
	 * @param foodItemBean the food item bean
	 * @return the response entity
	 */
	@PutMapping("/update")
	public ResponseEntity<FoodItemBean> updateItem(@RequestBody FoodItemBean foodItemBean) {
		System.out.println("Update Items: " + foodItemBean);

		if (itemValidator.iSAllItemFieldPresent(foodItemBean)) {

			if (itemValidator.isItemIdPresent(foodItemBean.getItemId())) {
				FoodItemBean itemBean = foodItemService.updateItem(foodItemBean);
				return new ResponseEntity<FoodItemBean>(itemBean, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity(new Status("Unable to update,Item is not present..."), HttpStatus.NOT_ACCEPTABLE);

			}

		}

		else {
			return new ResponseEntity(new Status("Unable to update, Some Item Details are missing..."),
					HttpStatus.CONFLICT);
		}
	}

	/**
	 * Delete item.
	 *
	 * @param foodItemBean the food item bean
	 * @return the response entity
	 */
	@DeleteMapping("delete")
	public ResponseEntity<FoodItemBean> deleteItem(@RequestBody FoodItemBean foodItemBean) {

		if (itemValidator.isItemPresent(foodItemBean.getItemName())) {
			foodItemService.deleteItem(foodItemBean.getItemName());
			return new ResponseEntity(new Status("Deleted Succesfully..."), HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity(new Status("The item is not available, Please enter a valid item for delete.."),
					HttpStatus.CONFLICT);
		}

	}

}
