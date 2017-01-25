package com.babynator.restserver.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.babynator.restserver.BabyNatorUser;

public class UserBabynatorDAO {

	public UserBabynatorDAO(){};
	
	//fonction pour v�rifier si le user existe
	public static BabyNatorUser seConnecter(BabyNatorUser user) {
		String requeteConnexion = "select * from userbabynator where email = ? and password = ?";		
		BabyNatorUser userConnect = null;
		try {
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setString(1,user.getEmail());
			requete.setString(2,user.getPassword());
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
				System.out.println(resultat.getString("email")+ resultat.getString("password"));	
				userConnect = new BabyNatorUser (resultat.getInt("id"),resultat.getString("email"), resultat.getString("password"));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return userConnect;	

	}
}