package MODEL;

import java.sql.*;

public class Connettore {
	private final static String bd = "jdbc:mysql://localhost:3306/AZIENDA2";
	private final static String name = "com.mysql.cj.jdbc.Driver";
	private Connection con;
	
	public Connettore(){
		
	}
	
	public boolean OpenConnection(String email, String password){
		try {
			Class.forName(name);
			Connection con = DriverManager.getConnection(bd, email, password);
			this.con = con;
			return true;
		}
		catch(ClassNotFoundException e) {
			System.out.println("DB Driver non trovato!");
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println("Connessione fallita!");
		}
		return false;
    }
	
	public Connection getConnection() {
		return this.con;
	}
	
	public boolean isConnected() {
		if(con != null) {
			return true;
		}
		return false;
	}
	
	public boolean closeConnection(){
		try {
			if(this.con != null){
				this.con.close();
				this.con = null;
				return true;
			}
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return false;
	}
	
}
