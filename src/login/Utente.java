package login;

public class Utente {
String nome;
String password;
String email;
public Utente() {
	super();
	
}
public Utente(String nome, String password) {
	super();
	this.nome = nome;
	this.password = password;
}

public Utente(String nome, String password, String email) {
	super();
	this.nome = nome;
	this.password = password;
	this.email = email;
}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

@Override
public boolean equals(Object o){
	
	if( o == null )
		return false;
	
	if( o instanceof Utente ){
		
		Utente user = (Utente) o;
	
		return nome.equalsIgnoreCase(user.nome) && password.equals(user.password) &&
		email.equals(user.email);
		}
	
	return false;
}

public boolean stessoNome( Utente u ){
	return this.nome.equalsIgnoreCase( u.nome );
}

public String toString(){
	return nome;
}
public String getEmail() {
	
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
