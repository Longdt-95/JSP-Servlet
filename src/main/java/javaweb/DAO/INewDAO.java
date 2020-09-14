 package javaweb.DAO;

import java.util.List;

import javaweb.model.News;

public interface INewDAO extends GenericDAO<News>{
	List<News> findByIdCategory(String id);
	List<News> findAll(Integer offset, Integer rowOfPage);
	 void edit(News news);
	 Long save(News news);
	 void delete(News news);
	 int getTotalItem();
}	
