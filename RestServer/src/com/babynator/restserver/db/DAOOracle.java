package com.babynator.restserver.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOOracle {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";//url bdd
	String utilisateur = "altal"; //identifiant de la BDD
	String motDePasse = "kevin"; //Mdp de la BDD
	private Connection connection;	
	private static DAOOracle Instance;
	
	public DAOOracle() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");			
			setConnection(DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","altal", "kevin"));							
		}
		catch (Exception e) {		
			e.printStackTrace();
		}
	}

	public static synchronized DAOOracle getInstance()
	{
		if(Instance==null)
		{
			Instance = new DAOOracle();
		}
		return Instance;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
