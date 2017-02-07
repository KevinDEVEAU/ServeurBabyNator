package com.babynator.restserver.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.babynator.restserver.BabyNatorUser;
import com.babynator.restserver.Event;

public class EventDAO {

	public EventDAO(){};
	
	//fonction pour vérifier si le user existe
	public static ArrayList<Event> getAllByUser(int id_user) {
		String requeteConnexion = "select * from event where idUser = ?";		
		ArrayList<Event> events = new ArrayList<Event>();
		try {
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setInt(1,id_user);
			ResultSet resultat = requete.executeQuery();

			while (resultat.next()) {
				events.add(new Event 
						(resultat.getInt("id"), resultat.getString("currentDate"),resultat.getString("title"), resultat.getString("description"), resultat.getInt("idUser")));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return events;	
	}
	
	public static boolean removeEvent(int id){
		String requeteRegister = "DELETE FROM event WHERE id = ? ";
		try {
			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRegister);
			
			requeteSt.setInt(1, id);
			requeteSt.executeUpdate();	
		}		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean addEvent(Event event){
		String requeteRegister = "INSERT INTO event (id,currentDate,title,description,idUser) "
				+ "VALUES (ID_USER.nextval,to_date(?, 'yyyy/mm/dd hh24:mi'),?,?,?)";
		try {
			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRegister);
			
			requeteSt.setString(1,event.getCurrent_date());
			requeteSt.setString(2,event.getTitle());
			requeteSt.setString(3,event.getDescription());
			requeteSt.setInt(4,event.getId_user());
			requeteSt.executeUpdate();	
		}		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean setEvent(Event event){
		System.out.println(event.toString());
		String requeteRegister = "UPDATE event SET currentDate = to_date(?, 'yyyy-mm-dd hh24:mi:ss'), title = ?, description = ? WHERE id = ?";
		try {
			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRegister);
			
			requeteSt.setString(1,event.getCurrent_date());
			requeteSt.setString(2,event.getTitle());
			requeteSt.setString(3,event.getDescription());
			requeteSt.setInt(4,event.getId());
			requeteSt.executeUpdate();	
		}		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static Event getEventById(int id) {
		String requeteConnexion = "select * from event where id = ?";		
		Event event = new Event();
		try {
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setInt(1,id);
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
				event = new Event (resultat.getInt("id"), resultat.getString("currentDate"),resultat.getString("title"), resultat.getString("description"), resultat.getInt("idUser"));
			}			
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return event;	
	}
}
