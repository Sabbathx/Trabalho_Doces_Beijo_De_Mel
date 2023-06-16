package com.mycompany.beijodemel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoverDados{
    public static void main(String[] args){
        String SQLapagarDados = "DELETE FROM doces WHERE nome = ?";
        String driver = "jdbc:postgresql://localhost/DadosBeijoDeMel";

        try (Connection cn = DriverManager.getConnection(driver, "postgres", "123")) {
            if (cn != null){
                System.out.println("\nConnected to the database!");
            }else{
                System.out.println("\nFailed to make connection!");
            }

        System.out.print("\nInforme o nome do doce a ser removido: ");
        String nomeDoceRemover = new Scanner(System.in).nextLine();

        PreparedStatement pstmt = cn.prepareStatement(SQLapagarDados);
        pstmt.setString(1, nomeDoceRemover);

        System.out.println("\nRemovendo o item da tabela...");
            int linhasAfetadas = pstmt.executeUpdate();
            if (linhasAfetadas > 0){
                System.out.println("\nItem removido com sucesso!");
            }else{
                System.out.println("\nNenhum item removido. Verifique o nome fornecido.");
            }

            pstmt.close();
            cn.close();
        }catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}