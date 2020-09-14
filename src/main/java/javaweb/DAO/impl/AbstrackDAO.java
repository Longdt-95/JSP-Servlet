package javaweb.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javaweb.DAO.GenericDAO;
import javaweb.mapper.RowMapper;

public class AbstrackDAO<T> implements GenericDAO<T> {
	
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	public Connection getConnection() {
		try {
			getClass();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			String url = "jdbc:sqlserver://localhost:1433;databaseName = CategoryDB";
//			String user = "sa";
//			String passwork = "saker0905971230";
			
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String passwork = resourceBundle.getString("passwork");
			return DriverManager.getConnection(url, user, passwork);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> List<T> query(String sql, RowMapper<T> rp, Object... paramater) {
		List<T> results = new ArrayList<T>();
		Connection connection = null;
		PreparedStatement preSt = null;
		ResultSet resultSet = null;
		try
		{
			connection = getConnection();
			preSt = connection.prepareStatement(sql);
			setparamater(preSt, paramater);
			resultSet = preSt.executeQuery();
			while (resultSet.next()) 
			{
				results.add(rp.mapRow(resultSet));
			}
			return results;
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
				return null;
			}
		}
		return null;
	}

	private void setparamater(PreparedStatement preSt, Object... paramater) {
		for (int i = 0; i < paramater.length; i++) {
			Object parameterr = paramater[i];
			int index = i + 1;
				try {
					if(parameterr instanceof Long)
					{
					preSt.setLong(index, (Long)parameterr);
					}else if(parameterr instanceof String)
					{
						preSt.setString(index, (String)parameterr);
					}else if (parameterr instanceof Integer)
					{
						preSt.setInt(index, (Integer)parameterr);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public void update(String sql, Object... parameter) {
		Connection connection = null;
		PreparedStatement statement = null;
		try
		{
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setparamater(statement, parameter);
			statement.executeUpdate();
			connection.commit();
		}catch(SQLException e)
		{
			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		finally
		{
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... paramater) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = null;
		try
		{
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setparamater(statement, paramater);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next())
			{
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
			if(connection != null)
			{
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return null;
		}
		finally
		{
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if(resultSet != null)
				{
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
