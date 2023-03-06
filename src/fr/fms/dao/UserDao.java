package fr.fms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;
import fr.fms.entities.User;

public class UserDao implements DAO<User> {
	
 Connection connection;
	 
	 public UserDao () throws IOException, SQLException {
		 this.connection = BddConnection.getConnection();
	 }

	@Override
	public void create(User obj)  {
		String createUser = "INSERT INTO T_Users (Login, Password) VALUES ('"+ obj.getLogin()+"','" + obj.getPassword() +");";
		try(Statement statement = connection.createStatement()){
			statement.executeQuery(createUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User read(int id) {
		String getOneUser = " Select * from T_Users WHERE IdUser="+id+";";
		User oneUser= null;
		try(Statement statement = connection.createStatement()){
			try(ResultSet result = statement.executeQuery(getOneUser);) {
				while (result.next()) {
				String login = result.getString(1);
				String password = result.getString(2);
				oneUser = new User (login, password);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return oneUser;
	}

	@Override
	public boolean update(User obj) {
		String strSql = "UPDATE t_users SET Login = ?, Password = ?, UnitaryPrice = ? WHERE IdArticle = ?";
		try (PreparedStatement ps = connection.prepareStatement(strSql)){
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			
			if (ps.executeUpdate() == 1)
				return true;
		}
		 catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}
	@Override
	public boolean delete(User obj) {
		String deleteUser = "DELETE from T_Users WHERE IdUser"+obj.getId()+";";
		try(Statement statement = connection.createStatement()){
			statement.executeQuery(deleteUser);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<>();
		String strSql = "SELECT * FROM T_Users";
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					
					String login = resultSet.getString(1);
					String password = resultSet.getString(2);
					
					users.add((new User(login, password)));
				}
			}
			for (User a: users)
				System.out.println(a.getLogin() + " - " + a.getPassword());
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
