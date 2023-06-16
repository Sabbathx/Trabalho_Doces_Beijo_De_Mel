package com.mycompany.beijodemel;

/**
 *
 * @author Sabbathx
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InserirDados{
    public static void main(String[] args){
        String SQLinserirDados = "INSERT INTO doces (nome, tipo, precokg, qtdkg) VALUES (?, ?, ?, ?)";
        String driver = "jdbc:postgresql://localhost/DadosBeijoDeMel";

        try (Connection cn = DriverManager.getConnection(driver, "postgres", "123")) {
            if (cn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

            System.out.print("\nInforme os dados do doce: \n");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            System.out.print("PrecoKg: ");
            float precokg = scanner.nextFloat();
            System.out.print("QuantidadeKg: ");
            float qtdkg = scanner.nextFloat();
            scanner.nextLine();

            PreparedStatement pstmt = cn.prepareStatement(SQLinserirDados);
            pstmt.setString(1, nome);
            pstmt.setString(2, tipo);
            pstmt.setFloat(3, precokg);
            pstmt.setFloat(4, qtdkg);

            System.out.println("\nInserindo os dados na tabela...");
            pstmt.executeUpdate();
            System.out.println("\nDados Inseridos!");

            pstmt.close();
            cn.close();
        }catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}