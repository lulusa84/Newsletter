package connessione;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Restituisce la connessione JDBC al database
 */
public class connessione2 {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }

        String dburl = "jdbc:mysql://localhost/Utenti?user=root&password=";

        Connection conn = null ;
        
        try {
            conn = DriverManager.getConnection(dburl);
        } catch (SQLException e) {
     
        	System.out.println(e.getMessage());
   }
        
        return conn ;
    }
}



