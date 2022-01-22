package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewsModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	
	@Override
	public List<CategoryModel> findAll() {
		String sql ="select * from category";
		return query(sql, new CategoryMapper());
	}

    @Override
    public CategoryModel findOne(long id) {
		String sql ="select * from category where id = ?";
		List<CategoryModel> category = query(sql,new CategoryMapper(), id);
		return category.isEmpty() ? null : category.get(0);
    }

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql ="select * from category where code = ?";
		List<CategoryModel> category = query(sql,new CategoryMapper(), code);
		return category.isEmpty() ? null : category.get(0);
	}

//    @Override
//    public CategoryModel findOneByCode(String code) {
//		String sql ="select * from category where code = ?";
//		List<CategoryModel> category = query(sql,new CategoryMapper(), code);
//		return category.isEmpty() ? null : category.get(0);
//    }

}
