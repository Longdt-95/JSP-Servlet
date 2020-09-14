package javaweb.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javaweb.DAO.INewDAO;
import javaweb.mapper.NewMapper;
import javaweb.model.News;

public class NewDAO extends AbstrackDAO<News> implements INewDAO {
	@Override
	public List<News> findByIdCategory(String id) {
		String SQL = "select * from news where code = ? ";
		return query(SQL, new NewMapper(), id );
	}
	public void edit(News news) {
		String sql = "update news set title = ? where id = ?";
		update(sql, news.getTitle(), news.getId());
	}
	public Long save(News news) {
		String sql = "insert into news(code,title) values(?,?)";
		return insert(sql, news.getCode(), news.getTitle());
	}
	@Override
	public void delete(News news) {
		String sql = "delete news where id = ?";
		update(sql, news.getId());
	}
	@Override
	public List<News> findAll(Integer offset, Integer rowOfPage) {
		String sql = "select * from news order by id OFFSET ? ROWS  FETCH NEXT ? ROWS ONLY ";
		return query(sql, new NewMapper(), offset, rowOfPage);
	}
	@Override
	public int getTotalItem() {
		int totalItem  = 0;
		String sql = "select COUNT(*) as totelItem from news" ;
		Connection connection = null;
		PreparedStatement preSt = null;
		ResultSet resultSet = null;
		try
		{
			connection = getConnection();
			preSt = connection.prepareStatement(sql);
			resultSet = preSt.executeQuery();
			while(resultSet.next()) {
			totalItem = resultSet.getInt(1);
			}
			return totalItem;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preSt != null) {
					preSt.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		return 0;
	}
}
