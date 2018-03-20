package login;

import java.util.ArrayList;



public class ListaUtente {

	private ArrayList<Utente> lista;
	
	public ListaUtente(){
		super();
		setLista(new ArrayList<>());
		
	}

	
	public ArrayList<Utente> getLista() {
		return Dao.listaUtenti();
	}
    
	public void setLista(ArrayList<Utente> lista) {
		this.lista = lista;
	}
	
	

public boolean aggiungiUtente( ){
//		
		  Utente nuovo  = new Utente();
		  Dao n  = new Dao();
		if( trovaNome(nuovo) )
			return false;
		
		if( ! nuovo.getNome().equals("") && ! nuovo.getPassword().equals("")
			&&	! nuovo.getEmail().equals(""))
			 n.aggiungi(nuovo);	
		
		return true;
	}


	public boolean aggiungi( Utente nuovo ){
		

		
		if( trovaNome(nuovo) )
			return false;
		
		if( ! nuovo.getNome().equals("") && ! nuovo.getPassword().equals(""))
			lista.add( nuovo );
		
		return true;
	}
	
	
	private boolean trovaNome(Utente nuovo) {
		for( Utente u : lista )
		if( u.getNome().equalsIgnoreCase( nuovo.getNome() ) )	
			return true;
		return false;
	}

	public boolean autentica( Utente user ){
		return lista.contains( user );
	}
	public boolean autenticaDao( Utente user ){
		Dao ud = new Dao ();
		return  ud.autentica(user.getNome(),user.getPassword());
	}
	
	public Utente getUtente( String nome ){
		for( Utente u : lista )
			if( u.getNome().equalsIgnoreCase( nome ) )	
				return u;
			return null;
	}
	
public void elimina(String nome){
	Dao ud = new Dao();
		Utente user = getUtente(nome); 
			ud.elimina(user)	;
	
	}
	
public void cancellaTutto(){
	Dao ud = new Dao();
	ud.eliminaTutto();
}

public void modificaUtente( int i , String nome ){

	lista.get(i).setNome(nome);
	
}

}
