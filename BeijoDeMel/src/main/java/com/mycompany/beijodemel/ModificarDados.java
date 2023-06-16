package com.mycompany.beijodemel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ModificarDados{
    public static void main(String[] args){
        String SQLapagarDados = "DELETE FROM doces WHERE nome = ?";
        String SQLinserirDados = "INSERT INTO doces (nome, tipo, precokg, qtdkg) VALUES (?, ?, ?, ?)";
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
        
        int linhasAfetadas = pstmt.executeUpdate();
            if (linhasAfetadas <= 0){
                System.out.println("O item não pode ser modificado. Verifique o nome digitado.");
            }
        
        System.out.print("Informe os novos dados do doce: \n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Novo preco por quilogramas: ");
        float precokg = scanner.nextFloat();
        System.out.print("Nova quantidade em quilogramas: ");
        float qtdkg = scanner.nextFloat();
        scanner.nextLine();

        pstmt = cn.prepareStatement(SQLinserirDados);
        pstmt.setString(1, nome);
        pstmt.setString(2, tipo);
        pstmt.setFloat(3, precokg);
        pstmt.setFloat(4, qtdkg);

        System.out.println("\nInserindo os novos dados na tabela...");
        pstmt.executeUpdate();
        System.out.println("\nDados modificados com sucesso!");
        
        pstmt.close();
            
            cn.close();
        }catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}