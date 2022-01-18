package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewsDAO extends GenericDAO<NewsModel> {
	NewsModel findOne(Long id);
	List<NewsModel> findByCategoryId(Long categoryid);
	Long save(NewsModel newModel);
	void update(NewsModel updateNew);
	void delete(long id);
	List<NewsModel> findAll(Pageble pageble);
	int getTotaItem();
	
}
