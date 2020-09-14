package javaweb.service.iplm;

import java.util.List;

import javax.inject.Inject;

import javaweb.DAO.ICategoryDAO;
import javaweb.model.Category;
import javaweb.service.ICategoryService;

public class CategoryService  implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	
}
