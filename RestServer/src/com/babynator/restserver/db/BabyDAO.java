package com.babynator.restserver.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.babynator.restserver.Baby;
import com.babynator.restserver.BabyNatorUser;

public class BabyDAO {

	public BabyDAO(){};
	
	//fonction pour vérifier si le user existe
	public static ArrayList<Baby> getAllByUser(BabyNatorUser user) {
		String requeteConnexion = "select * from baby where idUser = ?";		
		ArrayList<Baby> babies = new ArrayList<Baby>();
		try {
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setInt(1,user.getId());
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
				babies.add(new Baby 
						(resultat.getInt("id"),resultat.getDate("birthday"), resultat.getString("name"), resultat.getString("gender"), resultat.getInt("idUser")));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return babies;	
	}
	
	public static boolean addBaby(Baby baby){
		String requeteRegister = "INSERT INTO baby (id,birthday,name,gender,idUser) VALUES (ID_USER.nextval,?,?,?,?)";
		try {
			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRegister);
			requeteSt.setDate(1,baby.getBirthday());
			requeteSt.setString(2,baby.getName());
			requeteSt.setString(3,baby.getGender());
			requeteSt.setInt(4,baby.getId_User());
			requeteSt.executeUpdate();	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static Baby getBabyById(int id) {
		String requeteConnexion = "select * from baby where id = ?";		
		Baby baby = null;
		try {
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setInt(1,id);
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
				baby = new Baby (resultat.getInt("id"),resultat.getDate("birthday"), resultat.getString("name"), resultat.getString("gender"), resultat.getInt("id_user"));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return baby;	
	}
}
