package com.babynator.restserver.db;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.babynator.restserver.Data;

public class DataDAO {

	
	public static boolean addData(Data data){
		String requeteRegister = "INSERT INTO Data (weight,length,idbaby,currentdate) VALUES (?,?,?,(SELECT TO_DATE(?, 'DD-MM-YYYY') From DUAL))";
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(df.format(date));
		try {
			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRegister);
			requeteSt.setInt(1,data.getWeight());
			requeteSt.setInt(2,data.getLength());
			requeteSt.setInt(3,data.getId_baby());
			requeteSt.setString(4,df.format(date));
			requeteSt.executeUpdate();	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
