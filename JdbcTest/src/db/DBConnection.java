package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *  uso singleton per evitare connessioni duplicate ed avere un unico punto di accesso al DB
 */

public class DBConnection  {			
	
	private static DBConnection instance;	// unica istanza 
	private Connection connection; 			// connessione condivisa 
	
	private static final String URL = "jdbc:mysql://localhost:3306/ProgettoUser";		
	private static final String USER = "root";
	private static final String PASSWORD =  "giadasql";

	/*
	 * costruttore privato , impedisce new DBConnection 
	 */
	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection= DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("Connessione stabilita!");
		}catch(ClassNotFoundException | SQLException e) { e.printStackTrace();}
	}
	
	/*
	 *  metodo per ottenere l'unica istanza
	 */	
	public static DBConnection getInstance() {
		if( instance==null) {
			instance= new DBConnection();
		}
		return instance; 
	}
	
	/*
	 * restituisce la connessione 
	 */
	public Connection getConnection(){
		return connection;
	}
}
