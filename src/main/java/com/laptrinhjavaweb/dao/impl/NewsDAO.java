package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewsModel;
//import com.mysql.cj.xdevapi.Statement;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {
	

	@Override
	public List<NewsModel> findByCategoryId(Long categoryid) {
		String sql ="select * from news where categoryid = ?";
		return query(sql,new NewMapper(), categoryid);
	}

	@Override
	public Long save(NewsModel newModel) {
		StringBuilder sql = new StringBuilder("Insert into news (title, content,");
		sql.append(" thumbnail,shortdescription , categoryid, createddate, createdby )");
		sql.append(" values (?,?,?,?,?,?,?)");
		return insert(sql.toString(), newModel.getTitle(),newModel.getContent(),
				newModel.getThumbnail(),newModel.getShortdescription(), newModel.getCategoryid(),
				newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql ="select * from news where id = ?";
		List<NewsModel> news = query(sql,new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNew) {
		StringBuilder sql = new StringBuilder("update news set title = ?, thumbnail = ?, ");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?, ");
		sql.append("createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(),updateNew.getShortdescription(),
								updateNew.getContent(), updateNew.getCategoryid(), updateNew.getCreatedDate(), 
								updateNew.getCreatedBy(), updateNew.getModifiedDate(),
								updateNew.getModifiedBy(),
								updateNew.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "delete from news where id = ?";
		update(sql, id);
		
	}

	@Override
	public List<NewsModel> findAll() {
		String sql ="select * from news";
		return query(sql,new NewMapper());
	}

	
	
}
