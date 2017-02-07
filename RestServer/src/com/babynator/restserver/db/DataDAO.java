package com.babynator.restserver.db;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.babynator.restserver.Baby;
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
	
	public static boolean addDataBirthday(Data data){
		String requeteRegister = "INSERT INTO Data (weight,length,idbaby,currentdate) VALUES (?,?,?,(SELECT TO_DATE(?, 'DD-MM-YYYY') From DUAL))";
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println(df.format(date));
		try {
			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteRegister);
			requeteSt.setInt(1,data.getWeight());
			requeteSt.setInt(2,data.getLength());
			requeteSt.setInt(3,data.getId_baby());
			requeteSt.setString(4,data.getCurrent_date());
			requeteSt.executeUpdate();	
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static List<Data> getListData(int id_baby){
		String requeteListData = "select idbaby, data_date, year, month, AVG(weight)as weight, AVG(length) as length from (select idbaby, to_char( currentdate , 'MM/YYYY' )as data_date, to_char(currentdate, 'yyyy') as year, to_char(currentdate, 'mm') as month,weight,length as length from data where idbaby = ?) group by idbaby, data_date,year, month order by year, month";
		List<Data> datas = new ArrayList<Data>();
		try {
			PreparedStatement requeteSt = DAOOracle.getInstance().getConnection().prepareStatement(requeteListData);
			requeteSt.setInt(1,id_baby);
			ResultSet resultat = requeteSt.executeQuery();

			while (resultat.next()) {
				 datas.add(new Data(resultat.getInt("weight"), resultat.getInt("length") ,resultat.getInt("idbaby"),resultat.getString("data_date")));
			}	
		}
		
		catch (SQLException e) {

		}
		return datas;
	}
	
}
