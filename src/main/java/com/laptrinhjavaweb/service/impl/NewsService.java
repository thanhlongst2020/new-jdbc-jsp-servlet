package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewsService;
import com.opensymphony.sitemesh.compatability.OldDecorator2NewDecorator;

public class NewsService implements INewsService {
	
	@Inject
	private INewsDAO newDao;
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryid) {
		return newDao.findByCategoryId(categoryid);
	}

	@Override
	public NewsModel save(NewsModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
		
	}

	@Override
	public NewsModel update(NewsModel updateNew) {
		NewsModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			//delete comment (khoa ngoai new_id)
			// delete news
			newDao.delete(id);
		}
		
	}

	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotaItem();
	}
	
}
