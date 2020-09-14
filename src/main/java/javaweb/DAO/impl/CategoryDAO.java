package javaweb.DAO.impl;

import java.util.List;

import javaweb.DAO.ICategoryDAO;
import javaweb.mapper.CategoryMapper;
import javaweb.model.Category;

public class CategoryDAO extends AbstrackDAO<Category> implements ICategoryDAO {

	String sql = "select * from Category";
	@Override
	public List<Category> findAll() {
		return query(sql, new CategoryMapper());
	}
	
}
