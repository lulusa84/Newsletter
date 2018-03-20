package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import connessione.Connessione;


public class Test {
	public static String titolo;
	public static String difficolta;
	public static String pfile;
	
    public static void main(String[] args) {
		

		Connection c = Connessione.connetti();

         if (c == null){
        	
			System.out.println("NO");
			
            }else{
				System.out.println("OK");
			}
         
         
 	}
	
 public boolean selezionaUtente(String nome, String password){
	 Connection c= Connessione.connetti();
     String NomeUtente = "";
     String PasswordUtente ="";
		try
		{
	      
	       ResultSet rs =null;
	      String sql = "SELECT nome, password FROM utente WHERE "
	      		+ "nome =? AND password =? ";
				
				PreparedStatement stmt = c.prepareStatement(sql);
				
				stmt.setString(1,nome);
				stmt.setString(2,password);
				
				 rs = stmt.executeQuery();
			     if(rs.next()) {
					 NomeUtente = rs.getString("nome");
				     PasswordUtente = rs.getString("password");
				
		        return true;
			 
              }else{
            	  
	         return false;
            }
		   } catch (SQLException e) {
			e.printStackTrace();
		   }
		return false;
	  
  }
 
 public boolean insertUtente(String nome, String password){
	 Connection c= Connessione.connetti();
     
     boolean esito = true;
		if(nome=="" || password=="") return false;
		
		try
		{
	      
	       ResultSet rs =null;
	       PreparedStatement p = 
					c.
					prepareStatement("insert into utente (nome, password) values(?,?)");
			p.setString(1, nome);
			p.setString(2, password);
			
			p.execute();
			
		}
		catch (SQLException e)
		{
			esito = false;
			e.printStackTrace();
			
		}
		System.out.println(esito);
		return esito;
		
		
	}
	
 public boolean verificaUtente(String nome){
	 Connection c= Connessione.connetti();
    
		try
		{
	      
	      ResultSet rs =null;
	      String sql = "SELECT nome FROM utente WHERE "
	      		+ "nome =? ";
				
				PreparedStatement stmt = c.prepareStatement(sql);
				
				stmt.setString(1,nome);
				
				
				 rs = stmt.executeQuery();
			     if(rs.next()) {
					 
				
		      return true;
			 
              }else{
            	  
	         return false;
            }
			     
		    } catch (SQLException e) {
			e.printStackTrace();
		   }
		return false;
		 
     } 
 

	}

