package com.mycompany.beijodemel;

/**
 *
 * @author Sabbathx
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LimparLista {
    public static void main(String[] args){
        String SQLapagarDados = "DELETE from doces";
        String driver = "jdbc:postgresql://localhost/DadosBeijoDeMel";
        Statement st = null;
        
        try (Connection cn = DriverManager.getConnection(driver, "postgres", "123")){
            if(cn != null){
                System.out.println("\nConnected to the Database!");
            }else{
                System.out.println("\nFailed to make connection!");
            }
            System.out.println("\nApagando dados...");
            st = cn.createStatement();
            st.executeUpdate(SQLapagarDados);
            System.out.println("\nDados Apagados com sucesso!");
            st.close();
            cn.close();
            
        }catch(SQLException e){
        System.err.format("SQL State: %s\n%s" , e.getSQLState(), e.getMessage());
        }
    }
}