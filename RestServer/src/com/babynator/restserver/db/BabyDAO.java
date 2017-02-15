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
	
	//fonction pour vérifier si le user existe
	public static ArrayList<Baby> getAllByUser(int user) {
		String requeteConnexion = "select id, name, gender, birthday, iduser, length, weight, picture from baby left outer join data on baby.id = data.idbaby where idUser = ? and data.currentdate = (select max(d.currentdate) from data d where d.idbaby = baby.id) ";		
		ArrayList<Baby> babies = new ArrayList<Baby>();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		try {
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setInt(1,user);
			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {
				babies.add(new Baby 
						(resultat.getInt("id"), resultat.getInt("idUser"),df.format(resultat.getDate("birthday")), 
								resultat.getString("name"), resultat.getString("gender"), resultat.getDouble("weight"),
								resultat.getDouble("length"), resultat.getString("picture")));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return babies;	
	}
	
	public static boolean addBaby(Baby baby){
		String requeteRegister = "INSERT INTO baby (id,birthday,name,gender,picture,idUser) VALUES (ID_BABY.nextval,(SELECT TO_DATE(?, 'DD-MM-YYYY') From DUAL),?,?,?,?)";
		try {

			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRegister);
			requeteSt.setString(1,baby.getBirthday());
			requeteSt.setString(2,baby.getName());
			requeteSt.setString(3,baby.getGender());
			requeteSt.setString(4,baby.getPicture());
			requeteSt.setInt(5,baby.getId_user());
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
				baby = new Baby (resultat.getInt("id"), resultat.getInt("iduser"), 
						df.format(resultat.getDate("birthday")), resultat.getString("name"), 
						resultat.getString("gender"), resultat.getString("picture"));
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
				baby = new Baby (resultat.getInt("id"), resultat.getInt("iduser"), df.format(resultat.getDate("birthday")), 
						resultat.getString("name"), resultat.getString("gender"), resultat.getString("picture"));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return baby;	
	}
	
	public static boolean removeBaby(int id){
		String requeteRemove = "DELETE FROM baby WHERE id = ? ";
		try {
			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRemove);
			
			requeteSt.setInt(1, id);
			requeteSt.executeUpdate();	
		}		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	
}
