package com.mycompany.beijodemel;

/**
 *
 * @author Sabbathx
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarDocesAcabando {
    public static void main(String[] args) {
        String SQLconsultarDados = "SELECT * FROM doces WHERE qtdkg < 3.5";
        String driver = "jdbc:postgresql://localhost/DadosBeijoDeMel";
        Statement st = null;
        ResultSet result = null;

        try (Connection cn = DriverManager.getConnection(driver, "postgres", "123")) {
            if (cn != null) {
                System.out.println("\nConnected to the database!");
            } else {
                System.out.println("\nFailed to make connection!");
            }

            System.out.println("\nDoces com menos de 3,5kg no estoque...\n");
            st = cn.createStatement();
            result = st.executeQuery(SQLconsultarDados);

            while (result.next()) {
                System.out.println("-----------------------------------");
                System.out.println("Nome: " + result.getString(1));
                System.out.println("Tipo: " + result.getString(2));
                System.out.println("PrecoKg: " + result.getFloat(3));
                System.out.println("QuantidadeKg: " + result.getFloat(4));
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}

