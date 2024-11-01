/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import beans.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import javabd01.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


        

/**
 *
 * @author iagov
 */
public class PessoaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public PessoaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    public void inserir (Pessoa pessoa){
        String sql = "INSERT INTO pessoa (nome, sexo, idioma) VALUES (?,?,?);";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getIdioma());
            stmt.execute();
        }
        catch(SQLException ex){
            System.out.println ("Erro ao inserir pessoa: "+ex.getMessage());
        }
    }
    
    public List<Pessoa> getPessoas(){
        String sql = "SELECT * FROM pessoa";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = stmt.executeQuery(); //Obtenho o retorno da consulta e retorno no resultset
            List<Pessoa> lp = new ArrayList();
            
            while (rs.next()){
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setSexo(rs.getString("sexo"));
                p.setIdioma(rs.getString("idioma"));
                lp.add(p);
            }
            return lp;
        }catch (SQLException ex){
            System.out.println ("Erro ao consultar pessoa: "+ex.getMessage());
            return null;
        }
    }
    public Pessoa getPessoa(int id){ //Esse é para aparecer a pessoa dentro do programa
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement (sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //O parametro é o tipo do ResultSet, esse tipo de ResultSet  é sensivel a alterações 
            //feitas no banco de dados, ou seja, as modificações feitas no banco refletem no resultSet
            //o outro paramentro é sobre os parametros de concorrencia - pode ser "read only" ou atualizavel
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(); //Obtenho o retorno da consulta e armazena no ResultSet
            Pessoa p = new Pessoa();//Preparo do objeto que vou armazenar a consulta
            //Primeiramente, vamos posicionar o retorno da consulta (ResultSet) na primeira posição de consulta
            //Em alguns casos, a consulta terá mais de um resultado de retorno
            rs.first();
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setSexo(rs.getString("sexo"));
            p.setIdioma(rs.getString("idioma"));
            return p;
        }catch (SQLException ex){
            System.out.println ("ERRO AO CONSULTAR PESSOA: "+ex.getMessage());
            return null;
        }
    } 
    public void editar (Pessoa pessoa){ //Esse vamos editar os dados    
        try{
            String sql = "UPDATE pessoa set nome=?, sexo=?, idioma=? WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString (1, pessoa.getNome());
            stmt.setString (2, pessoa.getSexo());
            stmt.setString (3, pessoa.getIdioma());
            stmt.setInt (4, pessoa.getId());
            stmt.execute();
        }catch (SQLException ex){
            System.out.println ("Erro ao atualizar pessoa:"+ex.getMessage());
        }
    }
    public void excluir (int id){ //Excluir a pessoa 
        try{
            String sql = "delete from pessoa WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt (1, id);
            stmt.execute();
        }catch (SQLException ex){
            System.out.println ("ERRO AO ENCONTRAR PESSOA: "+ex.getMessage());
        }
    }
    
     public List<Pessoa> getPessoasNome(String nome,String sexo) {
        String sql = "SELECT * FROM pessoa WHERE nome LIKE ? and sexo LIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setString(1,"%"+nome+"%");
            stmt.setString(2,"%"+sexo+"%");
            ResultSet rs = stmt.executeQuery();
            List<Pessoa> listaPessoas = new ArrayList();
            
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setSexo(rs.getString("sexo"));
                p.setIdioma(rs.getString("idioma"));
                listaPessoas.add(p);
            }
            return listaPessoas;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar todas as pessoas: "+ex.getMessage());
            return null;
        }
    }
}
