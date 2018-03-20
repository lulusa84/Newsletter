package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connessione.Connessione;
import login.Utente;

public class Dao {

	private Connection conn;

	public Dao() {
		
		conn = Connessione.connetti();
				
	}
	
	
	public boolean autentica( String nome, String password ){
        Utente user = new Utente(nome, password); 
		boolean trovato = false;
		
		try {
            
            String sql =  "SELECT * FROM utente "
            			+ "WHERE nome = '" + user.getNome() + "' AND "
            			+ "password = '" + user.getPassword() + "' ;" ;

           conn = Connessione.connetti();
           
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            
            while (res.next()) {
                trovato = true;
            }

            st.close();
        } catch (SQLException ex) {
            System.out.println("Errore SQL in fase di autenticazione");
        }		
        
        return trovato;
   
	}
	
	public boolean aggiungi ( Utente user ){

		boolean trovato = false;

		String sql = "INSERT INTO utente ( nome, password, email ) "
					+ "VALUES ('" + user.getNome() + "', '" + user.getPassword() + "', '"
					+ user.getEmail() +"');";


		try {
		
			
			trovato = autentica(user.getNome(),user.getPassword());

			if(!trovato){
				conn =Connessione.connetti();
						
				
				Statement st = conn.createStatement();

				st.execute(sql);

				st.close();
				
				trovato = true;
			    
			}
			
		} catch (SQLException e) {
			System.out.println("Inserimento non riuscito. " + e.getMessage());
			
		}
		
		
		return trovato;
		   
	}
	public boolean elimina ( Utente user ){

		boolean trovato = false;

		String sql = "DELETE FROM utente WHERE nome = '" + user.getNome();


		try {
		
			
			trovato = autentica(user.getNome(),user.getPassword());

			if(trovato){
				conn =Connessione.connetti();
						
				
				Statement st = conn.createStatement();

				st.execute(sql);

				st.close();
				
				trovato = true;
			    
			}
			
		} catch (SQLException e) {
			System.out.println("Utente inisistente. " + e.getMessage());
			
		}
		
		
		return trovato;
		   
	}
	
	public void eliminaTutto (  ){
  
		String sql = "DELETE * FROM utente" ;
		
		
			conn =Connessione.connetti();
						
			try{	
				Statement st = conn.createStatement();

				st.execute(sql);

				st.close();
			
		} catch (SQLException e) {
			System.out.println("Errore " + e.getMessage());
		}
		}
	
	
	public static ArrayList<Utente> listaUtenti(  ){
		
		ArrayList<Utente> utenti = new ArrayList<>();
		
		String sql = "SELECT * FROM utente";
		
		Connection conn = Connessione.connetti();
				
		Statement st;
		
		try {

//			
			st = conn.createStatement();
			
			ResultSet res = st.executeQuery(sql);

			while( res.next() ){
				
				utenti.add( new Utente( res.getString("nome"), res.getString("password"), res.getString("email")));
				
			}
			
			res.close();
			conn.close();
			
		} catch (SQLException e) { e.printStackTrace(); }
				
		
		return utenti;
	}
	
	

}