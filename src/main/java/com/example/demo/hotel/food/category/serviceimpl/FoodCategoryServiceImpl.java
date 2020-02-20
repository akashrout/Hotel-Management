package com.example.demo.hotel.food.category.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.category.bean.FoodCategoryBean;
import com.example.demo.hotel.food.category.enitity.FoodCategoryEntity;
import com.example.demo.hotel.food.category.repo.FoodCategoryRepository;
import com.example.demo.hotel.food.category.requesttransformer.CategoryRequestTransformer;
import com.example.demo.hotel.food.category.responsetransformer.CategoryRespnseTransformer;
import com.example.demo.hotel.food.category.service.FoodCategoryService;

// TODO: Auto-generated Javadoc
/**
 * The Class FoodCategoryServiceImpl.
 */
@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {
	
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
	public List<FoodCategoryEntity> getAllCategory() {
		// TODO Auto-generated method stub
//		List<FoodCategoryBean> list = new ArrayList<FoodCategoryBean>();
//		FoodCategoryEntity categoryEntity = (FoodCategoryEntity) CategoryRequestTransformer.getAllCategoryEntity();
		//list.add(new FoodCategory());
//		ListIterator<FoodCategory> itr = list.listIterator();
//		while (itr.hasNext()) {
//			FoodCategory foodCategory = (FoodCategory) itr.next();
//			System.out.println(foodCategory);
//			
//		}
		
		return  categoryrepository.findAll();
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
