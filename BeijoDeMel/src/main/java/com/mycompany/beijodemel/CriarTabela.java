/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.beijodemel;

/**
 *
 * @author Sabbathx
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
    public static void main(String[] args){
        String SQLcriarTabela = "CREATE TABLE doces ("+"nome VARCHAR(60), tipo VARCHAR(60), precokg float, qtdkg float)";
        String driver = "jdbc:postgresql://localhost/DadosBeijoDeMel";
        Statement st = null;
        
        try (Connection cn = DriverManager.getConnection(driver, "postgres", "123")){
            if(cn!=null){
                System.out.println("Connected to the database!");
            }else{
                System.out.println("Failed to make connection!");
            }
            System.out.println("Criando dados da lista...");
            st = cn.createStatement();
            st.executeUpdate(SQLcriarTabela);
            System.out.println("A lista foi criada com sucesso!");
            st.close();
            cn.close();
            
    }catch(SQLException e){      
        System.err.format("\nSQL State: %s\n%s", e.getSQLState(), e.getMessage());
    }
  }
}
