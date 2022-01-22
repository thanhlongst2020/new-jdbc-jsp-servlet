package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewsModel;
//import com.mysql.cj.xdevapi.Statement;
import com.laptrinhjavaweb.paging.Pageble;

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
				newModel.getThumbnail(),newModel.getShortDescription(), newModel.getCategoryId(),
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
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(),updateNew.getShortDescription(),
								updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), 
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
	public List<NewsModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from news");
		if(pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy()) ) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" " +pageble.getSorter().getSortBy()+"");
		}
		if(pageble.getOffset() != null && pageble.getLimit() != null ) {
			sql.append(" limit "+pageble.getOffset()+","+pageble.getLimit()+"");
		} 
		return query(sql.toString(),new NewMapper());
		
	}

	@Override
	public int getTotaItem() {
		String sql = "select count(*) from news;";
		return count(sql);
	}

	
	
}
