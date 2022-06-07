package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPool {
	private static List<Connection> freeDbConnections;
	private final static String db = "jdbc:mysql://localhost:3306/AZIENDA2";
	private final static String name = "com.mysql.cj.jdbc.Driver";
	
		static {
			freeDbConnections = new LinkedList<Connection>();

			try {
				Class.forName(name);
			} catch (ClassNotFoundException e) {
				System.out.println("DB driver not found!"+e);
			} catch (Exception e) {
				System.out.println("DB connection pool error!"+e);
			}
		}

		private static Connection createDBConnection(String email, String password) throws SQLException {
			Connection newConnection = null;
			newConnection = DriverManager.getConnection(db,email, password);
			newConnection.setAutoCommit(false);
			return newConnection;
		}
		
		public static synchronized Connection getConnection(String email,String password) throws SQLException {
			Connection connection;
			if (! freeDbConnections.isEmpty()) {
				connection = (Connection) freeDbConnections.get(0);
				ConnectionPool.freeDbConnections.remove(0);
				try {
					if (connection.isClosed())
						connection = ConnectionPool.getConnection(email,password);
				} catch (SQLException e) {
					connection = ConnectionPool.getConnection(email,password);
				}
			} else connection = ConnectionPool.createDBConnection(email,password);
			System.out.println("Connessione ottenuta tramite ConnectionPool");
			return connection;
		}
		
		public static synchronized void releaseConnection(Connection connection) {
			ConnectionPool.freeDbConnections.add(connection);
			System.out.println("Connessione rilasciata tramite ConnectionPool");
		}

}
