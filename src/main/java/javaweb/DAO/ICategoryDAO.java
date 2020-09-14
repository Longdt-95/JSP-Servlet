package javaweb.DAO;

import java.util.List;

import javaweb.model.Category;


public interface ICategoryDAO  extends GenericDAO<Category>{
	public List<Category> findAll();
}
