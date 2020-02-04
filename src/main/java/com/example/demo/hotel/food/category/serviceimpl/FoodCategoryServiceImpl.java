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

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {
	@Autowired
	private FoodCategoryRepository categoryrepository;

	@Override
	public FoodCategoryBean createCategory(FoodCategoryBean foodCategory) {
		FoodCategoryEntity foodCategoryEntity = CategoryRequestTransformer.getFoodCategoryEntity(foodCategory);
		categoryrepository.save(foodCategoryEntity);
		FoodCategoryBean foodCategoryBean = CategoryRespnseTransformer.getFoodCategoryBean(foodCategoryEntity);
		return foodCategoryBean;
	}

	

	@Override
	public void deleteCategory(Long Category_id) {
		// TODO Auto-generated method stub
		categoryrepository.deleteById(Category_id);
		
	}

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



	public boolean iscategorypresent(Long categoryid) {
		// TODO Auto-generated method stub
		return categoryrepository.findById(categoryid).isPresent();
	}

}
