package com.babynator.restserver.db;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.babynator.restserver.BabyNatorUser;

public class UserBabynatorDAO {

	public UserBabynatorDAO(){};
	
	//fonction pour vérifier si le user existe
	public static BabyNatorUser seConnecter(BabyNatorUser user) {
		String requeteConnexion = "select * from userbabynator where email = ? and password = ?";		
		BabyNatorUser userConnect = null;
		try {
			String passwordToHash = user.getPassword();
	        String generatedPassword = null;
	        
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
	        
			PreparedStatement requete = DAOOracle.getInstance().getConnection().prepareStatement(requeteConnexion);
			requete.setString(1,user.getEmail());
			requete.setString(2,generatedPassword);
			ResultSet resultat = requete.executeQuery();

			if (resultat.next()) {
				System.out.println(resultat.getString("email")+ resultat.getString("password"));	
				userConnect = new BabyNatorUser (resultat.getInt("id"),resultat.getString("email"), resultat.getString("password"));
			}			
		}		
		catch (Exception e) {
			e.printStackTrace();
		}
		return userConnect;	

	}
	
	public static boolean registerUser(BabyNatorUser user){
		String requeteRegister = "INSERT INTO userbabynator (id,email,password) VALUES (ID_USER.nextval,?,?)";
		try {
			String passwordToHash = user.getPassword();
	        String generatedPassword = null;
	        
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
            
			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRegister);
			requeteSt.setString(1,user.getEmail());
			requeteSt.setString(2,generatedPassword);
			requeteSt.executeUpdate();	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
