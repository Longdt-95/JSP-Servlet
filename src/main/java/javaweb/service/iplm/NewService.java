package javaweb.service.iplm;

import java.util.List;

import javax.inject.Inject;

import javaweb.DAO.INewDAO;
import javaweb.model.News;
import javaweb.service.INewsService;

public class NewService implements INewsService {

	@Inject
	private INewDAO newDAO;
	@Override
	public List<News> findByIdCategory(String id) {
		return newDAO.findByIdCategory(id);
	}
	@Override
	public void update(News news) {
		newDAO.edit(news);
	}
	@Override
	public Long save(News news) {
		return newDAO.save(news);
	}
	@Override
	public void delete(News news) {
		newDAO.delete(news);
	}
	@Override
	public List<News> findAll(Integer offset, Integer rowOfPage) {
		return newDAO.findAll(offset, rowOfPage);
	}
	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}
}
