package javaweb.service;

import java.util.List;

import javaweb.model.News;

public interface INewsService {
	List<News> findByIdCategory(String id);
	List<News> findAll(Integer offset, Integer rowOfPage);
	 void update(News news);
	 Long save(News news);
	 void delete(News news);
	 int getTotalItem();
}
