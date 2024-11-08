package javabd01.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public Connection getConexao(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdaula01?useTimezone=true&serverTimezone=UTC", "root", "laboratorio");
            System.out.println("Conexão realizada");
            return conn;
        }
        catch (Exception e){
            System.out.println ("Erro ao conectar no BD"+e.getMessage());
            return null;
        }
    }
}
