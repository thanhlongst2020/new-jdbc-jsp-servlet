package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;

public interface INewsDAO extends GenericDAO<NewsModel> {
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(Long categoryid);
	Long save(NewsModel newModel);
	void update(NewsModel updateNew);
	void delete(long id);
	List<NewsModel> findAll(Integer offset, Integer limit);
	int getTotaItem();
	
}
