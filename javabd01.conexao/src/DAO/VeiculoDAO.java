/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import javabd01.conexao.Conexao;
import java.sql.Connection;
import beans.Veiculo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.Pessoa;
/**
 *
 * @author iagov
 */
public class VeiculoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public VeiculoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
 
    public void inserir (Veiculo v){
       String sql = "INSERT INTO veiculo (modelo, placa, id_pessoa) VALUES(?,?,?);";
       
       try{
           PreparedStatement stmt = this.conn.prepareStatement(sql);
           stmt.setString(1, v.getModelo());
           stmt.setString(2, v.getPlaca());
           stmt.setInt(3, v.getPessoaid().getId());
           stmt.execute();
       } catch(SQLException ex){
           System.out.println ("Erro ao inserir Veiculo: "+ex.getMessage());
       }
    }
    public void editar (Veiculo v){
        try{
           String sql = "UPDATE veiculo set modelo=?, placa=?, id_pessoa=? WHERE id=? ";
           
           PreparedStatement stmt = conn.prepareStatement(sql);
           stmt.setString (1, v.getModelo());
           stmt.setString(2, v.getPlaca());
           stmt.setInt(3, v.getPessoaid().getId());
           stmt.setInt(4, v.getId());
           stmt.execute();
        }catch (SQLException ex){
            System.out.println ("Erro ao inserir Veiculo: "+ex.getMessage());
        }
    }
    public void excluir (int id){
        try{
            String sql = "delete from veiculo WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        }catch (SQLException ex){
            System.out.println ("Erro ao inserir Veiculo: "+ex.getMessage());
        }
    }
    public Veiculo getVeiculo(int id) {
    String sql = "SELECT * FROM veiculo WHERE id = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        // Configura o parâmetro do ID no PreparedStatement
        stmt.setInt(1, id);

        // Executa a consulta e armazena o resultado no ResultSet
        ResultSet rs = stmt.executeQuery();

        // Cria o objeto Veiculo que será preenchido com os dados do banco
        Veiculo veiculo = new Veiculo();
        
        // Posiciona o cursor do ResultSet no primeiro resultado
        if (rs.first()) {
            // Preenche os dados do veículo a partir do ResultSet
            veiculo.setId(rs.getInt("id"));
            veiculo.setModelo(rs.getString("modelo"));
            veiculo.setPlaca(rs.getString("placa"));

            // Para o campo Pessoa associada, crie o objeto Pessoa se necessário
            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getInt("id_pessoa"));
            veiculo.setPessoaid(pessoa); // Associa a pessoa ao veículo
        } else {
            return null; // Caso não haja resultados, retorna null
        }

        return veiculo;

    } catch (SQLException ex) {
        System.out.println("Erro ao consultar veículo: " + ex.getMessage());
        return null;
    }
  }
}
