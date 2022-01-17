package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryid);
	NewsModel save(NewsModel newModel);
	NewsModel update(NewsModel updateNew);
	void delete(long[] ids);
	List<NewsModel> findAll(Integer offset, Integer limit);
	int getTotalItem();
}
