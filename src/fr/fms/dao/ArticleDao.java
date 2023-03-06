package fr.fms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDao implements DAO<Article> {
	
	

	 Connection connection;
	 
	 public ArticleDao () throws IOException, SQLException {
		 this.connection = BddConnection.getConnection();
	 }
	
	@Override
	public void create(Article obj) {
		String createArticle = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('"+ obj.getDescription()+"','" + obj.getBrand() + "'," + obj.getPrice()+");";
		try(Statement statement = connection.createStatement()){
			statement.executeQuery(createArticle);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Article read(int id) {
		String getDescription = " Select * from T_Articles WHERE IdArticle="+id+";";
		Article oneArticle= null;
		try(Statement statement = connection.createStatement()){
			try(ResultSet result = statement.executeQuery(getDescription);) {
				while (result.next()) {
				int rsIdUser = result.getInt(1);
				String rsDescription = result.getString(2);
				String rsBrand = result.getString(3);
				double rsPrice = result.getDouble(4);
				oneArticle = new Article(rsIdUser, rsDescription, rsBrand, rsPrice);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return oneArticle;
	}

	@Override
	public boolean update(Article obj) {
		String strSql = "UPDATE t_articles SET Description = ?, Brand = ?, UnitaryPrice = ? WHERE IdArticle = ?";
		try (PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3,obj.getPrice());
			ps.setInt(4, obj.getId());
			if (ps.executeUpdate() == 1)
				return true;
		}
		 catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean delete(Article obj) {
		String deleteArticle = "DELETE from T_Articles WHERE IdArticle="+obj.getId()+";";
		try(Statement statement = connection.createStatement()){
			statement.executeQuery(deleteArticle);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Article> readAll() {
		ArrayList<Article> articles = new ArrayList<>();
		String strSql = "SELECT * FROM T_Articles";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);
					articles.add((new Article(rsIdUser, rsDescription, rsBrand, rsPrice)));
				}
			}
			for (Article a: articles)
				System.out.println(a.getId() + " - " + a.getDescription() + " - " + a.getBrand() + " - " + a.getPrice());
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

}
