package fr.fms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import fms.shop.CreateConfigFile;

public class BddConnection {
	
private static Connection connection = null;
	

	public static Connection getConnection() throws IOException, SQLException {
		
		if (connection == null) {
			Properties prop = CreateConfigFile.readPropertiesFile("lib/credentials.properties");
			try {
				Class.forName(prop.getProperty("db.driver.class"));
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String url = prop.getProperty("db.url");
			String login= prop.getProperty("db.login");
			String password = prop.getProperty("db.password");
			
			connection = DriverManager.getConnection(url, login, password);
			
		}
		
		
		return connection;
		
	
	}

}
