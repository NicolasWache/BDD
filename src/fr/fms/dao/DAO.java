package fr.fms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
	public Connection connection = BddConnection.getConnection();
	public void create (T obj) throws IOException, SQLException;
	public T read (int id);
	public boolean update (T obj);
	public boolean delete (T obj);
	public ArrayList<T> readAll();
}
