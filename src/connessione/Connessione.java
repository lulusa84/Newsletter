package connessione;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione {
	
	
	private static  String url;
	private DriverManager dm; 
	
		
		public Connessione() {
			super();
		}
		
		public Connessione(String url) {
		super();
		
		this.url="jdbc:mysql://localhost/Utenti";
		}
		
		public  String getUrl() {
			return url;
		}

		public static void setUrl(String url) {
			Connessione.url = url;
		}

		public DriverManager getDm() {
			return dm;
		}

		public void setDm(DriverManager dm) {
			this.dm = dm;
		}

		public static  Connection connetti(){
			Connection connessione = null;
			
			
			String url2="jdbc:mysql://localhost/Utenti";
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				
			} catch (ClassNotFoundException e1) {
				System.out.println("CFN");
			    e1.printStackTrace();
			}
			
			try {
				connessione = DriverManager.getConnection(url2,"root","bhemaut84");
			} catch (SQLException e) {
				
				System.out.println("DMC");
				
			    e.printStackTrace();
				
			}
			return connessione;
			
		}

		
 
	}


