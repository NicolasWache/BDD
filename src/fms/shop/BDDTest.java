package fms.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.BddConnection;
import fr.fms.dao.UserDao;
import fr.fms.entities.Article;
import fr.fms.entities.User;

public class BDDTest {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		UserDao userDao = new UserDao();	
		ArticleDao articledao = new ArticleDao();
		Connection connection = BddConnection.getConnection();
		ResultSet rs = null;
		Boolean connected = false;

		while (!connected) {
			System.out.println("Bonjour, veuillez saisir votre identifiant");
			String login = scan.next();
			System.out.println("Merci, ");
			System.out.println("Veuillez saisir votre mot de passe");
			String password = scan.next();
			String log = "SELECT login from T_Users WHERE login=? AND password =?";
			try(PreparedStatement ps = connection.prepareStatement(log)){
				ps.setString(1, login);
				ps.setString(2, password);
				rs = ps.executeQuery();
				if (rs.next()) {
					connected = true;
					System.out.println("Bienvenue " + login );
					int userChoice = 0;
					while (userChoice != 6) {
						System.out.println(" Que souhaitez vous faire ? ");
						System.out.println("[1] Afficher la liste des articles");
						System.out.println("[6] Se déconnecter");
						try {
							userChoice = scan.nextInt();
							switch (userChoice) {
							case 1: 
								articledao.readAll();
								break;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else {
					System.out.println("Connexion refuseée, réessayez");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}		
		} 
	}
}

