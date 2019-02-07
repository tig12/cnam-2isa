
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Arrays;

public class ConnectionTests {
    
    public static void main(String[] args) {
        
        // Vérification des arguments
        String[] possibles = {"postgres", "sqlite"};
        String usage = "Utilisation : java ConnectionTests <DBMS>\n<DBMS> peut prendre les valeurs : " + String.join(", ", possibles);
        
        if(args.length != 1){
            System.out.println(usage);
            System.out.println("Vous n'avez pas spécifié quel DBMS tester");
            System.exit(0);
        }
        
        if(!Arrays.asList(possibles).contains(args[0])){
            System.out.println(usage);
            System.out.println("Valeur incorrecte pour le DBMS : " + args[0]);
            System.exit(0);
        }
        
        Connection conn = null;
        String dburl, dbuser, dbpassword;
        try {
            switch(args[0]){
                case "sqlite" : 
                    dburl = "jdbc:sqlite:test1.sqlite3";
                    conn = DriverManager.getConnection(dburl);
                break;
                case "postgres" :
                    dburl = "jdbc:postgresql://localhost/cnamtest";
                    dbuser = "cnam";
                    dbpassword = "cnam";
                    conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
                break;
            }
            System.out.printf("Connection à %s OK.%n", args[0]);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}