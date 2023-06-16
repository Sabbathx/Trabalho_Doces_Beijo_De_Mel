package com.mycompany.beijodemel;

/**
 *
 * @author Sabbathx
 */
import java.util.Scanner;

public class BeijoDeMel {
    static String driverJDBC = "org.postgresql.Driver";
    public static void main(String[] args) {
        
        try{
            System.out.println("Carregando driver JDBC...");
            Class.forName(driverJDBC);
            System.out.println("Driver Carregado!");
        }catch(ClassNotFoundException e){
            System.out.printf("Falha no carregamento. %s", e);
        }
        
        Scanner scanner = new Scanner(System.in);
        
        int opcao = 0;
        
        while(opcao != 8){
            System.out.println("\n-----Banco de dados Doceria Beijo de Mel-----");
            System.out.println("1: Criar a tabela 'Doces'");
            System.out.println("2: Inserir doce");
            System.out.println("3: Modificar doce pelo nome");
            System.out.println("4: Remover dados da tabela por nome");
            System.out.println("5: Limpar os dados da tabela");
            System.out.println("6: Ver lista atual de doces");
            System.out.println("7: Listar os doces com menos de 3,5kg restantes");
            System.out.println("8: Fechar o sistema");
            System.out.println("---------------------------------------------\n");      
            
            System.out.println("Informe a opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao){
                case 1:
                    CriarTabela.main(args);
                    break;
                case 2:
                    InserirDados.main(args);
                    break;
                case 3:
                    ModificarDados.main(args);
                    break;
                case 4:
                    RemoverDados.main(args);
                    break;                    
                case 5:
                    LimparLista.main(args);
                    break;
                case 6:
                    ListarDados.main(args);
                    break;
                case 7:
                    ListarDocesAcabando.main(args);
                    break;
                case 8:
                    System.out.println("\nFechando o sitema...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Digite uma opção de 1 a 8.");
                    break;
            }
            System.out.printf("\n");
        }
    }
}

