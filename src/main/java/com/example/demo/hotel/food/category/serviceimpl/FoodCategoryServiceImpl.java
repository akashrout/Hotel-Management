package com.example.demo.hotel.food.category.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.food.category.pojo.FoodCategory;
import com.example.demo.hotel.food.category.repo.FoodCategoryRepository;
import com.example.demo.hotel.food.category.service.FoodCategoryService;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {
	@Autowired
	private FoodCategoryRepository categoryrepository;

	@Override
	public void createCategory(FoodCategory foodCategory) {
		// TODO Auto-generated method stub
		categoryrepository.save(foodCategory);

	}

	@Override
	public boolean iscategorypresent(String categoryid) {
		// TODO Auto-generated method stub
		return categoryrepository.findById(categoryid).isPresent();
	}

	@Override
	public void deleteCategory(String Category_id) {
		// TODO Auto-generated method stub
		categoryrepository.deleteById(Category_id);
		
	}

	@Override
	public List<FoodCategory> getAllCategory() {
		// TODO Auto-generated method stub
		List<FoodCategory> list = new ArrayList<FoodCategory>();
		list.add(new FoodCategory());
		ListIterator<FoodCategory> itr = list.listIterator();
//		while (itr.hasNext()) {
//			FoodCategory foodCategory = (FoodCategory) itr.next();
//			System.out.println(foodCategory);
//			
//		}
		
		return categoryrepository.findAll();
	}

}
