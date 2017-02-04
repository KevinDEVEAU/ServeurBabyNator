package com.babynator.restserver.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.babynator.restserver.Baby;
import com.babynator.restserver.BabyNatorUser;

public class BabyDAO {

	public BabyDAO(){};
	
	//fonction pour v�rifier si le user existe
	public static ArrayList<Baby> getAllByUser(BabyNatorUser user) {
		String requeteConnexion = "select * from baby where idUser = ?";		
		ArrayList<Baby> babies = new ArrayList<Baby>();
		try {
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setInt(1,user.getId());
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
			//	babies.add(new Baby 
			//			(resultat.getInt("id"),resultat.getString("birthday"), resultat.getString("name"), resultat.getString("gender"), resultat.getInt("idUser")));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return babies;	
	}
	
	public static boolean addBaby(Baby baby){
		String requeteRegister = "INSERT INTO baby (id,birthday,name,gender,idUser) VALUES (ID_BABY.nextval,(SELECT TO_DATE(?, 'DD-MM-YYYY') From DUAL),?,?,?)";
		try {

			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRegister);
			requeteSt.setString(1,baby.getBirthday());
			requeteSt.setString(2,baby.getName());
			requeteSt.setString(3,baby.getGender());
			requeteSt.setInt(4,baby.getId_user());
			requeteSt.executeUpdate();	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static Baby getLastInsertBaby(int id_user){
		String requeteConnexion = "select * from baby where iduser = ? and id = (SELECT MAX(id) FROM baby where iduser = ?)";	
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Baby baby = null;
		try {
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setInt(1,id_user);
			requete.setInt(2,id_user);
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
				baby = new Baby (resultat.getInt("id"), resultat.getInt("iduser"), df.format(resultat.getDate("birthday")), resultat.getString("name"), resultat.getString("gender"));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return baby;
	}

	public static Baby getBabyById(int id) {
		String requeteConnexion = "select * from baby where id = ?";	
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Baby baby = null;
		try {
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setInt(1,id);
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
				baby = new Baby (resultat.getInt("id"), resultat.getInt("iduser"), df.format(resultat.getDate("birthday")), resultat.getString("name"), resultat.getString("gender"));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return baby;	
	}
}
